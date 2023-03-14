package it.unisa.parco.GUI;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.border.EtchedBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumn;

import java.awt.Color;
import java.awt.Component;

import it.unisa.Agenzia.Agenzia;
import it.unisa.Agenzia.Cliente;
import it.unisa.Connection.Database;
import it.unisa.parco.Gestore.Attivita;
import it.unisa.parco.Gestore.Biglietto;
import it.unisa.parco.Gestore.BigliettoPromo;
import it.unisa.parco.Gestore.BigliettoRidotto;
import it.unisa.parco.Gestore.Parco;
import it.unisa.parco.Gestore.Promozione;
import javafx.scene.control.CheckBox;

public class JPanelAgenziaParco  extends JPanel{
	
	/**
	 * Costruisce  un nuovo pannello che viene posizionato al centro del frame ParcoFrame.
	 * 
	 * @param parco parco su cui si vogliono visualizzare le relative informazioni riguardanti le convenzioni con le agenzie
	 * @param db database per prelevare le informazioni relative al parco che si è selezionato
	 */
	JPanelAgenziaParco(Parco parco, Database db){
		
		this.parco=parco;
		this.db=db;
		this.setLayout(new BorderLayout());		
		
		add(creatPanelNord(),BorderLayout.NORTH);
		add(creatPanelCenter(),BorderLayout.CENTER);
		add(creatPanelSud(),BorderLayout.SOUTH);
		
		
		
		
	}
	
