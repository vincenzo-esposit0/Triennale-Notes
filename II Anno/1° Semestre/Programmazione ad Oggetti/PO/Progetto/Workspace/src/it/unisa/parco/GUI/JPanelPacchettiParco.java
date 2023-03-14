package it.unisa.parco.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumn;
import com.mysql.jdbc.Connection;

import it.unisa.Agenzia.Agenzia;
import it.unisa.Agenzia.Cliente;
import it.unisa.Agenzia.Pacchetto;
import it.unisa.Connection.Database;
import it.unisa.Exception.NoPromoException;
import it.unisa.parco.Gestore.Attivita;
import it.unisa.parco.Gestore.Parco;
import it.unisa.parco.Gestore.ParcoAcquatico;
import it.unisa.parco.Gestore.ParcoAvventura;
import it.unisa.parco.Gestore.ParcoTematico;
import it.unisa.parco.Gestore.Promozione;

public class JPanelPacchettiParco  extends JPanel{
	
	/**
	 * Costruisce un nuovo pannello che viene posizionato al centro del frame ParcoFrame.
	 * 
	 * @param parco parco su cui si vogliono visualizzare le relative informazioni ai pacchetti offerti dalle agenzia convenzionate
	 * @param db database per prelevare le informazioni relative al parco che si è selezionato
	 */
	public JPanelPacchettiParco(Parco parco, Database db){
		
		this.parco=parco;
		this.db=db;
		this.setLayout(new BorderLayout());
		
		
		add(creatPanelNord(),BorderLayout.NORTH);
		add(creatPanelCenter(),BorderLayout.CENTER);
		
		
		
		
	}
	
	/**
	 * Questo metodo crea un pannello che viene posizionato a nord del pannello principale. Richiama il metodo della classe parco per popolare le 
	 * agenzia convenzionate col parco per poi popolare i pacchetti che le relative agenzia hanno offerto per questo determinato parco. E' possibile
	 * scegliere tramite una combobox l'agenzia che si vuole visualizzare i pacchetti ad esso offerti.
	 * 
	 * @return JPanel pannello che viene posizionato a nord del pannello principale
	 */
	public JPanel creatPanelNord(){
		
		
		String sql="SELECT agenzia.piva, agenzia.nome, agenzia.indirizzo, agenzia.tel, agenzia.incasso from agenzia JOIN convenzione ON convenzione.agenzia=agenzia.piva WHERE convenzione.parco='"+parco.getCodice()+"'";
		db.eseguiQuery(sql);
		
		
		Vector v= db.eseguiQuery(sql);
		


		
		for(int i=0;i<v.size();i++){
			
			String[] resultagenzia= (String[]) v.get(i);
		
			parco.addAgenzia(new Agenzia(resultagenzia[0],resultagenzia[1],resultagenzia[2],resultagenzia[3],Double.parseDouble(resultagenzia[4])));
	
			
			String sqlpacchetto= "SELECT pacchetto.codice, pacchetto.nome, pacchetto.descrizione, pacchetto.prezzo, pacchetto.numbiglietti, pacchetto.parco "
					+ "FROM pacchetto JOIN parco on pacchetto.parco=parco.codice JOIN agenzia ON agenzia.piva=pacchetto.agenzia "
					+ "WHERE pacchetto.agenzia='"+resultagenzia[0]+"' and pacchetto.parco='"+parco.getCodice()+"'";
				
				Vector ve = db.eseguiQuery(sqlpacchetto);
	
				for(int j=0;j<ve.size();j++){
				
					String[] resultpacchetto= (String[]) ve.get(j);
					
					parco.getAgenzie().get(i).creaPacchetto(resultpacchetto[0], resultpacchetto[1], resultpacchetto[2], Double.parseDouble(resultpacchetto[3]),Integer.parseInt(resultpacchetto[4]),new Parco(resultpacchetto[5]));

				}
				
		}
		
		JPanel panel= new JPanel();
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		panel.setLayout(layout);
		
		JLabel lpartitaiva= new JLabel();
		lpartitaiva.setText("Elenco Agenzie - Partita Iva");
		lpartitaiva.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,0,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(lpartitaiva);
		
		JComboBox check= new JComboBox();
		check.setPreferredSize(new Dimension(200,30));
		check.setBackground(Color.WHITE);
		check.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,1,5,1,GridBagConstraints.HORIZONTAL,1,1);
		for(Agenzia a:parco.getAgenzie()){
			check.addItem(a.getPIva());	
		}
		check.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e){
				
				controllaCheckSelezionata(check);
				
			}
		});
		
		panel.add(check, lim);

		return panel;		
		
	}
	
	/**
	 * Questo metodo crea un pannello che viene posizionato al centro del pannello principale. Permette di visualizzare
	 * le informazioni sui pacchetti che una determinata agenzia vende per questo parco in forma tabellare.
	 * 
	 * @return JPanel pannello che viene posizionato al centro del pannello principale
	 */
	public JPanel creatPanelCenter(){

		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		JLabel label=new JLabel("Pacchetti Vendita");
		label.setFont(ParcoFrame.font);
		panel.add(label,BorderLayout.NORTH);	
		
		pacchettimodel= new TablePacchettiParcoModel();
		table= new JTable(pacchettimodel);
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setMinWidth(0);
		col.setMaxWidth(0);
		col.setPreferredWidth(0);
		col.setResizable(false);
		
		table.setPreferredScrollableViewportSize(new Dimension(980,100));
		table.setFillsViewportHeight(true);
		JScrollPane jps= new JScrollPane(table);
		panel.add(jps,BorderLayout.CENTER);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	

	
		panel.setBackground(Color.ORANGE);
		panel.setBorder(ParcoFrame.bordo);
		panel.setPreferredSize(new Dimension(1056,323));
		
		
		return panel;
		
	}
	
	/**
	 * Questo metodo controlla l'agenzia selezionata tramite la combobox messa a disposizione dal pannello a nord del pannello principale.
	 * In base alla partita iva dell'agenzia selezionata si ricava tutte le informazioni su quella agenzia, inclusi i pacchetti che mette in vendita
	 * per questo parco. Ogni volta che si seleziona una agenzia dalla combobox viene ripulita la tabella che visualizza i pacchetti in vendita dell'agenzia
	 * per poi aggiungere i nuovi pacchetti della relativa agenzia selezionata
	 * 
	 * 
	 * @param check combobox che contiene il nome e la partita iva delle agenzie convenzionate con questo parco
	 */
	private void controllaCheckSelezionata(JComboBox check){
		
			pacchettimodel.removeAllRows();
			TableColumn col = table.getColumnModel().getColumn(0);
			col.setMinWidth(0);
			col.setMaxWidth(0);
			col.setPreferredWidth(0);
			col.setResizable(false);
			
			Agenzia agenziasel=null;
			for(Agenzia a:parco.getAgenzie()){
				
				if(a.getPIva().equals(String.valueOf(check.getSelectedItem()))){
					
					agenziasel=a;
					
				}
				
			}
			
			for(Pacchetto p:agenziasel.getPacchetti()){
				
				pacchettimodel.aggiunPacchetto(p);
				
			}
		
	}
	
	
	
	public String toString() {
		return super.toString() +"[parco=" + parco + ", db=" + db + ", pacchettimodel=" + pacchettimodel + ", table="
				+ table + "]";
	}



	private Parco parco=null;
	private Database db=null;
	private TablePacchettiParcoModel pacchettimodel;
	private JTable table;

}
