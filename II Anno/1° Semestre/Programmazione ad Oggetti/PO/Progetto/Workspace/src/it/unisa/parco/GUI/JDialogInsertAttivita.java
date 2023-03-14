package it.unisa.parco.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import it.unisa.Connection.Database;
import it.unisa.Exception.CampiVuotiException;
import it.unisa.parco.Gestore.Attivita;
import it.unisa.parco.Gestore.Parco;
/**
 * 
 * @author Paolo
 * @author Loris Proto
 */
public class JDialogInsertAttivita extends JDialog{
	
	
	/**
	 * Costruisce una finestra di secondo livello posizionata all' interno del pannello JPanelInfoParco
	 * 
	 * @param parco parco di cui si desidera inserire una nuova attività
	 * @param db database per prelevare le informazioni relative al parco che ha effettuato il login
	 * @param table tabella che viene aggiornata nel momento in cui si inserisce una nuova attività.
	 */
	public JDialogInsertAttivita(Parco parco, Database db, JTable table){
		
		this.parco=parco;
		this.db=db;
		this.table=table;
		
		this.add(creatPanel());

		this.setTitle("Inserimento Nuova Attivita");
		this.setSize(new Dimension(600,700));;
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	
	/**
	 * Questo metodo crea un pannello che include informazioni per inserire una nuova attivita all'interno di un parco.Inoltre adotta un layout
	 * a  "Griglia" per disporre i vari componenti
	 * 
	 * @return JPanel
	 */
	public JPanel creatPanel(){
		
		JPanel panel= new JPanel();
				
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		
		panel.setLayout(layout);

		
		JLabel lnome= new JLabel("Nome: ");
		ParcoFrame.set(lim,0,1,1,1,GridBagConstraints.BOTH,1,1);
		lnome.setFont(ParcoFrame.font);
		panel.add(lnome,lim);
		
		JTextField nometext= new JTextField(20);
		nometext.setInputVerifier(new MyStandardVerifier());
		nometext.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,1,1,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(nometext, lim);
		
		JLabel lorainizio= new JLabel("Ora Inizio: ");
		lorainizio.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,2,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lorainizio,lim);
		
		
		
		String[] orastring= {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		SpinnerListModel hourmodelstart = new SpinnerListModel(orastring);
		JSpinner orainizio = new JSpinner(hourmodelstart);
		orainizio.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,1,2,1,1,GridBagConstraints.NONE,0,0);
		panel.add(orainizio, lim);
		
		JLabel lorafine= new JLabel("Ora Fine: ");
		lorafine.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,3,1,1,GridBagConstraints.BOTH,0,0);
		panel.add(lorafine,lim);
		
		SpinnerListModel hourmodelend = new SpinnerListModel(orastring);
		JSpinner orafine = new JSpinner(hourmodelend);	
		orafine.setFont(ParcoFrame.font);
		orafine.setEnabled(false);
		ParcoFrame.set(lim,1,3,1,1,GridBagConstraints.NONE,1,1);
		panel.add(orafine, lim);
		
		
		JLabel lcosto=new JLabel("Costo");
		lcosto.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,4,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lcosto, lim);
		
		DecimalFormatSymbols separatore = new DecimalFormatSymbols(Locale.ENGLISH);
		DecimalFormat df = new DecimalFormat("#.##");
		df.setDecimalFormatSymbols(separatore);
		JFormattedTextField costotext=new JFormattedTextField(df);
		costotext.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,1,4,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(costotext, lim);
		
		
		JButton badd=new JButton("Aggiungi");
		badd.setFont(ParcoFrame.font);
		badd.setBackground(Color.WHITE);
		ParcoFrame.set(lim,3,4,1,1,GridBagConstraints.VERTICAL,1,1);
		panel.add(badd, lim);
		
		class ChangeOraInizioListener implements ChangeListener{
			
			public void stateChanged(ChangeEvent arg0) {
				
				orafine.setEnabled(true);
			
			}
		}
		
		
		class ClickAddListener implements ActionListener{
		
			public void actionPerformed(ActionEvent e){
				

				try{
					
					controllaCampiVuoti(orafine,nometext,costotext);
				}
				
				catch(CampiVuotiException ex){
					JOptionPane m= new JOptionPane();

					m.showMessageDialog(null, ex.getMessage());
					return;
				}
				
				controllaAttivita(nometext,costotext,orainizio,orafine);
		
			}
		}
		
		orainizio.addChangeListener(new ChangeOraInizioListener());
		badd.addActionListener(new ClickAddListener());
		
		return panel;
	}
	
	
	/**
	 * Questo metodo controlla l'inserimento di una nuova attività
	 * 
	 * @param nometext componente che contiene il nome dell'attività
	 * @param costotext componente che contiene il costo dell'attività
	 * @param orainizio componente che contiene l'orario di inizio dell'attivitùà
	 * @param orafine componente che contiene l'orario di fine dell'attività
	 */
	private void controllaAttivita(JTextField nometext, JTextField costotext,JSpinner orainizio,JSpinner orafine){
		
		Time orai= Time.valueOf(String.valueOf(orainizio.getValue()+":00:00"));
		Time oraf= Time.valueOf(String.valueOf(orafine.getValue()+":00:00"));

		
		Attivita a= new Attivita(nometext.getText(),Double.parseDouble(costotext.getText()),orai,oraf);


		
		
		String sql="INSERT INTO attivita(codice,nome,orario_inizio,orario_fine,costo,parco) VALUES('"+
		a.getNome()+"','"+
		a.getNome()+"','"+
		a.getOraInizio()+"','"+
		a.getOraFine()+"','"+
		a.getCosto() +"','"+
		parco.getCodice()+"')";
		
		JOptionPane m= new JOptionPane();
		
		if(!db.eseguiAggiornamento(sql)){
			
			m.showMessageDialog(null, "Errore Inserimento!");
		}
		else{
			
			parco.addAttivita(a);
			m.showMessageDialog(null, "Attività inserita con successo!");
			table.repaint();
		
		}
		
	}
	
	
	/**
	 * Questo metodo controlla se ci sono dei campi di cui non si è inserito nessun valore.
	 * 
	 * @param orafine componente che contiene l'orario di fine dell'attività
	 * @param nometext componente che contiene il nome dell'attività
	 * @param costotext componente che contiene il costo dell'attività
	 * @exception CampiVuotiException viene lanciata nel momento in cui ci sono dei campi non compilati
	 */
	private void controllaCampiVuoti(JSpinner orafine, JTextField nometext, JTextField costotext){
		
			if(!orafine.isEnabled() || nometext.getText().length()==0 || costotext.getText().length()==0){

				throw new CampiVuotiException("Campi vuoti!");
				
			}

	}
	

	
	
	private class MyStandardVerifier extends InputVerifier {
		/**
		 * Questo metodo controlla correttezza dei valori digitati all'interno di un campo attraverso un espressione regolare.
		 * 
		 * @return boolean vero se la stringa presa in ingresso segue un certo pattern, altrimenti false
		 */
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
		return super.toString() +"[parco=" + parco + ", db=" + db + ", table=" + table + "]";
	}
	private Parco parco;
	private Database db;
	private JTable table;

}