	/**
	 * Questo metodo crea un pannello che viene posizionato a nord del panello principale. Vengono caricate tutte le agenzie non convenzionate. Inoltre il
	 * tramite un pulsante "Inserisci Attività",dà la possibilità di aprire una finestra di secondo livello all'interno del pannello principale per inserire
	 * una nuova agenzia.
	 * 
	 * @return JPanel pannello che viene posizionato a nord del pannello principale
	 */
	public JPanel creatPanelNord(){
		
		String sql="SELECT agenzia.piva, agenzia.nome,agenzia.indirizzo, agenzia.tel, agenzia.incasso "
				+ " FROM agenzia"
				+ " WHERE agenzia.piva not in(SELECT convenzione.agenzia"
				+ "	FROM convenzione JOIN parco ON convenzione.parco=parco.codice"
				+ " WHERE convenzione.parco='"+parco.getCodice()+"')";
		
		
		Vector v = db.eseguiQuery(sql);

		JPanel panel= new JPanel();
		
		
		JLabel lconvenziona= new JLabel("Seleziona un agenzia: ");
		lconvenziona.setFont(ParcoFrame.font);
		lconvenziona.setOpaque(true);
		panel.add(lconvenziona);
		
		
	    check= new JComboBox();
		check.setPreferredSize(new Dimension(400,50));

		check.setBackground(Color.WHITE);
		check.setFont(ParcoFrame.font);
		
		agenzienonconvenzionate=new ArrayList<Agenzia>();
		for(int i=0;i<v.size();i++){
			
			String[] resultagenzia= (String[]) v.get(i);
			agenzienonconvenzionate.add(new Agenzia(resultagenzia[0],resultagenzia[1],resultagenzia[2], resultagenzia[3], Double.parseDouble(resultagenzia[4])));	
			check.addItem(agenzienonconvenzionate.get(i).getPIva() + "-" + agenzienonconvenzionate.get(i).getNome());

			
		}
		
		
		check.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				bconvenziona.setVisible(true);
				bconvenziona.setEnabled(true);
				
			}		
			
		});
				
		panel.add(check);
		
		
		
		JButton binserisciagenzia= new JButton("Nuova Agenzia");
		binserisciagenzia.setPreferredSize(new Dimension(250,50));
		binserisciagenzia.setFont(ParcoFrame.font);
		binserisciagenzia.setBackground(Color.WHITE);
		panel.add(binserisciagenzia);
		
		binserisciagenzia.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e){// start JDIALOG
				
				JDialogInsertAgenzia dialog= new JDialogInsertAgenzia(parco,db,table);			
				
				
			}// END JDIALOG
			
		});
		
		return panel;
	}
	
	
	/**
	 * Questo metodo crea un pannello che viene posizionato al centro del pannello principale. Contiene le informazioni
	 * relative alle agenzie convenzionate col relativo parco in forma tabellare
	 * 
	 * @return JPanel pannello che viene posizionato al centro del pannello principale
	 */
	public JPanel creatPanelCenter(){
		
		JPanel panel= new JPanel();
		agenzieparcomodel= new TableAgenzieParcoModel(parco.getAgenzie());
		table= new JTable(agenzieparcomodel);
		
		
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setMinWidth(0);
		col.setMaxWidth(0);
		col.setPreferredWidth(0);
		col.setResizable(false);
		
		
		JLabel label=new JLabel("Agenzie  Convenzionate");
		label.setFont(ParcoFrame.font);
		panel.add(label,BorderLayout.NORTH);	

		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jps= new JScrollPane(table);
		jps.setPreferredSize(new Dimension(1200,500));
		panel.add(jps);
	
		
		
		return panel;
	}
	
	/**
	 * Questo metodo crea un pannello contenente un pulsante che permette di convenzionare un agenzia col determinato parco.
	 * 
	 * @return JPanel pannello che viene posizionato a sud del pannello principale
	 */
	public JPanel creatPanelSud(){
		
		JPanel panel= new JPanel();
	
		bconvenziona=new JButton("Convenziona");
		bconvenziona.setBackground(Color.ORANGE);
		bconvenziona.setFont(new Font("Verdana", Font.HANGING_BASELINE, 35));
		bconvenziona.setPreferredSize(new Dimension(1200,200));
		bconvenziona.setVisible(false);
		bconvenziona.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				controllaAgenzie();
			}
			
			
			
			
		});
		
		panel.add(bconvenziona);
		
		return panel;
	}
	
	/**
	 * Questo metodo controlla se la combobox relativa alle agenzia non convenzionate col parco contiene ancora agenzie non convenzionate.Se non
	 * ci sono lancia un messaggio, altrimenti richiama il metodo della classe parco per inserire una nuova agenzia convenzionata col parco.
	 * 
	 */
	private void controllaAgenzie(){
		
		JOptionPane mess= new JOptionPane();
		String[] resultcheck = (String.valueOf(check.getSelectedItem())).split("-");		
		String sql="INSERT INTO convenzione VALUES('"+resultcheck[0]+"','"+parco.getCodice()+"')";
		
		if(check.getItemCount()==0){
			
			mess.showMessageDialog(null, "Non ci sono agenzie disponibili!");
			return;
		}
		
		if(db.eseguiAggiornamento(sql)){
			
		    Agenzia a2=null;
			for(int i=0;i<agenzienonconvenzionate.size();i++){
					
					if(agenzienonconvenzionate.get(i).getPIva().equals(resultcheck[0])){ 
						
						parco.addAgenzia(agenzienonconvenzionate.get(i));
						check.removeAllItems();
						table.repaint();
						a2=agenzienonconvenzionate.get(i);
													
					}
					
			}
			
			agenzienonconvenzionate.remove(a2);
			
			for(Agenzia a:agenzienonconvenzionate){
				
				check.addItem(a.getPIva()+"-"+a.getNome());
			}
			
			mess.showMessageDialog(null, "Agenzia Convenzionata con successo");
			
			
		}
	
		else{
			
			
			mess.showMessageDialog(null, "Errore!");
		}
	}
	
	
	
	public String toString() {
		return super.toString() +"[db=" + db + ", parco=" + parco + ", bconvenziona=" + bconvenziona + ", check="
				+ check + ", table=" + table + ", agenzieparcomodel=" + agenzieparcomodel + ", agenzienonconvenzionate="
				+ agenzienonconvenzionate + "]";
	}



	private Database db;
	private Parco parco;
	private JButton bconvenziona;
	private JComboBox check;
	private JTable table;
	private TableAgenzieParcoModel agenzieparcomodel;
	private ArrayList<Agenzia> agenzienonconvenzionate;
}
