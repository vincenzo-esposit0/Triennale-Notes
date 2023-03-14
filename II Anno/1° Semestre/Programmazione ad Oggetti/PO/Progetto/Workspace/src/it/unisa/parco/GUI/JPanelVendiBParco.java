package it.unisa.parco.GUI;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.Color;
import java.awt.Component;

import it.unisa.Agenzia.Cliente;
import it.unisa.Connection.Database;
import it.unisa.Exception.CampiVuotiException;
import it.unisa.Exception.NoAttivitaSelException;
import it.unisa.parco.Gestore.Attivita;
import it.unisa.parco.Gestore.Biglietto;
import it.unisa.parco.Gestore.BigliettoPromo;
import it.unisa.parco.Gestore.BigliettoRidotto;
import it.unisa.parco.Gestore.Parco;
import it.unisa.parco.Gestore.Promozione;
import javafx.scene.control.CheckBox;


/**
 * 
 * @author Paolo Vigorito 
 * @author Loris Proto
 */
public class JPanelVendiBParco  extends JPanel{
	
	/**
	 * Costruisce un nuovo pannello ,che viene posizionato al centro del Frame ParcoFrame, basandosi sul parco su cui si vuole compiere l'operazione di vendita di un biglietto 
	 * e un database per prelevare le informazioni relative al parco. Esso è composto da un layout "BorderLayout" per predisporre i vari pannelli
	 * a nord, sud, est e ovest.
	 * 
	 * @param parco parco su cui si vuole compiere l'operazione di vendita di un biglietto
	 * @param db  database per prelevare le informazioni relative al parco selezionato
	 */
	JPanelVendiBParco(Parco parco, Database db){
		
		this.parco=parco;
		this.db=db;
		
		this.setLayout(new BorderLayout());
		
		this.add(creatPanelCenter(),BorderLayout.CENTER);
		this.add(paneleast=creatPanelEast(),BorderLayout.EAST);
		
		
		
	}
	
	/**
	 * Questo metodo crea una interfaccia per vendere un biglietto che viene posizionato al centro del pannello principale e viene applicato un layoutManager a "Griglia" per 
	 * disporre i vari componenti all'interno di esso.
	 * 
	 * 
	 * 
	 * @return JPanel
	 */
	public JPanel creatPanelCenter(){
		
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();

		
		JPanel panel= new JPanel();
		panel.setLayout(layout);
		
		JLabel ltipo= new JLabel("Tipo: ");
		ParcoFrame.set(lim,0,0,1,1,GridBagConstraints.BOTH,1,1);
		ltipo.setFont(ParcoFrame.font);
		panel.add(ltipo,lim);
		
		JComboBox combotipo= new JComboBox();
		combotipo.setFont(ParcoFrame.font);
		combotipo.addItem(new String("Intero"));
		combotipo.addItem(new String("Promozionale"));
		combotipo.addItem(new String("Ridotto"));
		combotipo.setSelectedIndex(0);
		combotipo.setBackground(Color.WHITE);
		ParcoFrame.set(lim,1,0,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(combotipo, lim);
		
		JLabel lcodice= new JLabel("Codice: ");
		lcodice.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,1,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lcodice,lim);
		
		JTextField codicetext= new JTextField();		
		codicetext.setFont(ParcoFrame.font);
		codicetext.setBackground(Color.WHITE);
		ParcoFrame.set(lim,1,1,1,1,GridBagConstraints.HORIZONTAL,0,0);
		panel.add(codicetext,lim);
		codicetext.setInputVerifier(new InputVerifier(){
			
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
			
		});
		
		JLabel lnome= new JLabel("Nome: ");
		lnome.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,2,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lnome,lim);
		
		
		
