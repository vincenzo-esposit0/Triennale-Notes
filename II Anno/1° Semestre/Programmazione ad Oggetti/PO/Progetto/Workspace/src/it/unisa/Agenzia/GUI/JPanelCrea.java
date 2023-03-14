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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import it.unisa.Agenzia.Agenzia;
import it.unisa.Agenzia.Pacchetto;
import it.unisa.Connection.Database;
import it.unisa.Exception.CampiVuotiException;
import it.unisa.parco.GUI.ParcoFrame;
import it.unisa.parco.Gestore.Parco;
/**
 * Pannello crea del frame "AgenziaFrame"
 */
public class JPanelCrea extends JPanel{

	public JPanelCrea(Database db, Agenzia agenzia){
		

		
		this.agenzia=agenzia;
		this.db=db;
		this.setLayout(new BorderLayout());
		
		this.add(creatPanelCenter(), BorderLayout.CENTER);
		
		
	}
	
	/**
	 * Azione compiuta dal pannello centrale : creazione di un pacchetto
	 * 
	 * @return JPanel pannello che viene posizionato al centro del pannello principale.
	 */
	public JPanel creatPanelCenter(){
		
		
		String sql="SELECT p.codice, p.nome, p.descrizione, p.prezzo, p.numbiglietti, p.parco from pacchetto p JOIN agenzia ON p.agenzia=agenzia.piva  WHERE p.agenzia='"+agenzia.getPIva()+"'";
		Vector v = db.eseguiQuery(sql);
		ArrayList<Pacchetto> allpacchetti= new ArrayList<Pacchetto>();
		for(int i=0;i<v.size();i++){
			
			
			String[] resulv= (String[]) v.get(i);
			Parco parco= new Parco(resulv[5]);
			allpacchetti.add(new Pacchetto(resulv[0],resulv[1],resulv[2],Double.parseDouble(resulv[3]),Integer.parseInt(resulv[4]),parco));
			
		}
		
		
		JPanel panel= new JPanel();
		sql="SELECT c.parco FROM convenzione c JOIN agenzia a ON c.agenzia=a.piva WHERE a.piva='"+agenzia.getPIva()+"'";
		
		v = db.eseguiQuery(sql);
		
		
		
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		panel.setLayout(layout);
		lim.insets.top=10;
		lim.insets.bottom=10;
		lim.insets.right=10;
		lim.insets.left=10;
		
		JLabel ltipo= new JLabel("Parco: ");
		AgenziaFrame.set(lim,0,0,1,1,GridBagConstraints.BOTH,0,0);
		ltipo.setFont(AgenziaFrame.font);
		panel.add(ltipo,lim);
		
		JComboBox combotipo= new JComboBox();
		combotipo.setFont(AgenziaFrame.font);
		combotipo.setBackground(Color.WHITE);
		AgenziaFrame.set(lim,1,0,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(combotipo, lim);
		for(int i=0;i<v.size();i++){
			
			String[] resultparcoconvenzione=(String[]) v.get(i);
			combotipo.addItem(resultparcoconvenzione[0]);
		}
		
		
		
		JLabel lcodice= new JLabel("Codice: ");
		lcodice.setFont(AgenziaFrame.font);
		AgenziaFrame.set(lim,0,1,1,1,GridBagConstraints.BOTH,0,0);
		panel.add(lcodice,lim);
		
		JTextField codicetext= new JTextField();
		codicetext.setFont(AgenziaFrame.font);
		codicetext.setBackground(Color.WHITE);
		AgenziaFrame.set(lim,1,1,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(codicetext,lim);
		codicetext.setInputVerifier(new InputVerifier(){

			/**
			 * Questo metodo boolean garantisce che nel campo codice non vi siano presenti caratteri non consentiti
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
		});
		
		
		JLabel lnome= new JLabel("Nome: ");
		lnome.setFont(AgenziaFrame.font);
		AgenziaFrame.set(lim,0,2,1,1,GridBagConstraints.BOTH,0,0);
		panel.add(lnome,lim);
		
		JTextField nometext= new JTextField();
		nometext.setFont(AgenziaFrame.font);
		nometext.setBackground(Color.WHITE);
		AgenziaFrame.set(lim,1,2,1,1,GridBagConstraints.HORIZONTAL,1,1);
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
					m.showMessageDialog(null, "Campo nome non corretto! Solo caratteri alfanumerici! MAX 45 caratteri!");
					return false;	
					
				}
				return true;
			}
			
			
			
		});
		
		
		JLabel ldescrizione= new JLabel("Descrizione: ");
		ldescrizione.setFont(AgenziaFrame.font);
		AgenziaFrame.set(lim,0,3,1,1,GridBagConstraints.BOTH,0,0);
		panel.add(ldescrizione,lim);
		
		
		JTextField desctext= new JTextField();
		desctext.setFont(AgenziaFrame.font);
		desctext.setBackground(Color.WHITE);
		AgenziaFrame.set(lim,1,3,1,1,GridBagConstraints.BOTH,1,1);
		JScrollPane jsp= new JScrollPane(desctext,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(jsp,lim);
		
		
		

		JLabel lprezzo= new JLabel("Prezzo: ");
		lprezzo.setFont(AgenziaFrame.font);
		AgenziaFrame.set(lim,0,4,1,1,GridBagConstraints.BOTH,0,0);
		panel.add(lprezzo,lim);
		
		
		DecimalFormatSymbols separatore = new DecimalFormatSymbols(Locale.ENGLISH);
		DecimalFormat df = new DecimalFormat("#.##");
		df.setDecimalFormatSymbols(separatore);
		JFormattedTextField prezzotext= new JFormattedTextField(df);
		prezzotext.setFont(AgenziaFrame.font);
		prezzotext.setBackground(Color.WHITE);
		AgenziaFrame.set(lim,1,4,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(prezzotext,lim);
		
		
		JLabel lbigliettinc= new JLabel("Biglietti Inclusi: ");
		lbigliettinc.setFont(AgenziaFrame.font);
		AgenziaFrame.set(lim,0,5,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lbigliettinc,lim);
		
		DecimalFormatSymbols separatoreint = new DecimalFormatSymbols(Locale.ENGLISH);
		DecimalFormat dfint = new DecimalFormat("#");
		df.setDecimalFormatSymbols(separatoreint);
		JFormattedTextField bigliettinctext= new JFormattedTextField(dfint);
		bigliettinctext.setFont(AgenziaFrame.font);
		bigliettinctext.setBackground(Color.WHITE);
		AgenziaFrame.set(lim,1,5,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(bigliettinctext,lim);
		
		JButton bcrea= new JButton("Crea Pacchetto");
		AgenziaFrame.set(lim,0,6,2,1,GridBagConstraints.BOTH,1,1);
		bcrea.setBackground(Color.ORANGE);
		bcrea.setPreferredSize(new Dimension(1200,50));
		bcrea.setFont(ParcoFrame.font);
		panel.add(bcrea,lim);
		
		bcrea.addActionListener(new ActionListener(){
			
			/**
			 * Questo metodo controlla che siano presenti tutte le informazioni per la creazione di un nuovo pacchetto. in caso contrario lancia un'eccezione
			 */
			public void actionPerformed(ActionEvent e){
					
				try{
					controllaCreazionePacchetto(allpacchetti,combotipo,codicetext,nometext,desctext,prezzotext,bigliettinctext);
				}
				
				catch(CampiVuotiException ex){
					
					JOptionPane mess= new JOptionPane();
					mess.showMessageDialog(null, ex.getMessage());
				}
			}
			
			
		});
		
		
		
		
		panel.setBorder(BorderFactory.createTitledBorder("Nuovo Pacchetto"));
		return panel;
		
		
	}
	
	
	
	/**
	 * Questo metodo controlla che siano presenti tutte le informazioni per la creazione di un nuovo pacchetto. in caso contrario lancia un'eccezione ( elencate tutte le eccezioni )
	 */
	private void controllaCreazionePacchetto(ArrayList<Pacchetto> allpacchetti, JComboBox combotipo,JTextField codicetext, JTextField nometext, JTextField desctext, JFormattedTextField prezzotext, JFormattedTextField bigliettinctext){
		
		JOptionPane mess= new JOptionPane();

		if(combotipo.getSelectedItem()==null){
			
			mess.showMessageDialog(null, "Non ci sono parchi convenzionati!");
		}
		else if(codicetext.getText().length()==0 || nometext.getText().length()==0 || desctext.getText().length()==0 || prezzotext.getText().length()==0 ||bigliettinctext.getText().length()==0){
			
			throw new CampiVuotiException("Campi non compilati!");			
		}
		
		
		else{
			
			for(Pacchetto p: allpacchetti){
				
				if(p.getCodice().equals(codicetext.getText())){
					
					mess.showMessageDialog(null, "Pacchetto con codice già esistente!");
					return;
				}
				
			}
			
			Pacchetto pacchetto = new Pacchetto(codicetext.getText(),nometext.getText(),desctext.getText(),Double.parseDouble(prezzotext.getText()),Integer.parseInt(bigliettinctext.getText()),new Parco(String.valueOf(combotipo.getSelectedItem())));
			agenzia.addPacchetto(pacchetto);
			
			allpacchetti.add(pacchetto);
			String sql="INSERT INTO pacchetto(codice,nome,descrizione,prezzo,numbiglietti,agenzia,parco)"
					+ " VALUES('"+pacchetto.getCodice()+"','"+
					pacchetto.getNome()+"','"+
					pacchetto.getDescrizione()+"','"+
					pacchetto.getPrezzo()+"','"+
					pacchetto.getNumBiglietti()+"','"+
					agenzia.getPIva()+"','"+
					pacchetto.getParco().getCodice()+"')";
					
					
			db.eseguiAggiornamento(sql);
			
			mess.showMessageDialog(null, "Pacchetto inserito con successo!");
			
		}
		
		
	}
	public String toString() {
		return super.toString() + "[db=" + db + ", agenzia=" + agenzia + "]";
	}
	
	Database db;
	Agenzia agenzia;

}
