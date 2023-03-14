package it.unisa.parco.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.sun.glass.events.MouseEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import it.unisa.Agenzia.Cliente;
import it.unisa.Connection.Database;
import it.unisa.Exception.NoPromoException;
import it.unisa.parco.Gestore.Attivita;
import it.unisa.parco.Gestore.Parco;
import it.unisa.parco.Gestore.Promozione;

import java.util.Date;

public class JPanelPromoParco extends JPanel{
	
	/**
	 * Costruisce un nuovo pannello che viene posizionato al centro del frame ParcoFrame.
	 * 
	 * @param parco  parco su cui si vuole compiere di visualizzare le relative promozioni
	 * @param db database per prelevare le informazioni relative al parco selezionato
	 */
	public JPanelPromoParco(Parco parco, Database db){
		
		this.db=db;
		this.parco=parco;
		this.setLayout(new BorderLayout());
		this.add(creatPanelNord(), BorderLayout.NORTH);
		this.add(creatPanelCenter(), BorderLayout.CENTER);
		this.add(creatPanelSud(),BorderLayout.SOUTH);
		
	}
	
	/**
	 * Questo metodo crea un pannello che viene posizionato al centro del pannello principale. Permette di selezionare il tipo di scelta della ricerca della promozione,
	 * per "Attivita" o per "Data". Se viene selezionata la scelta per "Data" allora vengono mostrati i componenti necessari per la determinata scelta, stessa cosa
	 * per quanto riguarda la scelta per "Attività". Inoltre il pannello viene suddiviso con un LayoutManager a "Griglia" per disporre i vari
	 * componenti all'interno.
	 * 
	 * @return JPanel pannello che viene posizionato a nord del pannello principale
	 */
	public JPanel creatPanelNord(){//Inizio panel nord		
		
		
		JPanel panel= new JPanel();
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		lim.insets.top=10;
		lim.insets.bottom=10;
		lim.insets.left=10;
		lim.insets.right=10;
		panel.setLayout(layout);
		
		JComboBox check= new JComboBox();
		check.setPreferredSize(new Dimension(200,30));
		check.setBackground(Color.WHITE);
		check.setFont(ParcoFrame.font);
		check.addItem(new String("Data"));
		check.addItem(new String("Attivita"));
		ParcoFrame.set(lim,0,0,5,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(check, lim);
		
		JLabel lricercattivita= new JLabel("Nome Attività");
		ParcoFrame.set(lim,0,1,1,1,GridBagConstraints.BOTH,1,1);
		lricercattivita.setFont(ParcoFrame.font);
		panel.add(lricercattivita, lim);
		lricercattivita.setVisible(false);
		
		
		JTextField textattivita= new JTextField();
		textattivita.setInputVerifier(new MyStandardVerifier());
		textattivita.setBackground(Color.WHITE);
		textattivita.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,2,1,1,GridBagConstraints.BOTH,1,1);
		textattivita.setVisible(false);
		panel.add(textattivita,lim);
		
		JLabel ldatainizio= new JLabel("Data Inizio");
		ParcoFrame.set(lim,0,1,1,1,GridBagConstraints.BOTH,1,1);
		ldatainizio.setFont(ParcoFrame.font);
		panel.add(ldatainizio, lim);
		ldatainizio.setVisible(false);
		
		
		JDateChooser datainiziocal= new JDateChooser();
		datainiziocal.setDate(new GregorianCalendar().getTime());
		JTextFieldDateEditor editor = (JTextFieldDateEditor) datainiziocal.getDateEditor();
		editor.setEditable(false);
		ParcoFrame.set(lim,0,2,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(datainiziocal,lim);
		datainiziocal.setVisible(false);
		
		JLabel ldatafine= new JLabel("Data Fine");
		ParcoFrame.set(lim,1,1,1,1,GridBagConstraints.BOTH,1,1);
		ldatafine.setFont(ParcoFrame.font);
		panel.add(ldatafine, lim);
		ldatafine.setVisible(false);
		
		
		JDateChooser datafinecal= new JDateChooser();
		datafinecal.setDate(new GregorianCalendar().getTime());
		editor=(JTextFieldDateEditor) datafinecal.getDateEditor();
		editor.setEditable(false);
		ParcoFrame.set(lim,1,2,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(datafinecal,lim);
		datafinecal.setVisible(false);
		
		JRadioButton radiodata= new JRadioButton("Data");
		radiodata.setSelected(true);
		ParcoFrame.set(lim,2,2,1,1,GridBagConstraints.NONE,1,1);
		radiodata.setFont(ParcoFrame.font);
		panel.add(radiodata,lim);
		radiodata.setVisible(false);
		
		JRadioButton radioalfa= new JRadioButton("Alfabetico");
		ParcoFrame.set(lim,3,2,1,1,GridBagConstraints.NONE,1,1);
		radioalfa.setFont(ParcoFrame.font);
		panel.add(radioalfa,lim);
		radioalfa.setVisible(false);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radiodata);
		group.add(radioalfa);
		
		
		JButton bricerca= new JButton("Ricerca");
		bricerca.setBackground(Color.WHITE);
		bricerca.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,4,2,1,1,GridBagConstraints.VERTICAL,1,1);
		bricerca.setVisible(false);
		panel.add(bricerca,lim);
	
		
		//Inizio ClickCheckListener
		class ClickCheckListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				JComboBox check=(JComboBox) e.getSource();
				
				if(check.getSelectedItem().equals("Data")){
					
					radiodata.setVisible(false);
					radioalfa.setVisible(false);
					lricercattivita.setVisible(false);
					textattivita.setVisible(false);
					ldatainizio.setVisible(true);
					ldatafine.setVisible(true);
					datainiziocal.setVisible(true);
					datafinecal.setVisible(true);
					bricerca.setVisible(true);
					
				}	
				
				else{
					
					
					datainiziocal.setVisible(false);
					datafinecal.setVisible(false);
					ldatainizio.setVisible(false);
					ldatafine.setVisible(false);
					lricercattivita.setVisible(true);
					textattivita.setVisible(true);
					bricerca.setVisible(true);
					radiodata.setVisible(true);
					radioalfa.setVisible(true);
					
				}
			}			
		}//Fine ClickCheckListener
		
		
		class ClickRicercaListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				bvattivita.setEnabled(false);
				
				if(check.getSelectedItem().equals("Data")){//selezionato check tipo data
					
					
					cercaPromo(datainiziocal,datafinecal);

					
				}// selezionato check tipo data
				
				else{//selezionato check tipo attivita
					
					Attivita attivitatrovata=null;
					
					for(Attivita a:parco.getAttivita()){
						if((a.getNome()).equals(textattivita.getText())){
							
							attivitatrovata =  new Attivita(a.getNome(),a.getCosto(),a.getOraInizio(),a.getOraFine());
						}
						
					}
					
					if(attivitatrovata!=null){
						
						inserisciPromoAttivitaTrovata(attivitatrovata);
							
					}
					
					
					if(radiodata.isSelected()){//inizio radiodata selezionata
						
						cercaPromoRadioData(attivitatrovata);	
					}// fine radiodata selezionata
					
					
					else{//inizio radioalfa selezionata

						cercaPromoRadioAlfa(attivitatrovata);
						
					}//fine radioalfa selezionata

						
				}// fine selezionato check tipo attivita

					
								
			}
				

				
		}
		
		check.addActionListener(new ClickCheckListener());
		bricerca.addActionListener(new ClickRicercaListener());
		
		panel.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
		return panel;
	}	

	/**
	 * Questo metodo crea un pannello che viene posizionato al centro del pannello principale. Carica tutte le promozioni relative al parco per inserirle
	 * visualizzarle in forma tabellare.
	 * 
	 * @return JPanel pannello che viene posizionato al centro del pannello principale
	 */
	//inizio pannello centrale
	public JPanel creatPanelCenter(){
		
		JPanel panel= new JPanel();	
		
		String sql="SELECT promozione.* FROM promozione JOIN parco ON promozione.parco=parco.codice WHERE parco.codice='"+parco.getCodice()+"'";
		
		Vector v=db.eseguiQuery(sql);
		
		for(int i=0;i<v.size();i++){
		
			String[] result= (String[]) v.get(i);
			
			String[] datainizio=result[4].split("-");
			GregorianCalendar tempinizio= new GregorianCalendar(Integer.parseInt(datainizio[0]), Integer.parseInt(datainizio[1]), Integer.parseInt(datainizio[2]));
			String[] datascadenza=result[5].split("-");
			GregorianCalendar tempscadenza= new GregorianCalendar(Integer.parseInt(datascadenza[0]), Integer.parseInt(datascadenza[1]), Integer.parseInt(datascadenza[2]));
			
			parco.addPromozione(new Promozione(result[0], result[1], result[2], Integer.parseInt(result[3]), tempinizio, tempscadenza));
			
			String sql2= "SELECT a.nome, a.orario_inizio, a.orario_fine, a.costo FROM attivita a JOIN promo p ON p.attivita=a.codice WHERE p.promozione='"+ result[0] + "' and p.parco_promo='"+ parco.getCodice() + "' and a.parco='" + parco.getCodice() +"'";
			Vector attivita = db.eseguiQuery(sql2);
			
			for(int j=0;j<attivita.size();j++){
				
				String[] resulta= (String[]) attivita.get(j);
				
				
				parco.getPromozioni().get(i).addAttivita(new Attivita(resulta[0],Double.parseDouble(resulta[3]), Time.valueOf(resulta[1]), Time.valueOf(resulta[2])));;
				
				
			}
				
			
		}
		
		promomodel= new TablePromoParcoModel();
		table= new JTable(promomodel);
		

		
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setMinWidth(0);
		col.setMaxWidth(0);
		col.setPreferredWidth(0);
		col.setResizable(false);
		
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setPreferredScrollableViewportSize(new Dimension(1200,250));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jps= new JScrollPane(table);
		panel.add(jps);
		

		return panel;
	}// fine pannello centrale
	
	/**
	 * Questo metodo crea un pannello che viene posizionato a sud del pannello principale. Inoltre il pannello adotta un layoutManager a "Griglia".
	 *  
	 * @return JPanel pannello che viene posizionato a sud del pannello principale
	 */
	public JPanel creatPanelSud(){

		
		JPanel panel= new JPanel();
		
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();;
		panel.setLayout(layout);
		
		
		JLabel ldescrizione= new JLabel("Descrizione Promo:");
		ldescrizione.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,0,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(ldescrizione, lim);
		
		
		JTextArea ldescrizione_value= new JTextArea();
		ldescrizione_value.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,1,0,3,1,GridBagConstraints.BOTH,1,1);
		JScrollPane pane = new JScrollPane(ldescrizione_value,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(pane,lim);
		
		bvattivita= new JButton("Dettagli Attività");
		bvattivita.setFont(ParcoFrame.font);
		bvattivita.setBackground(Color.WHITE);
		ParcoFrame.set(lim,2,1,1,1,GridBagConstraints.NONE,1,1);
		panel.add(bvattivita, lim);
		bvattivita.setEnabled(false);
		

		class MouseRigaEvent implements MouseListener{
			
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				
				if(table.getSelectedRow()!=-1){
					
					int row= table.getSelectedRow();
					Promozione p= (Promozione) table.getValueAt(row, 0);
					ldescrizione_value.setText(p.getDescrizione());
					bvattivita.setEnabled(true);
					
				}
			}
			
			public void mouseEntered(java.awt.event.MouseEvent arg0) {}

			public void mouseExited(java.awt.event.MouseEvent arg0) {}

			public void mousePressed(java.awt.event.MouseEvent arg0) {}

			public void mouseReleased(java.awt.event.MouseEvent arg0) {}
			
		}
		
		class ClickAttivitaListener implements ActionListener{
				
				public void actionPerformed(ActionEvent e){
					
					int row= table.getSelectedRow();
					Promozione p= (Promozione) table.getValueAt(row, 0);
				
					
					JDialog dialog= new JDialog();	
					
					GridBagLayout layout= new GridBagLayout();
					GridBagConstraints lim= new GridBagConstraints();
					dialog.setLayout(layout);
					JLabel lnumero= new JLabel("Nome: ");
					lnumero.setFont(ParcoFrame.font);
					ParcoFrame.set(lim, 0, 0, 1, 1, GridBagConstraints.BOTH, 1, 1);
					dialog.add(lnumero,lim);
					
					int i=0;
					for(Attivita a: p.getAttivitaInPromo()){
						
						JLabel lattivita= new JLabel(a.getNome());
						lattivita.setFont(ParcoFrame.font);
						ParcoFrame.set(lim,1,i,1,1,GridBagConstraints.HORIZONTAL,1,1);
						dialog.add(lattivita, lim);
						i++;
						
					}
					
					dialog.pack();
					dialog.setLocationRelativeTo(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				
				}
			
		}
				
				
		
		
		bvattivita.addActionListener(new ClickAttivitaListener());
		table.addMouseListener(new MouseRigaEvent());

		panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		panel.setPreferredSize(new Dimension(200,350));
		return panel;
		

		
	}

	/**
	 * Questo metodo controlla se la data di inizio è maggiore della data fine. Se è corretta allora prima ripulisce ciò che c'è all'interno 
	 * della tabella per poi aggiungere le promozioni in riferimento all'attività selezionata.
	 * 
	 * @param datainiziocal data inizio selezionata
	 * @param datafinecal data fine selezionata
	 */
	private void cercaPromo(JDateChooser datainiziocal, JDateChooser datafinecal){
		
		if(datainiziocal.getDate().after(datafinecal.getDate())){
			
			JOptionPane m= new JOptionPane();
			m.showMessageDialog(null, "Data iniziale non corretta!");

		}	
	
		else{
			
			promomodel.removeAllRows();
			TableColumn col = table.getColumnModel().getColumn(0);
			col.setMinWidth(0);
			col.setMaxWidth(0);
			col.setPreferredWidth(0);
			col.setResizable(false);
			
			ArrayList<Promozione >promobydata= new ArrayList<Promozione>();
			
			try{

				promobydata= parco.showPromoByData(datainiziocal, datafinecal);		
					
				for(Promozione p:promobydata){
					
					promomodel.aggiunPromo(p);
					
				}
			}
			
			catch(NoPromoException ex){
				
				JOptionPane message = new JOptionPane();
				message.showMessageDialog(null, ex.getMessage());
			}
			
		}
		
		
		
		
	}
	
	/**
	 * Questo metodo ripulisce la tabella dalle vecchie informazioni per poi aggiungere le nuove informazioni rigaurdanti le promozioni in base
	 * alla nuova ricerca ordinandole, richiamandosi un metodo della classe parco, per data di scadenza.
	 * 
	 * @param attivitatrovata attività relativa al nome dell'attività che si è digitata.
	 */
	private void cercaPromoRadioData(Attivita attivitatrovata){
		
		
		promomodel.removeAllRows();
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setMinWidth(0);
		col.setMaxWidth(0);
		col.setPreferredWidth(0);
		col.setResizable(false);
		
			try{


				ArrayList<Promozione> promobycrono = parco.showPromoCronologico(attivitatrovata);

				for(Promozione p:promobycrono){
					
					promomodel.aggiunPromo(p);
				}
				
			}
			catch(NoPromoException ex){
				
				JOptionPane err2= new JOptionPane();
				err2.showMessageDialog(null, ex.getMessage());
			
			}
			
			catch(NullPointerException ex2){
				
				JOptionPane err3=new JOptionPane();
				err3.showMessageDialog(null, "Attività non esistente in questo parco!");
			}
	}
	
	/**
	 * Questo metodo ripulisce la tabella dalle vecchie informazioni per poi aggiungere le nuove informazioni rigaurdanti le promozioni in base
	 * alla nuova ricerca ordinandole, richiamandosi un metodo della classe parco, lessicograficamente.
	 * 
	 * @param attivitatrovata attività relativa al nome dell'attività che si è digitata.
	 */
	private void cercaPromoRadioAlfa(Attivita attivitatrovata){
		
		
		promomodel.removeAllRows();
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setMinWidth(0);
		col.setMaxWidth(0);
		col.setPreferredWidth(0);
		col.setResizable(false);
		
		try{

			
			ArrayList<Promozione> promobyless = parco.showPromoLessicografico(attivitatrovata);

			for(Promozione p:promobyless){
				
				promomodel.aggiunPromo(p);
			}
			
		}
		catch(NoPromoException ex){
			
			JOptionPane err2= new JOptionPane();
			err2.showMessageDialog(null, ex.getMessage());
		
		}
		
		catch(NullPointerException ex2){
			
			JOptionPane err3=new JOptionPane();
			err3.showMessageDialog(null, "Attività non esistente in questo parco!");
		}
	}
	
	/**
	 * Questo metodo tramite il richiamo di un metodo della classe parco, aggiunge le promozioni relative all'attività che si è scelta di selezionare.
	 * 
	 * @param attivitatrovata attivita che si è scelta di selezionare per mostrare le promozioni
	 */
	private void inserisciPromoAttivitaTrovata(Attivita attivitatrovata){
		
		for(Promozione p: parco.getPromozioni()){
			
			
			for(Attivita pa: p.getAttivitaInPromo()){
				if(pa.getNome().equals(attivitatrovata.getNome())){
					
					attivitatrovata.addPromozione(p);
					
				}
			}
		}
	}
	
	
	/**
	 * Questo metodo controlla correttezza dei valori digitati all'interno di un campo attraverso un espressione regolare.
	 * 
	 * @return boolean vero se la stringa presa in ingresso segue un certo pattern, altrimenti false
	 */
	private class MyStandardVerifier extends InputVerifier {
		
		public boolean verify(JComponent input) {
			
			String text = ((JTextField) input).getText();
			
			Pattern p = Pattern.compile("^[a-zA-Z0-9]{1,25}$");
			Matcher matcher= p.matcher(text);
			
			if(!matcher.matches()){
				
				JOptionPane m= new JOptionPane();
				m.showMessageDialog(null, "Campo Codice non corretto! Solo caratteri alfanumerici! MAX 25 caratteri!");
				return false;	
				
			}
			
			return true;
		}
	}
	
	
	
	public String toString() {
		return super.toString() +"[db=" + db + ", parco=" + parco + ", table=" + table + ", promomodel=" + promomodel
				+ ", bvattivita=" + bvattivita + "]";
	}
	private Database db=null;
	private Parco parco=null;
	private static final Font font= new Font("Verdana", Font.HANGING_BASELINE, 20);
	private static final Border bordo= BorderFactory.createLineBorder(Color.WHITE,3);
	private JTable table=null;
	private TablePromoParcoModel promomodel=null;
	private JButton bvattivita=null;
}
