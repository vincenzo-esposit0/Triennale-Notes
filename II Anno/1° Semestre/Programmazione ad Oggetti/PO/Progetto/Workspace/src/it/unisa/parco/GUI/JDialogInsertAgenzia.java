package it.unisa.parco.GUI;

import java.awt.BorderLayout;
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
import java.util.Vector;
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

import it.unisa.Agenzia.Agenzia;
import it.unisa.Connection.Database;
import it.unisa.Exception.CampiVuotiException;
import it.unisa.parco.Gestore.Attivita;
import it.unisa.parco.Gestore.Parco;
/**
 * 
 * @author Paolo
 * @author Loris Proto
 */
public class JDialogInsertAgenzia extends JDialog{
	

	/**
	 * Costruisce una finestra di secondo livello posizionata all' interno del pannello JPanelAgenziaParco
	 * 
	 * @param parco parco di cui si desidera inserire una nuova attività
	 * @param db database per prelevare le informazioni relative al parco che ha effettuato il login
	 * @param table tabella che viene aggiornata nel momento in cui si inserisce una nuova agenzia.
	 */
	public JDialogInsertAgenzia(Parco parco, Database db, JTable table){
		
		this.db=db;
		this.parco=parco;
		this.table=table;
		this.add(creatPanel());
	
		
		this.setTitle("Inserimento Nuova Agenzia");
		this.setSize(new Dimension(600,700));;
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	/**
	 * Questo metodo crea un pannello che include informazioni per inserire una nuova agenzia all'interno di un parco.Inoltre adotta un layout
	 * a  "Griglia" per disporre i vari componenti
	 * 
	 * @return JPanel pannello che viene posizionato all'interno della finestra di secondo livello
	 */
	public JPanel creatPanel(){
		
		JPanel panel= new JPanel();
		
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		
		panel.setLayout(layout);

		JLabel lpiva= new JLabel("Partita Iva: ");
		ParcoFrame.set(lim,0,0,1,1,GridBagConstraints.HORIZONTAL,1,1);
		lpiva.setFont(ParcoFrame.font);
		panel.add(lpiva,lim);
		
		JTextField pivatext= new JTextField(50);
		pivatext.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,1,0,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(pivatext, lim);
		pivatext.setInputVerifier(new InputVerifier(){
			
			public boolean verify(JComponent input) {
				
				
				String text = ((JTextField) input).getText();
				Pattern p = Pattern.compile("^[a-zA-Z0-9]{11}$");
				Matcher matcher= p.matcher(text);
				
				if(!matcher.matches()){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Campo Partita Iva non corretto! 11 caratteri!");
					return false;	
					
				}
				
				return true;
			}
			
			
		});
		
		JLabel lnome= new JLabel("Nome: ");
		lnome.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,1,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(lnome,lim);
		
		JTextField nometext= new JTextField();
		nometext.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,1,1,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(nometext, lim);
	
		nometext.setInputVerifier(new InputVerifier(){
			
			public boolean verify(JComponent input) {
				
				
				String text = ((JTextField) input).getText();
				Pattern p = Pattern.compile("^[a-zA-Z0-9\\s]{1,45}$");
				Matcher matcher= p.matcher(text);
				
				if(!matcher.matches()){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Campo Nome non corretto! Max 45 caratteri!");
					return false;	
					
				}
				
				return true;
			}
			
			
		});
		
		
		JLabel lindirizzo= new JLabel("Indirizzo: ");
		lindirizzo.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,2,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(lindirizzo,lim);
		
		JTextField indirizzotext= new JTextField();
		indirizzotext.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,1,2,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(indirizzotext, lim);
	
		indirizzotext.setInputVerifier(new InputVerifier(){
			
			public boolean verify(JComponent input) {
				
				
				String text = ((JTextField) input).getText();
				Pattern p = Pattern.compile("^[a-zA-Z0-9\\s]{1,45}$");
				Matcher matcher= p.matcher(text);
				
				if(!matcher.matches()){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Campo Indirizzo non corretto! Max 45 caratteri!");
					return false;	
					
				}
				
				return true;
			}
			
			
		});
		
		JLabel ltel=new JLabel("Telefono");
		ltel.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,3,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(ltel, lim);
		
		
		JTextField teltext= new JTextField();
		teltext.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,1,3,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(teltext, lim);
	
		teltext.setInputVerifier(new InputVerifier(){
			
			public boolean verify(JComponent input) {
				
				
				String text = ((JTextField) input).getText();
				Pattern p = Pattern.compile("^[a-zA-Z0-9\\s]{10}$");
				Matcher matcher= p.matcher(text);
				
				if(!matcher.matches()){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Campo Telefono non corretto! 10 caratteri!");
					return false;	
					
				}
				
				return true;
			}
			
			
		});
		
		
		JButton badd=new JButton("Aggiungi");
		badd.setFont(ParcoFrame.font);
		badd.setBackground(Color.WHITE);
		ParcoFrame.set(lim,3,4,1,1,GridBagConstraints.VERTICAL,1,1);
		panel.add(badd, lim);
		
		
		class ClickAddListener implements ActionListener{
		
			public void actionPerformed(ActionEvent e){
						
					
							try{
								controllaCampiVuoti(pivatext,nometext,indirizzotext,teltext);
							}
							
							catch(CampiVuotiException ex){
								
								JOptionPane mess= new JOptionPane();
								mess.showMessageDialog(null, ex.getMessage());
								return;
								
							}
							
							controllaAgenzia(pivatext,nometext,indirizzotext,teltext);
							
						}
						
				
		}
		
		
		badd.addActionListener(new ClickAddListener());
		return panel;
		

	}
	
	
	
	/**
	 * Controlla se i campi da compilare sono vuoti. Nel caso siano vuoti lancia un eccezione del tipo CampiVuotiException
	 * 
	 * @param pivatext componente dove viene immesso la partita iva dell'agenzia
	 * @param nometext componente dove viene immesso il nome dell'agenzia
	 * @param indirizzotext componente dove viene immesso l'indirizzo dell'agenzia
	 * @param teltext componente dove viene immesso il telefono dell'agenzia
	 */
	private void controllaCampiVuoti(JTextField pivatext,JTextField nometext, JTextField indirizzotext, JTextField teltext){
		
		
		if(pivatext.getText().length()==0 || nometext.getText().length()==0 || indirizzotext.getText().length()==0 || teltext.getText().length()==0  || nometext.getText().length()==0){

			throw new CampiVuotiException("Campi vuoti!");
			
		}
	}
	
	
	/**
	 * Questo metodo controlla prima di inserire un agenzia all'interno del parco se esista già tale agenzia che si vuole creare, altrimenti
	 * tramite un metodo della classe parco inserisce l'agenzia all'interno del parco.
	 * 
	 * @param pivatext componente dove viene immesso la partita iva dell'agenzia
	 * @param nometext componente dove viene immesso il nome dell'agenzia
	 * @param indirizzotext componente dove viene immesso l'indirizzo dell'agenzia
	 * @param teltext componente dove viene immesso il telefono dell'agenzia
	 */
	private void controllaAgenzia(JTextField pivatext, JTextField nometext, JTextField indirizzotext, JTextField teltext){
		
		
		JOptionPane m= new JOptionPane();
		
		String sql="SELECT piva FROM agenzia WHERE agenzia.piva='"+pivatext.getText()+"'";
		Vector v = db.eseguiQuery(sql);

		if(v.size()==0){
										
			Agenzia a= new Agenzia(pivatext.getText(),nometext.getText(),indirizzotext.getText(),teltext.getText(),0);
			
			sql="INSERT INTO agenzia(piva,nome,indirizzo,tel) VALUES('"+
					a.getPIva()+"','"+
					a.getNome()+"','"+
					a.getIndirizzo()+"','"+
					a.getTel()+"')";
			
					
					if(!db.eseguiAggiornamento(sql)){
						
						m.showMessageDialog(null, "Errore inserimento!");

					}
					else{
						
						sql="INSERT INTO convenzione(agenzia,parco) VALUES('"+a.getPIva()+"','"+parco.getCodice()+"')";
						if(!db.eseguiAggiornamento(sql)){
							
							m.showMessageDialog(null, "Errore inserimento!");

						}
						else{
							
							parco.addAgenzia(a);

							m.showMessageDialog(null, "Agenzia inserita con successo!");
							table.repaint();
						}


				}
		}
		
		else {
			
			m.showMessageDialog(null, "Agenzia già esistente!");
			
		}
	}
	
	public String toString() {
		return super.toString() +"[db=" + db + ", parco=" + parco + ", table=" + table + "]";
	}
	
	private Database db;
	private Parco parco;
	private JTable table;

}