		JTextField nometext= new JTextField();
		nometext.setFont(ParcoFrame.font);
		nometext.setBackground(Color.WHITE);
		ParcoFrame.set(lim,1,2,1,1,GridBagConstraints.HORIZONTAL,0,0);
		panel.add(nometext,lim);
		nometext.setInputVerifier(new InputVerifier(){
			
			public boolean verify(JComponent input) {
				
				String text = ((JTextField) input).getText();
				Pattern p = Pattern.compile("^[a-zA-Z0-9]{1,45}$");
				Matcher matcher= p.matcher(text);
				
				if(!matcher.matches()){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Campo Codice non corretto! Solo caratteri alfanumerici! MAX 45 caratteri!");
					return false;	
					
				}
				
				return true;
			}
			
		});
		
		
		JLabel lprezzo= new JLabel("Prezzo: ");
		lprezzo.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,3,1,1,GridBagConstraints.BOTH,0,0);
		panel.add(lprezzo,lim);
		
		
		DecimalFormatSymbols separatore = new DecimalFormatSymbols(Locale.ENGLISH);
		DecimalFormat df = new DecimalFormat("#.##");
		df.setDecimalFormatSymbols(separatore);
		JFormattedTextField prezzotext=new JFormattedTextField(df);
		prezzotext.setFont(ParcoFrame.font);
		prezzotext.setBackground(Color.WHITE);
		ParcoFrame.set(lim,1,3,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(prezzotext, lim);
		
		
		JLabel lsconto=new JLabel("Sconto: ");
		lim.insets.left=0;
		lsconto.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,4,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lsconto, lim);
		
		JComboBox combosconto= new JComboBox();
		for(int i=10;i<100;i=i+10){
			
			combosconto.addItem(String.valueOf(i));
		}
		combosconto.setEnabled(false);
		combosconto.setFont(ParcoFrame.font);
		combosconto.setBackground(Color.WHITE);
		ParcoFrame.set(lim,1,4,1,1,GridBagConstraints.HORIZONTAL,1,1);	
		panel.add(combosconto,lim);
		
		JLabel lpromo=new JLabel("Promozione: ");
		lpromo.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,5,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lpromo, lim);
		
		
		
		JComboBox combopromo= new JComboBox();
		lim.insets.left=0;
		combopromo.setEnabled(false);
		for(Promozione p:parco.getPromozioni()){
			combopromo.addItem(new String(p.getCodice()));
		}
		combopromo.setFont(ParcoFrame.font);
		combopromo.setBackground(Color.WHITE);
		ParcoFrame.set(lim,1,5,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(combopromo,lim);
		
		JLabel lscontopromo= new JLabel("Sconto:");
		lscontopromo.setVisible(false);
		lscontopromo.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,6,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lscontopromo,lim);
		
		
		JLabel lscontovalue= new JLabel("");
		lscontovalue.setVisible(false);
		lscontovalue.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,1,6,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lscontovalue,lim);
		
		
		JLabel lcf= new JLabel("Codice Fiscale");
		ParcoFrame.set(lim,0,7,1,1,GridBagConstraints.HORIZONTAL,1,1);	
		lcf.setBackground(Color.WHITE);
		lcf.setFont(ParcoFrame.font);
		panel.add(lcf,lim);
		
		
		JTextField cftext= new JTextField();
		ParcoFrame.set(lim,1,7,1,1,GridBagConstraints.HORIZONTAL,1,1);
		cftext.setBackground(Color.WHITE);
		cftext.setFont(ParcoFrame.font);
		panel.add(cftext,lim);
		
		cftext.setInputVerifier(new InputVerifier(){
			
			public boolean verify(JComponent input) {
				
				
				String text = ((JTextField) input).getText();
				Pattern p = Pattern.compile("^[a-zA-Z0-9]{16}$");
				Matcher matcher= p.matcher(text);
				
				if(!matcher.matches()){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Campo Codice non corretto! 16 caratteri!");
					return false;	
					
				}
				
				return true;
			}
		});
		
		
		JLabel lnomec= new JLabel("Nome");
		ParcoFrame.set(lim,0,8,1,1,GridBagConstraints.HORIZONTAL,1,1);	
		lnomec.setBackground(Color.WHITE);
		lnomec.setFont(ParcoFrame.font);
		panel.add(lnomec,lim);
		
		
		JTextField nomectext= new JTextField();
		ParcoFrame.set(lim,1,8,1,1,GridBagConstraints.HORIZONTAL,1,1);	
		nomectext.setBackground(Color.WHITE);
		nomectext.setFont(ParcoFrame.font);
		panel.add(nomectext,lim);
		nomectext.setInputVerifier(new InputVerifier(){
			
			public boolean verify(JComponent input) {
				
				String text = ((JTextField) input).getText();
				Pattern p = Pattern.compile("^[a-zA-Z0-9]{1,45}$");
				Matcher matcher= p.matcher(text);
				
				if(!matcher.matches()){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Campo Codice non corretto! Solo caratteri alfanumerici! MAX 45 caratteri!");
					return false;	
					
				}
				
				return true;
			}
			
		});
		
		JLabel lcognome= new JLabel("Cognome");
		ParcoFrame.set(lim,0,9,1,1,GridBagConstraints.HORIZONTAL,1,1);	
		lcognome.setBackground(Color.WHITE);
		lcognome.setFont(ParcoFrame.font);
		panel.add(lcognome,lim);
		
		
		JTextField cognometext= new JTextField();
		ParcoFrame.set(lim,1,9,1,1,GridBagConstraints.HORIZONTAL,1,1);	
		cognometext.setBackground(Color.WHITE);
		cognometext.setFont(ParcoFrame.font);
		panel.add(cognometext,lim);
		cognometext.setInputVerifier(new InputVerifier(){
			
			public boolean verify(JComponent input) {
				
				String text = ((JTextField) input).getText();
				Pattern p = Pattern.compile("^[a-zA-Z0-9]{1,45}$");
				Matcher matcher= p.matcher(text);
				
				if(!matcher.matches()){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Campo Codice non corretto! Solo caratteri alfanumerici! MAX 45 caratteri!");
					return false;	
					
				}
				
				return true;
			}
			
		});
		
		
		JLabel leta= new JLabel("Età");
		ParcoFrame.set(lim,0,10,1,1,GridBagConstraints.HORIZONTAL,1,1);	
		leta.setBackground(Color.WHITE);
		leta.setFont(ParcoFrame.font);
		panel.add(leta,lim);
		
		
		
		DecimalFormat dfeta = new DecimalFormat("#");
		JFormattedTextField etatext= new JFormattedTextField(dfeta);
		ParcoFrame.set(lim,1,10,1,1,GridBagConstraints.HORIZONTAL,1,1);	
		etatext.setBackground(Color.WHITE);
		etatext.setFont(ParcoFrame.font);
		panel.add(etatext,lim);
		
		
		
		
		JButton bvendi= new JButton("Vendi Biglietto");
		ParcoFrame.set(lim,0,11,3,1,GridBagConstraints.BOTH,1,1);
		bvendi.setBackground(Color.ORANGE);
		bvendi.setFont(ParcoFrame.font);
		panel.add(bvendi,lim);
		
		
		class ClickTipoBListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				
					JComboBox tipob= (JComboBox) e.getSource();
					
					if((tipob.getSelectedIndex()==0)){
					
						combosconto.setEnabled(false);
						combopromo.setEnabled(false);
						lscontopromo.setVisible(false);
						lscontovalue.setVisible(false);
						for(JCheckBox acheck:checksattivita){
							
							acheck.setSelected(false);
							acheck.setEnabled(true);
						}
						
					}
					
					else if(tipob.getSelectedIndex()==1){
						
						
						combosconto.setEnabled(false);
						combopromo.setEnabled(true);
						for(JCheckBox acheck:checksattivita){
							
							acheck.setSelected(false);
							acheck.setEnabled(false);
						}
					
					}
					
					
					else{
						
						combosconto.setEnabled(true);
						combopromo.setEnabled(false);
						lscontopromo.setVisible(false);
						lscontovalue.setVisible(false);
						for(JCheckBox acheck:checksattivita){
							
							acheck.setSelected(false);
							acheck.setEnabled(true);
						}
					}
					
				}
			}
		
		
		class ClickPromoListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
			
				
				for(JCheckBox acheck:checksattivita){
					
					acheck.setSelected(false);
					acheck.setEnabled(false);
				}
				
					lscontopromo.setVisible(true);
					lscontovalue.setVisible(true);
					
					controllaPromo(lscontopromo,lscontovalue,combopromo);
					
				}
		}
		
		
		class ClickVendiListener implements ActionListener{
			
			
			public void actionPerformed(ActionEvent e){
				
				ArrayList<Attivita> abiglietto=null;
				
				try{
					
					 controllaCampiVuoti(codicetext,prezzotext,cftext,etatext,nometext,nomectext,cognometext);
					 abiglietto = checkAttivitaSelezionate();
					 

						for(Biglietto b:parco.getBigliettiVenduti()){
							
							if(b.getCodice().equals(codicetext.getText())){
								
								JOptionPane mess= new JOptionPane();
								mess.showMessageDialog(null, "Biglietto già esistente con questo codice!");
								return;
							}
							
						}
						
					
						String sql="SELECT cf FROM cliente WHERE cliente.cf='"+cftext.getText()+"'";
						Vector v= db.eseguiQuery(sql);
				
						Cliente c= new Cliente(cftext.getText(),nomectext.getText(),cognometext.getText(),Integer.parseInt(etatext.getText()));
						
						if(v.size()==0){
							
							String insertcliente="INSERT INTO cliente VALUES('"+c.getCf()+"','"+c.getNome()+"','"+c.getCognome()+"','"+c.getEta()+"')";
							db.eseguiAggiornamento(insertcliente);
						}
						
						if(combotipo.getSelectedIndex()==0){
							operazioneBigliettoIntero(codicetext,nometext, prezzotext, abiglietto, c);

						}

						
						else if(combotipo.getSelectedIndex()==1){// inizio operazioni biglietto promozionale
							operazioneBigliettoPromo(codicetext,nometext, prezzotext, abiglietto, c);					
							
						}// fie operazioni biglietto promozionale
						
						else{// inizio operazioni biglietto ridotto
							
							operazioneBigliettoRidotto(combosconto,codicetext,nometext, prezzotext, abiglietto, c);
							
						}// fine operazioni biglietto ridotto
						
						
						String sqlupdate="UPDATE parco set biglietti_disp='"+parco.getNumBigliettiVendita()+"' WHERE parco.codice='"+parco.getCodice()+"'";
						db.eseguiAggiornamento(sqlupdate);
						
						sqlupdate="UPDATE parco set biglietti_venduti='"+parco.getBigliettiVenduti().size()+"' WHERE parco.codice='"+parco.getCodice()+"'";
						db.eseguiAggiornamento(sqlupdate);
				}
				
				catch(NoAttivitaSelException ex){
					
					JOptionPane mess= new JOptionPane();
					mess.showMessageDialog(null, ex.getMessage());
					
				}
				
				catch(CampiVuotiException ex){
					
					
					JOptionPane mess= new JOptionPane();
					mess.showMessageDialog(null, "Campi Obbligatori vuoti!");
				}

			
			}	
			
		}
		
		combopromo.addActionListener(new ClickPromoListener());
		combotipo.addActionListener(new ClickTipoBListener());
		bvendi.addActionListener(new ClickVendiListener());
		
		panel.setBorder(BorderFactory.createTitledBorder("Biglietto"));
		return panel;
	}
	
	
	
	
	/**
	 * Questo metodo crea un pannello che viene posizionato a destra del pannello principale e permette di selezionare le varie attività
	 * che devono essere incluse all'interno del biglietto.
	 * 
	 * 
	 * @return JScrollPane pannello scorrevole che viene posizionato a destra del pannello principale
	 */
	public JScrollPane creatPanelEast(){
		
		JPanel panel= new JPanel();
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		panel.setLayout(layout);
		
		checksattivita= new ArrayList<JCheckBox>();
		
		int i=0;
		for(Attivita a:parco.getAttivita()){
			
			JCheckBox cb;
			if(i==0){
				
				cb = new JCheckBox(a.getNome(),true);
				checksattivita.add(cb);
			}
			else{
				
				cb = new JCheckBox(a.getNome(),false);
				checksattivita.add(cb);
			}
		    ParcoFrame.set(lim,0,i,1,1,GridBagConstraints.NONE,0,0);
		    cb.setFont(ParcoFrame.font);
		    panel.add(cb,lim);
		    i++;
		}
		
	    
	    JScrollPane jsp= new JScrollPane(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Attività incluse"));
		panel.setPreferredSize(new Dimension(200,0));
		return jsp;
		
	}
	
	
	/**
	 * Questo metodo seleziona tutte le attività relative alla promozione scelta.
	 * 
	 * @param lscontopromo
	 * @param lscontovalue
	 * @param combopromo contiene il codice di tutte le promozioni
	 */
	private void controllaPromo(JLabel lscontopromo,JLabel lscontovalue, JComboBox combopromo){
		
		for(Promozione p:parco.getPromozioni()){
			
			if(p.getCodice().equals(combopromo.getSelectedItem())){
				
				lscontovalue.setText(String.valueOf(p.getSconto()));
				promoselect= p;
			}
		}
		
		for(JCheckBox acheck: checksattivita){
			
			for(Attivita apromo: promoselect.getAttivitaInPromo()){
				
				if(acheck.getText().equals(apromo.getNome())) { acheck.setSelected(true);}
			}
			
		}
		
	}
		
	
	
	/**
	 * Questo metodo controlla se ci sono dei campi non compilati
	 * 
	 * @param codicetext componente che contiene il codice digitato
	 * @param prezzotext componente che contiene il prezzo digitato
	 * @param cftext componente che contiene il codice fiscale digitato
	 * @param etatext componente che contiene l'età del cliente digitata
	 * @param nometext componente che contiene il nome del cliente digitato
	 * @param nomectext  componente che contiene il nome del cliente digitato
	 * @param cognometext componente che contiene il cognomme del cliente digitato
	 */
	private void controllaCampiVuoti(JTextField codicetext,JTextField prezzotext, JTextField cftext, JTextField etatext,JTextField nometext, JTextField nomectext,JTextField cognometext){
		
		
		if(codicetext.getText().length()==0 || prezzotext.getText().length()==0 || cftext.getText().length()==0 || etatext.getText().length()==0  || nometext.getText().length()==0 || 
		nomectext.getText().length()==0 || cognometext.getText().length()==0){

			throw new CampiVuotiException("Campi vuoti!");
			
		}
	}
	
	
	/**
	 * Questo metodo controlla le attività che sono state selezionate. Se non è stata selezionata nessuna attvità da quelle disponibili
	 * lancia un eccezione del tipo NoAttivitaSelException.
	 *  
	 * @exception NoAttivitaSelException viene lanciata nel momento in cui non è stata selezionata alcuna attività
	 * @return ArrayList<Attivita> ritorna in un arraylist tutte le attività che sono state selezionate
	 */
	private ArrayList<Attivita> checkAttivitaSelezionate(){
		
		ArrayList<Attivita> abiglietto= new ArrayList<Attivita>();
		
		for(JCheckBox acheckbox:checksattivita){
		
			if(acheckbox.isSelected()){
				
				for(Attivita attivita:parco.getAttivita()){
				
					if(attivita.getNome().equals(acheckbox.getText())){
					
						abiglietto.add(attivita);
					}
										
				}
		
			}					
		}
		
		
		if(abiglietto.size()==0){
			throw new NoAttivitaSelException("Nessuna attività selezionata!");
			
		}
		
		return abiglietto;
	}
	
	/**
	 * Questo metodo richiama tramite la classe parco un operazione di vendita su un biglietto intero
	 * 
	 * @param codicetext
	 * @param nometext
	 * @param prezzotext
	 * @param abiglietto
	 * @param c
	 */
	private void operazioneBigliettoIntero(JTextField codicetext,JTextField nometext, JTextField prezzotext, ArrayList<Attivita> abiglietto, Cliente c){
				
			
			LocalDateTime now = LocalDateTime.now();
			Biglietto b= new Biglietto(codicetext.getText(),nometext.getText(),Double.parseDouble(prezzotext.getText()),new GregorianCalendar(now.getYear(), now.getMonthValue()-1, now.getDayOfMonth()),abiglietto,c);	
			parco.vendiBiglietto(b);
			String datacquisto= (String.valueOf(b.getDatAcquisto().get(Calendar.YEAR)+"-"+b.getDatAcquisto().get(Calendar.MONTH)+"-"+b.getDatAcquisto().get(Calendar.DAY_OF_MONTH)));
			
			String sqlinsertbiglietto="INSERT INTO biglietto(codice,nome,prezzo,parco,datacquisto,cliente)"
							+ "VALUES('"+b.getCodice()+"','"+b.getNome()+"','"+b.getPrezzo()+"','"+parco.getCodice()+"','"+datacquisto+"','"+b.getCliente().getCf()+"')";
				
			db.eseguiAggiornamento(sqlinsertbiglietto);
			
			JOptionPane mess= new JOptionPane();
			mess.showMessageDialog(null, "Biglietto venduto con successo!");
			
		
	}
	
	/**
	 * Questo metodo richiama tramite la classe parco un operazione di vendita su un biglietto promo
	 * 
	 * @param codicetext
	 * @param nometext
	 * @param prezzotext
	 * @param abiglietto
	 * @param c
	 */
	private void operazioneBigliettoPromo(JTextField codicetext,JTextField nometext, JTextField prezzotext, ArrayList<Attivita> abiglietto, Cliente c){
		
		double sconto= ((double) promoselect.getSconto()/100) * Double.parseDouble(prezzotext.getText());
		double prezzoscontato=(Double.parseDouble(prezzotext.getText())) - sconto;
		
		LocalDateTime now = LocalDateTime.now();
		BigliettoPromo b= new BigliettoPromo(codicetext.getText(),nometext.getText(),prezzoscontato,new GregorianCalendar(now.getYear(),now.getMonthValue()-1,now.getDayOfMonth()),abiglietto,c,promoselect);	
		parco.vendiBiglietto(b);
		String datacquisto= (String.valueOf(b.getDatAcquisto().get(Calendar.YEAR)+"-"+b.getDatAcquisto().get(Calendar.MONTH)+"-"+b.getDatAcquisto().get(Calendar.DAY_OF_MONTH)));


		String sqlinsertbiglietto="INSERT INTO biglietto(codice,nome,prezzo,parco,datacquisto,cliente)"
						+ "VALUES('"+b.getCodice()+"','"+b.getNome()+"','"+Double.parseDouble(prezzotext.getText())+"','"+parco.getCodice()+"','"+datacquisto+"','"+b.getCliente().getCf()+"')";
		
		db.eseguiAggiornamento(sqlinsertbiglietto);
		
		String sqlinsertbigliettopromo="INSERT INTO bpromozionale VALUES('"+b.getCodice()+"','"+parco.getCodice()+"','"+prezzoscontato+"','"+parco.getCodice()+"','"+promoselect.getCodice()+"')";
		db.eseguiAggiornamento(sqlinsertbigliettopromo);
		
		JOptionPane mess= new JOptionPane();
		mess.showMessageDialog(null, "Biglietto Promozionale venduto con successo!");
		
		
	
}
	/**
	 * Questo metodo richiama tramite la classe parco un operazione di vendita su un biglietto ridotto
	 * 
	 * @param combosconto
	 * @param codicetext
	 * @param nometext
	 * @param prezzotext
	 * @param abiglietto
	 * @param c
	 */
	private void operazioneBigliettoRidotto(JComboBox combosconto,JTextField codicetext,JTextField nometext, JTextField prezzotext, ArrayList<Attivita> abiglietto, Cliente c){
		
		double sconto=((Double.parseDouble(String.valueOf(combosconto.getSelectedItem()))));
		double scontovalue= (sconto /100) * Double.parseDouble(prezzotext.getText());
		double prezzoscontato= Double.parseDouble(prezzotext.getText()) - scontovalue;
		
		LocalDateTime now = LocalDateTime.now();
		BigliettoRidotto b= new BigliettoRidotto(codicetext.getText(),nometext.getText(),prezzoscontato,new GregorianCalendar(now.getYear(),now.getMonthValue()-1,now.getDayOfMonth()),abiglietto,c, sconto);	
		parco.vendiBiglietto(b);
		String datacquisto= (String.valueOf(b.getDatAcquisto().get(Calendar.YEAR)+"-"+b.getDatAcquisto().get(Calendar.MONTH)+"-"+b.getDatAcquisto().get(Calendar.DAY_OF_MONTH)));
		String sqlinsertbiglietto="INSERT INTO biglietto(codice,nome,prezzo,parco,datacquisto,cliente)"
						+ "VALUES('"+b.getCodice()+"','"+b.getNome()+"','"+prezzoscontato+"','"+parco.getCodice()+"','"+datacquisto+"','"+b.getCliente().getCf()+"')";
		
		db.eseguiAggiornamento(sqlinsertbiglietto);
		
		String sqlinsertbigliettopromo="INSERT INTO bridotto VALUES('"+b.getCodice()+"','"+parco.getCodice()+"','"+Integer.parseInt(String.valueOf(combosconto.getSelectedItem()))+"')";
		db.eseguiAggiornamento(sqlinsertbigliettopromo);
		
		JOptionPane mess= new JOptionPane();
		mess.showMessageDialog(null, "Biglietto Ridotto venduto con successo!");
			
		
	}
	
	
	
	
	public String toString() {
		return super.toString() +"[db=" + db + ", parco=" + parco + ", checksattivita=" + checksattivita
				+ ", paneleast=" + paneleast + ", promoselect=" + promoselect + "]";
	}



	private Database db;
	private Parco parco;
	private ArrayList<JCheckBox> checksattivita; 
	private JScrollPane paneleast;
	private Promozione promoselect=null;
}
