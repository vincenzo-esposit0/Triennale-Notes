package it.unisa.parco.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.IllegalFormatException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableColumn;
import javax.swing.text.DateFormatter;

import com.sun.glass.ui.Pixels.Format;

import it.unisa.Agenzia.Cliente;
import it.unisa.Connection.Database;
import it.unisa.parco.Gestore.Biglietto;
import it.unisa.parco.Gestore.Parco;

import java.util.regex.Matcher;

import javax.swing.event.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * 
 * @author Paolo
 * @author Loris Proto
 */
public class ParcoFrame extends JFrame{
	
	
	/**
	 * Costruisce un nuovo frame relativo al parco che è stato selezionato.
	 * 
	 * @param parco parco che si vuole gestire
	 * @param db  database per prelevare le informazioni relative al parco che si è selezionato
	 */
	public ParcoFrame(Parco parco, Database db){
		
		super("Parco "+ parco.getNome());
		this.parco=parco;
		this.db=db;
		
		this.setLayout(new BorderLayout());
		
		
		add(panelsud=creatPanelSud(),BorderLayout.SOUTH);
		add(creatPanelMenuWest(), BorderLayout.WEST);
		creatPanelCenter();
		/**
		 * Classe interna a Parco Frame.
		 *
		 */
		class ClickSectionListener implements ActionListener{

			public void actionPerformed(ActionEvent e){

				upIncassi();
				upNumBiglietti();
				
				if(e.getSource()==binfo){
				
					settaVisibilita(panelinfo,panelvendib,panelpromo,panelpacchetti,panelagenziaparco);

				}
				
				else if(e.getSource()==bpromo){
					
					settaVisibilita(panelpromo,panelvendib,panelinfo,panelpacchetti,panelagenziaparco);


					
				}
				
				else if(e.getSource()==biglietto){
			
					
					settaVisibilita(panelvendib,panelpromo,panelinfo,panelpacchetti,panelagenziaparco);;				
					
				}
				
				else if(e.getSource()==bpacchetti){
										settaVisibilita(panelpacchetti,panelpromo,panelinfo,panelvendib,panelagenziaparco);	

				}
				
				else if(e.getSource()==bagenzie){
										settaVisibilita(panelagenziaparco,panelpromo,panelinfo,panelvendib,panelpacchetti);												
				}
				
			}
			
		}
		
		binfo.addActionListener(new ClickSectionListener());
		bpromo.addActionListener(new ClickSectionListener());
		biglietto.addActionListener(new ClickSectionListener());
		bpacchetti.addActionListener(new ClickSectionListener());
		bagenzie.addActionListener(new ClickSectionListener());
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1400,900);
		this.setResizable(false);
		
	}
	
	
	/**
	 * Questo metodo crea vari pannelli riferiti ai vari pulsanti che permettono di eseguire alcune operazioni.
	 */
	public void creatPanelCenter(){	
		
		panelinfo= new JPanelInfoParco(parco,db);
		panelpromo= new JPanelPromoParco(parco,db);
		panelvendib= new JPanelVendiBParco(parco,db);
		panelpacchetti= new JPanelPacchettiParco(parco,db);
		panelagenziaparco= new JPanelAgenziaParco(parco,db);
		
		
	}
	
	
	
	
	/**
	 * Questo metodo crea un pannello dove vengono inclusi i pulsanti per le operazioni del parco. Questo pannello viene posizionato a sinistra del frame.
	 * Inoltre esso viene suddiviso in "Griglia" per disporre i vari pulsanti
	 * 
	 * @return JPanel pannello che viene posizionato a sinsitra del frame
	 */
	public JPanel creatPanelMenuWest(){
		
		
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		JPanel panel= new JPanel();
		panel.setLayout(layout);

	
		
		lim.insets.bottom=30;
		lim.ipady=30;
		
		bpromo= new JButton("Promozioni");
		set(lim,0,1,1,1,GridBagConstraints.BOTH,0,0);
		lim.insets.top=30;
		bpromo.setFont(ParcoFrame.font);
		bpromo.setBackground(Color.WHITE);
		panel.add(bpromo,lim);
		
		
		bpacchetti = new JButton("Pacchetti");
		set(lim,0,2,1,1,GridBagConstraints.BOTH,0,0);
		bpacchetti.setFont(ParcoFrame.font);
		bpacchetti.setBackground(Color.WHITE);
		panel.add(bpacchetti,lim);
		
		
		bagenzie= new JButton("Agenzie");
		set(lim,0,3,1,1,GridBagConstraints.BOTH,0,0);
		bagenzie.setBackground(Color.WHITE);
		bagenzie.setFont(ParcoFrame.font);
		panel.add(bagenzie,lim);
		
		biglietto= new JButton("Vendi Biglietto");
		set(lim,0,4,1,1,GridBagConstraints.BOTH,0,0);
		biglietto.setFont(ParcoFrame.font);
		biglietto.setBackground(Color.WHITE);
		panel.add(biglietto,lim);
		
		binfo= new JButton("Info");
		set(lim,0,5,1,1,GridBagConstraints.BOTH,0,0);
		binfo.setFont(ParcoFrame.font);
		binfo.setBackground(Color.WHITE);
		panel.add(binfo,lim);
	
		
		panel.setBackground(Color.ORANGE);
		panel.setBorder(bordo);
		panel.setFont(ParcoFrame.font);
		
		return panel;
		
		
	}

	/**
	 * Questo metodo crea un pannello che viene posizionato a sud del frame. Popola l'arraylist dei biglietti venduti dal parco. Inoltre il
	 * pannello viene diviso in "Griglia" per disporre i tre componenti che permettono di sapere l'incasso:
	 * Giornaliero, Settimanale , Mensile del parco. Il Layout Manager GridBagLayout definisce esattamente una griglia costituita da un certo
	 * numero di colonnne e di righe
	 * 
	 * @return JPanel pannello che viene posizionato a sud del frame
	 */
	public JPanel creatPanelSud(){
		
		String sql= "SELECT b.codice, b.nome, b.prezzo,b.datacquisto, c.cf, c.nome, c.cognome, c.eta FROM biglietto b join cliente  c on b.cliente=c.cf WHERE b.parco='"+parco.getCodice()+"'";
		Vector v = db.eseguiQuery(sql);
			
		for(int i=0;i<v.size();i++){
			
			
				
				String[] result = (String[]) v.get(i);
				
				Cliente c= new Cliente(result[4],result[5],result[6],Integer.parseInt(result[7]));
				
				String[] data=result[3].split("-");
				GregorianCalendar datacquisto=new GregorianCalendar(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
				parco.addBigliettoVenduto(new Biglietto(result[0],result[1],Double.parseDouble(result[2]),datacquisto,c));
				
		}
		
		
		JPanel panel = new JPanel();
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		panel.setLayout(layout);
		
		JLabel lincassogiornaliero= new JLabel("Incasso Giornaliero: ");
		set(lim,1,0,1,1,GridBagConstraints.BOTH, 0,0);
		lincassogiornaliero.setFont(ParcoFrame.font);
		lincassogiornaliero.setForeground(Color.BLACK);
		panel.add(lincassogiornaliero, lim);
		
		
		

		DecimalFormat df= new DecimalFormat("#.##");
		JLabel lincassog= new JLabel(df.format(parco.getIncassoGiornaliero()));
		lincassog.setName("lincassog");
		set(lim,2,0,1,1,GridBagConstraints.BOTH, 0,0);
		lincassog.setFont(ParcoFrame.font);
		lincassog.setForeground(Color.WHITE);
		panel.add(lincassog, lim);
		
		
		JLabel lincassosettimanale= new JLabel("Incasso Settimanale: ");
		set(lim,0,1,1,1,GridBagConstraints.BOTH, 0,0);
		lincassosettimanale.setFont(ParcoFrame.font);
		lincassosettimanale.setForeground(Color.BLACK);
		panel.add(lincassosettimanale, lim);
		
		
		JLabel lincassos= new JLabel(df.format(parco.getIncassoSettimanale()));
		lincassos.setName("lincassos");
		set(lim,1,1,1,1,GridBagConstraints.BOTH, 0,0);
		lincassos.setFont(ParcoFrame.font);
		lincassos.setForeground(Color.WHITE);
		panel.add(lincassos, lim);
		
		
		JLabel lincassomensile= new JLabel("Incasso Mensile: ");
		set(lim,2,1,1,1,GridBagConstraints.BOTH, 0,0);
		lincassomensile.setFont(ParcoFrame.font);
		lincassomensile.setForeground(Color.BLACK);
		panel.add(lincassomensile, lim);
		
		JLabel lincassom= new JLabel(df.format(parco.getIncassoMensile()));
		lincassom.setName("lincassom");
		set(lim,3,1,1,1,GridBagConstraints.BOTH, 0,0);
		lincassom.setFont(ParcoFrame.font);
		lincassom.setForeground(Color.WHITE);
		panel.add(lincassom, lim);
		
		
		panel.setBorder(bordo);
		panel.setBackground(Color.LIGHT_GRAY);
		
		return panel;
		
	}
	
	/**
	 * Questo metodo setta la visibilità del pannello centrale relativo al pulsante che si è scelto di effettuare un operazione.
	 * Un solo pannello sarà visibile mentre gli altri verranno nascosti.
	 * 
	 * @param panel1 pannello che si desidera settare la visibilità
	 * @param panel2 pannello che viene nascosto
	 * @param panel3 pannello che viene nascosto
	 * @param panel4 pannello che viene nascosto
	 * @param panel5 pannello che viene nascosto
	 */
	private void settaVisibilita(JPanel panel1,JPanel panel2,JPanel panel3,JPanel panel4,JPanel panel5){
		
		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		panel5.setVisible(false);
		add(panel1,BorderLayout.CENTER);	
		this.getContentPane().revalidate();
		
	}
	
	
	
	
	/**
	 * Questo metodo permette di impostare i campi del GridBagConstraints necessari alla distribuzione dello spazio disponibile ad un component. 
	 * 
	 * @param lim variabile di tipo GridBagConstraints che permette di impostare i campi necessari alla distribuzione dello spazio disponibile ad un component
	 * @param gridx colonna dove viene posizionato il componente
	 * @param gridy riga dove viene posizionato il componente
	 * @param gridwidth numero di colonne che occupa il componente
	 * @param gridheight numero di righe che occupa il componente
	 * @param fill permette di sapere se il componente deve occupare tutta la colonna messa a disposizione, o tutta la riga, o entrambi
	 * @param weightx sfrutta spazio in eccesso verticalmente del pannello in cui sono posizionati
	 * @param weighty sfrutta spazio in eccesso orizzontalmente del pannelo in cui sono posizionati
	 */
	public static void set(GridBagConstraints lim, int gridx, int gridy, int gridwidth, int gridheight, int fill, int weightx, int weighty){
			lim.gridx = gridx;
			lim.gridy = gridy;
			lim.gridwidth = gridwidth;
			lim.gridheight = gridheight;
			lim.fill=fill;
			lim.weightx=weightx;
			lim.weighty=weighty;
	}
	
	/**
	 * Questo metodo aggiorna gli incassi relativi: Settimanali, Giornalieri, Mensili
	 */
	
	private void upIncassi(){
		
		for(Component c:panelsud.getComponents()){
			
			if(c instanceof JLabel && c.getName()!=null && c.getName().equals("lincassog")){
				
				JLabel lincassog= (JLabel) c;
				lincassog.setText(String.valueOf(parco.getIncassoGiornaliero()));
			}
			
			else if(c instanceof JLabel && c.getName()!=null && c.getName().equals("lincassom")){
				
				
				JLabel lincassom= (JLabel) c;
				lincassom.setText(String.valueOf(parco.getIncassoMensile()));
			}
			
			else if(c instanceof JLabel && c.getName()!=null && c.getName().equals("lincassos")){
				
				
				JLabel lincassos= (JLabel) c;
				lincassos.setText(String.valueOf(parco.getIncassoSettimanale()));
			}
			else{}
			
		}
	}
	
	private void upNumBiglietti(){
		
		
		for(Component c: panelinfo.getComponents()){
			
			if(c instanceof JPanel && c.getName()!=null && c.getName().equals("panelnord")){
				
				if(c instanceof JLabel && c.getName()!=null && c.getName().equals("lnumbigliettidispv")){
					
					
					JLabel lnumbigliettidispv = (JLabel) c;
					lnumbigliettidispv.setText(String.valueOf(parco.getNumBigliettiVendita()));							}
			
			}
		}
	}

	
	
	

	public String toString() {
		return super.toString() +"[parco=" + parco + ", db=" + db + ", binfo=" + binfo + ", biglietto=" + biglietto
				+ ", bpacchetti=" + bpacchetti + ", bagenzie=" + bagenzie + ", bpromo=" + bpromo + ", panelinfo="
				+ panelinfo + ", panelpromo=" + panelpromo + ", panelvendib=" + panelvendib + ", panelpacchetti="
				+ panelpacchetti + ", panelagenziaparco=" + panelagenziaparco + ", panelsud=" + panelsud + "]";
	}




	private Parco parco=null;
	public static final Border bordo= BorderFactory.createLineBorder(Color.WHITE,3);
	private Database db=null;
	public static final Font font= new Font("Verdana", Font.HANGING_BASELINE, 20);
	private JButton binfo;
	private JButton biglietto;
	private JButton bpacchetti;
	private JButton bagenzie;
	private JButton bpromo;
	private JPanelInfoParco panelinfo;
	private JPanelPromoParco panelpromo;
	private JPanelVendiBParco panelvendib;
	private JPanelPacchettiParco panelpacchetti;
	private JPanelAgenziaParco panelagenziaparco;
	private JPanel panelsud;

	

}
