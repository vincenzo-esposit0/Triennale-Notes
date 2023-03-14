package it.unisa.Agenzia.GUI;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unisa.Agenzia.Agenzia;
import it.unisa.Agenzia.Cliente;
import it.unisa.Agenzia.Pacchetto;
import it.unisa.Connection.Database;
import it.unisa.Exception.CampiVuotiException;
import it.unisa.Exception.IllegalClienteException;
public class JPanelVendi extends JPanel{
	

	public JPanelVendi(Database db, Agenzia agenzia){
		
		this.db=db;
		this.agenzia=agenzia;
		this.setLayout(new BorderLayout());
		
		add(creatPanelNord(),BorderLayout.NORTH);
		add(creatPanelCenter(),BorderLayout.CENTER);
		
	}
	
	/**
	 * Azione compiuta dal pannello nord : selezione del pacchetto da acquistare 
	 * 
	 * @return JPanel pannello che viene posizionato a nord del pannello principale
	 */
	public JPanel creatPanelNord(){

		JPanel panel=new JPanel();
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		panel.setLayout(layout);
		
		
		JLabel lpacchetti= new JLabel("Seleziona pacchetto da acquistare");
		AgenziaFrame.set(lim,0,0,1,1,GridBagConstraints.HORIZONTAL,1,1);
		lpacchetti.setFont(AgenziaFrame.font);
		panel.add(lpacchetti,lim);
		
		combotipo= new JComboBox();
		combotipo.setName("combotipo");
		combotipo.setFont(AgenziaFrame.font);
		combotipo.setBackground(Color.WHITE);
		AgenziaFrame.set(lim,0,1,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(combotipo, lim);
		for(Pacchetto p: agenzia.getPacchetti()){
			
			combotipo.addItem(p.getCodice());
			
		}
		
		for(Pacchetto p: agenzia.getPacchettiPrenotati()){
			
			combotipo.addItem(p.getCodice());
			
		}
		
		
		panel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		return panel;
		
	}
	
	/**
	 * Azione compiuta dal pannello nord : inserimento del codice fiscale 
	 * 
	 * @return JPanel pannello che viene posizionato al centro del pannello principale
	 */
	public JPanel creatPanelCenter(){

		JPanel panel=new JPanel();
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		panel.setLayout(layout);	
		lim.insets.left=5;
		lim.insets.right=5;
		
		JLabel lcf= new JLabel("Codice Fiscale");
		AgenziaFrame.set(lim,0,0,1,1,GridBagConstraints.HORIZONTAL,0,1);
		lcf.setFont(AgenziaFrame.font);
		panel.add(lcf,lim);
		
		JTextField cftext= new JTextField();
		cftext.setFont(AgenziaFrame.font);
		cftext.setBackground(Color.WHITE);
		AgenziaFrame.set(lim,1,0,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(cftext,lim);
		cftext.setInputVerifier(new InputVerifier(){
			/**
			 * Questo metodo boolean garantisce che nel campo codice non vi siano presenti caratteri non consentiti
			 */
			public boolean verify(JComponent input) {
				
				String text = ((JTextField) input).getText();
				Pattern p = Pattern.compile("^[a-zA-Z0-9]{16}$");
				Matcher matcher= p.matcher(text);
				
				if(!matcher.matches()){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Campo Codice Fiscale non corretto! Solo caratteri alfanumerici! Esattamente 16 caratteri!");
					return false;	
					
				}
				
				return true;
			}
			
		});
		
		
		JLabel lnome= new JLabel("Nome");
		AgenziaFrame.set(lim,0,1,1,1,GridBagConstraints.HORIZONTAL,0,1);
		lnome.setFont(AgenziaFrame.font);
		panel.add(lnome,lim);
		
		JTextField nometext= new JTextField();
		nometext.setFont(AgenziaFrame.font);
		nometext.setBackground(Color.WHITE);
		AgenziaFrame.set(lim,1,1,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(nometext,lim);
		nometext.setInputVerifier(new InputVerifier(){
			/**
			 * Questo metodo boolean garantisce che nel campo nome non vi siano presenti caratteri non consentiti
			 */
			public boolean verify(JComponent input) {
				
				String text = ((JTextField) input).getText();
				Pattern p = Pattern.compile("^[a-zA-Z0-9\\s]{1,45}$");
				Matcher matcher= p.matcher(text);
				
				if(!matcher.matches()){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Campo Nome non corretto! Solo caratteri alfanumerici! MAX 45 caratteri!");
					return false;	
					
				}
				
				return true;
			}
			
		});
		
		JLabel lcognome= new JLabel("Cognome");
		AgenziaFrame.set(lim,0,2,1,1,GridBagConstraints.HORIZONTAL,0,1);
		lcognome.setFont(AgenziaFrame.font);
		panel.add(lcognome,lim);
		
		JTextField cognometext= new JTextField();
		cognometext.setFont(AgenziaFrame.font);
		cognometext.setBackground(Color.WHITE);
		AgenziaFrame.set(lim,1,2,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(cognometext,lim);
		cognometext.setInputVerifier(new InputVerifier(){
			/**
			 * Questo metodo boolean garantisce che nel campo cognome non vi siano presenti caratteri non consentiti
			 */
			public boolean verify(JComponent input) {
				
				String text = ((JTextField) input).getText();
				Pattern p = Pattern.compile("^[a-zA-Z\\s]{1,45}$");
				Matcher matcher= p.matcher(text);
				
				if(!matcher.matches()){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Campo Cognome non corretto! Solo caratteri  alfabetici! MAX 45 caratteri!");
					return false;	
					
				}
				
				return true;
			}
			
		});
		
		JLabel leta= new JLabel("Eta");
		AgenziaFrame.set(lim,0,3,1,1,GridBagConstraints.HORIZONTAL,0,1);
		leta.setFont(AgenziaFrame.font);
		panel.add(leta,lim);
		
		DecimalFormat dfeta = new DecimalFormat("#");
		JFormattedTextField etatext= new JFormattedTextField(dfeta);
		AgenziaFrame.set(lim,1,3,1,1,GridBagConstraints.HORIZONTAL,1,1);	
		etatext.setBackground(Color.WHITE);
		etatext.setFont(AgenziaFrame.font);
		panel.add(etatext,lim);
		
		
		JButton bprenota= new JButton("Acquista");
		bprenota.setBackground(Color.ORANGE);
		bprenota.setFont(AgenziaFrame.font);
		AgenziaFrame.set(lim,0,4,2,1,GridBagConstraints.BOTH,1,1);
		panel.add(bprenota,lim);
		bprenota.addActionListener(new ActionListener(){
			
			/**
			 * Questo metodo avvia la prenotazione del pacchetto. in caso di mancate informazioni
			 * cattura l'ecceziona lancia dal metodo controllaAcquisto.
			 */
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane mess= new JOptionPane();
				
				if(combotipo.getSelectedItem()==null){
					
					mess.showMessageDialog(null, "Non ci sono pacchetti che si possono acquistare!");
				}
				
				try{
					controllaAcquisto(cftext,nometext,cognometext,etatext);
				}
				
				catch(CampiVuotiException ex){
					
					mess.showMessageDialog(null,ex.getMessage());
					
				}
			}
			
			
		});
		
		panel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		return panel;
		
	}
	/**
	 * Metodo per il controllo dell'acquisto. Avviene nel momento in cui tutte le informazioni
	 * sono corrette e presenti 
	 */
	private void controllaAcquisto(JTextField cftext, JTextField nometext, JTextField cognometext, JFormattedTextField etatext){
			
			
			JOptionPane mess= new JOptionPane();
			
			if(combotipo.getSelectedItem()==null){
				
				mess.showMessageDialog(null, "Non ci sono pacchetti che si possono vendere");
			}
			
			else if(cftext.getText().length()==0 || nometext.getText().length()==0 || cognometext.getText().length()==0 || etatext.getText().length()==0){
				
				throw new CampiVuotiException("Campi non compilati!");
				
			}
			
	
			
			else{
				
				Pacchetto pacchettotrovato = null;
				
				for(Pacchetto p:agenzia.getPacchetti()){
					
					if(p.getCodice().equals(String.valueOf(combotipo.getSelectedItem()))){
						pacchettotrovato=p;
						
					}
					
				}
				
				
				for(Pacchetto p:agenzia.getPacchettiPrenotati()){
					
					if(p.getCodice().equals(String.valueOf(combotipo.getSelectedItem()))){
						
						pacchettotrovato=p;
						
					}
					
				}
				
				
				LocalDateTime now = LocalDateTime.now();
				GregorianCalendar datacquisto = new GregorianCalendar(now.getYear(),now.getMonthValue()-1,now.getDayOfMonth());
	
				String datacquistosplit= (String.valueOf(datacquisto.get(Calendar.YEAR)+"-"+datacquisto.get(Calendar.MONTH)+"-"+datacquisto.get(Calendar.DAY_OF_MONTH)));
	
				Cliente c= new Cliente(cftext.getText(),nometext.getText(),cognometext.getText(),Integer.parseInt(etatext.getText()));
				
				
				try{
					agenzia.vendiPacchetto(pacchettotrovato,c, datacquisto);
				}
				
				catch(IllegalClienteException ex){
					
					mess.showMessageDialog(null, ex.getMessage());
					return;
				}
				
				
				String sql="SELECT cf FROM cliente WHERE cliente.cf='"+c.getCf()+"'";
				Vector v= db.eseguiQuery(sql);
				
	
				if(v.size()==0){
					
					String insertcliente="INSERT INTO cliente VALUES('"+c.getCf()+"','"+c.getNome()+"','"+c.getCognome()+"','"+c.getEta()+"')";
					db.eseguiAggiornamento(insertcliente);
				}
				
				
				sql="UPDATE pacchetto SET data_acquisto='"+datacquistosplit+"', cliente='"+c.getCf()+"'"
						+ " WHERE pacchetto.codice='"+pacchettotrovato.getCodice()+"'";
				db.eseguiAggiornamento(sql);
				sql="UPDATE agenzia SET incasso='"+agenzia.getIncasso()+"' WHERE agenzia.piva='"+agenzia.getPIva()+"'";
				db.eseguiAggiornamento(sql);
				mess.showMessageDialog(null, "Acquisto Effettuato con successo!");
				
				upCombo();
				
			}
		}
	

	public void upCombo(){
		
		combotipo.removeAllItems();
		for(Pacchetto p:agenzia.getPacchetti()){
			combotipo.addItem(p.getCodice());
			
		}
		
		
		for(Pacchetto p:agenzia.getPacchettiPrenotati()){
			
			combotipo.addItem(p.getCodice());
		}
	}

	
	
	
	public String toString() {
		return super.toString() +"[agenzia=" + agenzia + ", db=" + db + ", combotipo=" + combotipo + "]";
	}




	private Agenzia agenzia;
	private Database db;
	private JComboBox combotipo;

}
