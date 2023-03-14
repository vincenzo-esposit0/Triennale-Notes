package it.unisa.Agenzia.GUI;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
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
import javax.swing.JComboBox;
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

import it.unisa.Agenzia.Agenzia;
import it.unisa.Agenzia.Cliente;
import it.unisa.Agenzia.Pacchetto;
import it.unisa.Connection.Database;
import it.unisa.parco.Gestore.Parco;

import java.util.regex.Matcher;

import javax.swing.event.ChangeListener;
import javafx.beans.value.ObservableValue;
/**
 	Questo frame mostra le azioni possibili in modalità "agenzia"
 */
public class AgenziaFrame extends JFrame{
	
	private JPanel panelsud;
	public AgenziaFrame(Database db, Agenzia agenzia){
		
		super("Agenzia "+ agenzia.getNome());
		this.agenzia=agenzia;
		this.db=db;
		this.setLayout(new BorderLayout());
		
		
		String sql="SELECT pacchetto.* from pacchetto join agenzia ON pacchetto.agenzia=agenzia.piva WHERE pacchetto.agenzia='"+agenzia.getPIva()+"' and pacchetto.data_acquisto IS NULL and pacchetto.data_prenotazione IS NULL";
		Vector v=db.eseguiQuery(sql);
		for(int i=0;i<v.size();i++){
			
			String[] resultpacchettidisp= (String[]) v.get(i);
			agenzia.addPacchetto(new Pacchetto(resultpacchettidisp[0],resultpacchettidisp[1],resultpacchettidisp[2],Double.parseDouble(resultpacchettidisp[3]),Integer.parseInt(resultpacchettidisp[4]),new Parco(resultpacchettidisp[5])));
			
		}
		
		
		add(panelsud=creatPanelSud(),BorderLayout.SOUTH);
		add(creatPanelMenuWest(), BorderLayout.WEST);
		creatPanelCenter();
		
		/**
		 	ClickSectionListener consente la scelta dell'azione da compiere 
		 */
		class ClickSectionListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				upIncassi();
				if(e.getSource()==bcrea){
					
					settaVisibilita(panelcrea,panelvendi,panelvisualizza,panelprenota);
				}
				
				else if(e.getSource()==bvisualizza){
					
					
					settaVisibilita(panelvisualizza,panelcrea,panelvendi,panelprenota);

					
				}
				
				else if(e.getSource()==bvendi){
					
					
					settaVisibilita(panelvendi,panelcrea,panelvisualizza,panelprenota);
					panelvendi.upCombo();
					
				}
				
				else{
					
					settaVisibilita(panelprenota,panelvisualizza,panelcrea,panelvendi);
					panelprenota.upCombo();
				}
				
			}
			
		}
		
		bcrea.addActionListener(new ClickSectionListener());
		bvendi.addActionListener(new ClickSectionListener());
		bvisualizza.addActionListener(new ClickSectionListener());
		bprenota.addActionListener(new ClickSectionListener());
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1400,900);
		this.setResizable(false);
		
	}
	
	/**
	 * Il pannello centrale contiene i pannelli relativi alle azioni da compiere 
	 */
	
	public void creatPanelCenter(){	
		
		
		panelcrea= new JPanelCrea(db, agenzia);
		panelvisualizza= new JPanelVisualizza(db, agenzia);
		panelvendi= new JPanelVendi(db,agenzia);
		panelprenota= new JPanelPrenota(db,agenzia);		
		
	}
	
	/**
	 * Il pannello a ovest contiene i quattro pulsanti relativi ai quattro pannelli. 
	 * Un solo pulsante può essere selezionato
	 * 
	 * @return JPanel pannello che viene posizionato a sinistra del frame AgenziaFrame
	 */
	public JPanel creatPanelMenuWest(){
		
		
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		JPanel panel= new JPanel();
		panel.setLayout(layout);

	
		
		lim.insets.bottom=30;
		lim.ipady=30;
		
		
		bvisualizza= new JButton("Pacchetti Venduti/Prenotati");
		set(lim,0,3,1,1,GridBagConstraints.BOTH,0,0);
		bvisualizza.setBackground(Color.WHITE);
		bvisualizza.setFont(AgenziaFrame.font);
		panel.add(bvisualizza,lim);
		
		bvendi= new JButton("Vendi pacchetto");
		set(lim,0,4,1,1,GridBagConstraints.BOTH,0,0);
		bvendi.setFont(AgenziaFrame.font);
		bvendi.setBackground(Color.WHITE);
		panel.add(bvendi,lim);
		
		bprenota= new JButton("Prenota pacchetto");
		set(lim,0,5,1,1,GridBagConstraints.BOTH,0,0);
		bprenota.setFont(AgenziaFrame.font);
		bprenota.setBackground(Color.WHITE);
		panel.add(bprenota,lim);
		
		bcrea= new JButton("Crea pacchetti");
		set(lim,0,6,1,1,GridBagConstraints.BOTH,0,0);
		bcrea.setFont(AgenziaFrame.font);
		bcrea.setBackground(Color.WHITE);
		panel.add(bcrea,lim);
	
		
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(bordo);
		panel.setFont(AgenziaFrame.font);
		
		return panel;
		
		
	}

	/**
	 * Il pannello a sud mostra l'incasso
	 * 
	 * @return JPanel pannello che viene posizionato a sude del frame AgenziaFrame
	 */
	public JPanel creatPanelSud(){

		
		
		JPanel panel = new JPanel();
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		panel.setLayout(layout);
		
		JLabel lincasso= new JLabel("Incasso Totale: ");
		lincasso.setName("lincasso");
		set(lim,0,1,1,1,GridBagConstraints.BOTH, 0,0);
		lincasso.setFont(font);
		panel.add(lincasso,lim);
		

		DecimalFormat df= new DecimalFormat("#.##");		
		JLabel lincassom= new JLabel(df.format(agenzia.getIncasso()));
		lincassom.setName("lincassom");
		set(lim,1,1,1,1,GridBagConstraints.BOTH, 0,0);
		lincassom.setFont(AgenziaFrame.font);
		lincassom.setForeground(Color.WHITE);
		panel.add(lincassom, lim);
		
		
		panel.setBorder(bordo);
		panel.setBackground(Color.LIGHT_GRAY);
		
		return panel;
		
	}
	
	/**
	 * Questo metodo setta la visibilità dei pannelli
	 */
	private void settaVisibilita(JPanel panel1,JPanel panel2,JPanel panel3,JPanel panel4){
		
		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		
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
	 * Questo metodo aggiorna i valori dei componenti relativamente all'incasso dell'agenzia
	 */
	private void upIncassi(){
		
		for(Component c:panelsud.getComponents()){
			
			if(c instanceof JLabel && c.getName()!=null && c.getName().equals("lincassom")){
				
				JLabel lincassom= (JLabel) c;
				lincassom.setText(String.valueOf(agenzia.getIncasso()));
			}
			
		}
		
	}
	
	

	
	
	
	public String toString() {
		return super.toString() + "[panelsud=" + panelsud + ", agenzia=" + agenzia + ", db=" + db + ", bcrea=" + bcrea
				+ ", bvendi=" + bvendi + ", bvisualizza=" + bvisualizza + ", bprenota=" + bprenota + ", panelvendi="
				+ panelvendi + ", panelcrea=" + panelcrea + ", panelvisualizza=" + panelvisualizza + ", panelprenota="
				+ panelprenota + "]";
	}



	private Agenzia agenzia=null;
	public static final Border bordo= BorderFactory.createLineBorder(Color.ORANGE,3);
	private Database db=null;
	public static final Font font= new Font("Verdana", Font.HANGING_BASELINE, 20);
	private JButton bcrea;
	private JButton bvendi;
	private JButton bvisualizza;
	private JButton bprenota;
	private JPanelVendi panelvendi;
	private JPanelCrea panelcrea;
	private JPanelVisualizza panelvisualizza;
	private JPanelPrenota panelprenota;
	

}
