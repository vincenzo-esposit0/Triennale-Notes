package it.unisa.Agenzia.GUI;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseListener;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;

import it.unisa.Agenzia.Agenzia;
import it.unisa.Agenzia.Cliente;
import it.unisa.Agenzia.Pacchetto;
import it.unisa.Connection.Database;
import it.unisa.parco.GUI.ParcoFrame;
import it.unisa.parco.GUI.TableBigliettiParcoModel;
import it.unisa.parco.Gestore.Parco;
import it.unisa.parco.Gestore.Promozione;

public class JPanelVisualizza extends JPanel{
	
	/**
	 * Costruisce un nuovo pannello che viene posizionato al centro del frame AgenziaFrame.
	 * 
	 * @param db 	database per prelevare le informazioni relativi all'agenzia che ha effettuato il login
	 * @param agenzia agenzia su cui si vogliono visualizzare i pacchetti venduti e prenotati
	 */
	public JPanelVisualizza(Database db, Agenzia agenzia){
		
		this.agenzia=agenzia;
		this.db=db;
		
		this.setLayout(new BorderLayout());
		
		add(creatPanelNord(),BorderLayout.NORTH);
		add(creatPanelCenter(),BorderLayout.CENTER);
		
		
	}
	
	/**
	 * Questo metodo crea un pannello che viene posizionato a nord del pannello principale. Inoltre il pannello viene suddiviso tramite un layoutmanager a forma di "Griglia"
	 * per posizionare i vari componenti. Le informazioni relative alla visualizzazione dei pacchetti venduti vengono visualizzati
	 * in forma tabellare in una tabella. Inoltre presenta un campo descrizione che visualizza la descrizione del pacchetto selezionato.
	 * 
	 * @return JPanel pannello che viene posizionato a nord del pannello principale
	 */
	public JPanel creatPanelNord(){
			
		String sql="SELECT p.codice, p.nome, p.descrizione, p.prezzo,p.numbiglietti, p.data_acquisto, p.data_prenotazione, c.*, p.parco "
				+ " FROM pacchetto p JOIN cliente c ON p.cliente=c.cf"
				+ " WHERE p.agenzia='"+agenzia.getPIva()+"' and p.data_acquisto IS NOT NULL";
		
		
		Vector v = db.eseguiQuery(sql);

		if(v.size()>0){
			
			
			for(int i=0;i<v.size();i++){
				
				String[] resultpacchettoacq= (String[]) v.get(i);


				agenzia.addPacchettoVenduto(new Pacchetto(resultpacchettoacq[0], resultpacchettoacq[1],resultpacchettoacq[2],Double.parseDouble(resultpacchettoacq[3]), Integer.parseInt(resultpacchettoacq[4]),new Parco(resultpacchettoacq[11])));
				Cliente cliente= new Cliente(resultpacchettoacq[7],resultpacchettoacq[8],resultpacchettoacq[9], Integer.parseInt(resultpacchettoacq[10]));
				String[] datacquisto = resultpacchettoacq[5].split("-");
				GregorianCalendar datacquistog= new GregorianCalendar(Integer.parseInt(datacquisto[0]),Integer.parseInt(datacquisto[1]),Integer.parseInt(datacquisto[2]),0,0,0);
				agenzia.getPacchettiVenduti().get(i).setDataAcquisto(datacquistog);
				
				if(resultpacchettoacq[6]!=null){
					
					String[] dataprenotazione = resultpacchettoacq[6].split("-");
					GregorianCalendar dataprenotazioneg= new GregorianCalendar(Integer.parseInt(dataprenotazione[0]),Integer.parseInt(dataprenotazione[1]),Integer.parseInt(dataprenotazione[2]),0,0,0);
					agenzia.getPacchettiVenduti().get(i).setDataPrenotazione(dataprenotazioneg);
				}
				agenzia.getPacchettiVenduti().get(i).setCliente(cliente);
			}
			
		}
		
		JPanel panel= new JPanel();
		
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		panel.setLayout(layout);
		lim.insets.top=10;
		lim.insets.bottom=10;
		lim.insets.right=10;
		lim.insets.left=10;

		
		JLabel lpacchettiac= new JLabel("Pacchetti Venduti");
		lpacchettiac.setFont(AgenziaFrame.font);
		AgenziaFrame.set(lim,0,0,1,1,GridBagConstraints.BOTH, 0,0);
		panel.add(lpacchettiac,lim);
		
		
		TablePacchettiAgenziaModel pacchettimodel= new TablePacchettiAgenziaModel(agenzia.getPacchettiVenduti());
		AgenziaFrame.set(lim,0,1,1,1,GridBagConstraints.BOTH, 0,0);
		JTable table= new JTable(pacchettimodel);
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setMinWidth(0);
		col.setMaxWidth(0);
		col.setPreferredWidth(0);
		col.setResizable(false);
				
		table.setPreferredScrollableViewportSize(new Dimension(980,100));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		JScrollPane jps= new JScrollPane(table);
		panel.add(jps,lim);
		
		
		
		JLabel ldesc1= new JLabel("Descrizione");
		ldesc1.setFont(AgenziaFrame.font);
		AgenziaFrame.set(lim,0,2,1,1,GridBagConstraints.BOTH, 0,0);
		panel.add(ldesc1,lim);
		
		
		JTextArea ldescrizione_value= new JTextArea();
		ldescrizione_value.setFont(ParcoFrame.font);
		ldescrizione_value.setPreferredSize(new Dimension(0,100));
		ParcoFrame.set(lim,0,3,1,1,GridBagConstraints.BOTH,1,1);
		JScrollPane pane = new JScrollPane(ldescrizione_value,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(pane,lim);
		
		table.addMouseListener(new MouseListener(){
			
			
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				
				controllaRigaSelezionata(table, ldescrizione_value);

			}
			
			public void mouseEntered(java.awt.event.MouseEvent arg0) {}

			public void mouseExited(java.awt.event.MouseEvent arg0) {}

			public void mousePressed(java.awt.event.MouseEvent arg0) {}

			public void mouseReleased(java.awt.event.MouseEvent arg0) {}
			
			
		});
		
		
		
		
		panel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		
		return panel;
	}
	
	
	/**
	 * Questo metodo crea un pannello che viene posizionato a centro del pannello principale. Inoltre il pannello viene suddiviso tramite un layoutmanager a forma di "Griglia"
	 * per posizionare i vari componenti. Le informazioni relative alla visualizzazione dei pacchetti prenotati vengono visualizzati
	 * in forma tabellare in una tabella. Inoltre presenta un campo descrizione che visualizza la descrizione del pacchetto selezionato.
	 * 
	 * @return JPanel pannello che viene posizionato a centro del pannello principale
	 */
	public JPanel creatPanelCenter(){
		
		JPanel panel= new JPanel();
		
		String sql="SELECT p.codice, p.nome, p.descrizione, p.prezzo,p.numbiglietti, p.data_acquisto, p.data_prenotazione, c.*, p.parco "
				+ " FROM pacchetto p JOIN cliente c ON p.cliente=c.cf"
				+ " WHERE p.agenzia='"+agenzia.getPIva()+"' and p.data_prenotazione IS NOT NULL and p.data_acquisto IS NULL";
		
		Vector v = db.eseguiQuery(sql);

		if(v.size()>0){
			
			for(int i=0;i<v.size();i++){

				String[] resultpacchettoprenotato= (String[]) v.get(i);
				agenzia.addPacchettoPrenotato(new Pacchetto(resultpacchettoprenotato[0], resultpacchettoprenotato[1],resultpacchettoprenotato[2],Double.parseDouble(resultpacchettoprenotato[3]), Integer.parseInt(resultpacchettoprenotato[4]),new Parco(resultpacchettoprenotato[11])));
				Cliente cliente= new Cliente(resultpacchettoprenotato[7],resultpacchettoprenotato[8],resultpacchettoprenotato[9], Integer.parseInt(resultpacchettoprenotato[10]));
				String[] dataprenotazione = resultpacchettoprenotato[6].split("-");
				GregorianCalendar dataprenotazioneg= new GregorianCalendar(Integer.parseInt(dataprenotazione[0]),Integer.parseInt(dataprenotazione[1]),Integer.parseInt(dataprenotazione[2]),0,0,0);
				agenzia.getPacchettiPrenotati().get(i).setDataPrenotazione(dataprenotazioneg);
				agenzia.getPacchettiPrenotati().get(i).setCliente(cliente);
			}
			
		}
		

		
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		panel.setLayout(layout);
		lim.insets.top=10;
		lim.insets.bottom=10;
		lim.insets.right=10;
		lim.insets.left=10;
		
		JLabel lpacchettipren= new JLabel("Pacchetti Prenotati");
		lpacchettipren.setFont(AgenziaFrame.font);
		AgenziaFrame.set(lim,0,0,1,1,GridBagConstraints.BOTH, 0,0);
		panel.add(lpacchettipren,lim);
		
		TablePacchettiAgenziaModel pacchettimodel= new TablePacchettiAgenziaModel(agenzia.getPacchettiPrenotati());
		AgenziaFrame.set(lim,0,1,1,1,GridBagConstraints.BOTH, 0,0);
		JTable table2= new JTable(pacchettimodel);	
		TableColumn col = table2.getColumnModel().getColumn(0);
		col.setMinWidth(0);
		col.setMaxWidth(0);
		col.setPreferredWidth(0);
		col.setResizable(false);
		table2.setPreferredScrollableViewportSize(new Dimension(980,100));
		table2.setFillsViewportHeight(true);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jps= new JScrollPane(table2);
		panel.add(jps,lim);
		
		
		JLabel ldesc1= new JLabel("Descrizione");
		ldesc1.setFont(AgenziaFrame.font);
		AgenziaFrame.set(lim,0,2,1,1,GridBagConstraints.BOTH, 0,0);
		panel.add(ldesc1,lim);
		
		JTextArea ldescrizione_value2= new JTextArea();
		ldescrizione_value2.setEditable(false);
		ldescrizione_value2.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,3,1,1,GridBagConstraints.BOTH,1,1);
		JScrollPane pane = new JScrollPane(ldescrizione_value2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(pane,lim);
		
		table2.addMouseListener(new MouseListener(){
			
			
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				
				controllaRigaSelezionata(table2, ldescrizione_value2);
			}
			
			public void mouseEntered(java.awt.event.MouseEvent arg0) {}

			public void mouseExited(java.awt.event.MouseEvent arg0) {}

			public void mousePressed(java.awt.event.MouseEvent arg0) {}

			public void mouseReleased(java.awt.event.MouseEvent arg0) {}
			
			
		});
		
	

		return panel;
	}
	
	/**
	 * Questo metodo controlla se la riga selezionata all'interno della tabella è valida o meno. Se è valida popola il campo descrizione relativo al pacchetto selezionato.
	 * 
	 * @param table tabella dove vengono visualizzate le informazioni
	 * @param ldescrizione_value area dove viene visualizzata la descrizione del pacchetto selezionato
	 */
	private void controllaRigaSelezionata(JTable table, JTextArea ldescrizione_value){
		
		
		if(table.getSelectedRow()!=-1){
			int row= table.getSelectedRow();
			Pacchetto p= (Pacchetto) table.getValueAt(row, 0);
			ldescrizione_value.setText(p.getDescrizione());
		}
	}


	
	
	public String toString() {
		return super.toString() +"[db=" + db + ", agenzia=" + agenzia + "]";
	}



	private Database db;
	private Agenzia agenzia;

}
