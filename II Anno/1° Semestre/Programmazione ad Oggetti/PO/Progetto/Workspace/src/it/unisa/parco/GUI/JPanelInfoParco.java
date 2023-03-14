package it.unisa.parco.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumn;
import com.mysql.jdbc.Connection;

import it.unisa.Connection.Database;
import it.unisa.Exception.CampiVuotiException;
import it.unisa.parco.Gestore.Attivita;
import it.unisa.parco.Gestore.Parco;
import it.unisa.parco.Gestore.ParcoAcquatico;
import it.unisa.parco.Gestore.ParcoAvventura;
import it.unisa.parco.Gestore.ParcoTematico;


/**
 * 
 * @author Paolo Vigorito
 * @author Loris Proto
 */
public class JPanelInfoParco  extends JPanel{
	
	/**
	 * Costruisce un nuovo pannello basandosi sul parco su cui si vogliono visualizzare le relative informazioni 
	 * e un database per prelevare le informazioni relative al parco. Esso è composto da un layout "BorderLayout" per predisporre i vari pannelli
	 * a nord, sud, est e ovest.
	 * 
	 * @param parco parco su e percui si vogliono visualizzare le relative informazioni
	 * @param db databas prelevare le informazioni relative al parco che si è selezionato
	 */
	public JPanelInfoParco(Parco parco, Database db){
		
		this.parco=parco;
		this.db=db;
		this.setLayout(new BorderLayout());
		
		add(creatPanelCenterNord(),BorderLayout.NORTH);
		add(creatPanelCenterC(), BorderLayout.CENTER);
		add(creatPanelCenterSud(),BorderLayout.SOUTH);
	}
	
	
	/**
	 * Questo metodo crea un pannello che contiene informazioni relative allo stato del parco. Viene suddiviso in "Griglia" per disporre
	 * i vari componenti, viene posizionato a nord del pannello principale.
	 * 
	 * @return JPanel pannello che viene posizionato a nord del pannello principale
	 */
	public JPanel creatPanelCenterNord(){
		
		String sql="SELECT DISTINCT telefono.numero FROM telefono , parco WHERE telefono.parco='"+parco.getCodice()+"'";
		
		Vector v= db.eseguiQuery(sql);
		for(int i=0;i<v.size();i++){
			
			String[] result = (String[]) v.get(i);
			
			parco.addTel(result[0]);
			
		}	
		
		
		
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		
		JPanel panel= new JPanel();
		panel.setLayout(layout);
		panel.setName("panelnord");
		
		
		JLabel lnome= new JLabel("Nome: ");
		lnome.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,0,1,1,GridBagConstraints.BOTH,1,1);
		
		panel.add(lnome,lim);
		
		JLabel lnomev= new JLabel(parco.getNome());
		lnomev.setFont(ParcoFrame.font);
		lnomev.setForeground(Color.WHITE);
		ParcoFrame.set(lim,1,0,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lnomev,lim);
		
		JLabel lsede= new JLabel("Sede: ");
		lsede.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,2,0,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lsede,lim);
		
		JLabel lsedev= new JLabel(parco.getSede());
		lsedev.setFont(ParcoFrame.font);
		lsedev.setForeground(Color.WHITE);
		ParcoFrame.set(lim,3,0,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lsedev,lim);
		
		JLabel lnumbigliettidisp= new JLabel("Biglietti Disponibili: ");
		lnumbigliettidisp.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,1,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lnumbigliettidisp,lim);
		
		JLabel lnumbigliettidispv= new JLabel(String.valueOf(parco.getNumBigliettiVendita()));
		lnumbigliettidispv.setName("lnumbigliettidispv");
		lnumbigliettidispv.setFont(ParcoFrame.font);
		lnumbigliettidispv.setForeground(Color.WHITE);
		ParcoFrame.set(lim,1,1,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(lnumbigliettidispv,lim);
		
		JLabel ltel= new JLabel("Recapiti: ");
		ltel.setFont(ParcoFrame.font);
		ParcoFrame.set(lim,0,2,1,1,GridBagConstraints.BOTH,1,1);
		panel.add(ltel,lim);
		
		JButton btel= new JButton("Visualizza");
		lim.ipady=20;
		btel.setFont(ParcoFrame.font);
		btel.setBackground(Color.WHITE);
		ParcoFrame.set(lim,1,2,1,1,GridBagConstraints.HORIZONTAL,1,1);
		panel.add(btel, lim);
		
		if(parco instanceof ParcoAcquatico){
			
			ParcoAcquatico p=(ParcoAcquatico) parco;
			
			JLabel lpiscine= new JLabel("Numero Piscine: ");
			lpiscine.setFont(ParcoFrame.font);
			ParcoFrame.set(lim,0,3,1,1,GridBagConstraints.BOTH,1,1);
			panel.add(lpiscine,lim);
			
			JLabel lpiscinev= new JLabel(String.valueOf(p.getNumPiscine()));
			lpiscinev.setFont(ParcoFrame.font);
			lpiscinev.setForeground(Color.WHITE);
			ParcoFrame.set(lim,1,3,1,1,GridBagConstraints.HORIZONTAL,1,1);
			panel.add(lpiscinev, lim);
			
		}
		
		else if(parco instanceof ParcoAvventura){
			
			ParcoAvventura p=(ParcoAvventura) parco;
			
			JLabel lpercorso= new JLabel("Percorso: ");
			lpercorso.setFont(ParcoFrame.font);
			ParcoFrame.set(lim,0,3,1,1,GridBagConstraints.BOTH,1,1);
			panel.add(lpercorso,lim);
			
			JTextArea percorsotext= new JTextArea((p.getPercorso()));
			percorsotext.setFont(ParcoFrame.font);
			ParcoFrame.set(lim,1,3,1,1,GridBagConstraints.HORIZONTAL,1,1);
			JScrollPane pane= new JScrollPane(percorsotext);
			pane.setPreferredSize(new Dimension(50,50));


			panel.add(pane, lim);
			
		}
		
		
		else if(parco instanceof ParcoTematico){
			
			ParcoTematico p=(ParcoTematico) parco;
			
			JLabel ltema= new JLabel("Tema: ");
			ltema.setFont(ParcoFrame.font);
			ParcoFrame.set(lim,0,3,1,1,GridBagConstraints.BOTH,1,1);
			panel.add(ltema,lim);
			
			JTextArea tematext= new JTextArea((p.getTema()));
			tematext.setFont(ParcoFrame.font);
			ParcoFrame.set(lim,1,3,1,1,GridBagConstraints.HORIZONTAL,1,1);
			JScrollPane pane= new JScrollPane(tematext);
			pane.setPreferredSize(new Dimension(50,50));
			panel.add(pane, lim);
			
		}
		
		else{}
		
	
			
			class ClickTelListener implements ActionListener{
				
					public void actionPerformed(ActionEvent e){
						
						
						JDialog dialog= new JDialog();	
						
					
					
						GridBagLayout layout= new GridBagLayout();
						GridBagConstraints lim= new GridBagConstraints();
						dialog.setLayout(layout);
						JLabel lnumero= new JLabel("Numeri: ");
						lnumero.setFont(ParcoFrame.font);
						ParcoFrame.set(lim, 0, 0, 1, 1, GridBagConstraints.BOTH, 1, 0);
						dialog.add(lnumero,lim);
						
						int i=0;
						for(String tel:parco.getTel()){
							
							JLabel ltev= new JLabel(tel);
							ltev.setFont(ParcoFrame.font);
							ParcoFrame.set(lim,1,i,1,1,GridBagConstraints.HORIZONTAL,1,0);
							dialog.add(ltev, lim);
							i++;
							
						}
						
						dialog.pack();
						dialog.setLocationRelativeTo(null);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					
					}
			}
			
			panel.setBorder(bordo);
			panel.setPreferredSize(new Dimension(1056,200));
			panel.setBackground(Color.LIGHT_GRAY);
			btel.addActionListener(new ClickTelListener());
			
			return panel;
		
	}
	
	
	/**
	 * Questo metodo crea un pannello che viene posizionato al centro del pannello principale. Contiene le informazioni
	 * relative alle attività offerte dal parco in forma tabellare
	 * 
	 * @return JPanel pannello che viene posizionato al centro pannello principale
	 */
	public JPanel creatPanelCenterC(){
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		String sql="SELECT attivita.nome, attivita.costo, attivita.orario_inizio, attivita.orario_fine FROM attivita JOIN parco ON attivita.parco=parco.codice WHERE parco.codice='"+parco.getCodice()+"'";
		Vector ve=db.eseguiQuery(sql);
		
		for(int i=0;i<ve.size();i++){
			
			String[] result = (String[]) ve.get(i);
			
			parco.addAttivita(new Attivita(result[0],Double.parseDouble(result[1]), Time.valueOf(result[2]),Time.valueOf(result[3])));
			
			
		}
		

		
		JLabel label=new JLabel("Attività Offerte");
		label.setFont(ParcoFrame.font);
		panel.add(label,BorderLayout.NORTH);
		
		
		TableAttivitaParcoModel attivitamodel= new TableAttivitaParcoModel(parco.getAttivita());		
		JTable table= new JTable(attivitamodel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		
		
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setMinWidth(0);
		col.setMaxWidth(0);
		col.setPreferredWidth(0);
		col.setResizable(false);
		

		
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(true);
		JScrollPane jps= new JScrollPane(table);
		panel.add(jps,BorderLayout.CENTER);
		
		
		JButton binserisci= new JButton("Inserisci Attivita");
		binserisci.setBackground(Color.WHITE);
		panel.add(binserisci,BorderLayout.EAST);
		
		
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setPreferredSize(new Dimension(1056,323));
		
		class ClickInserisciAttivita implements ActionListener{
			
			public void actionPerformed(ActionEvent e){// start JDIALOG
				
				JDialogInsertAttivita dialoginsertattivita= new JDialogInsertAttivita(parco,db,table);
				
			}// END JDIALOG
		}
		
		binserisci.addActionListener(new ClickInserisciAttivita());
		
		return panel;
		
	}
	
	/**
	 * Questo metodo crea un pannello che viene posizionato a sud del pannello principale. Contiene informazioni riguardanti i biglietti venduti dal parco in
	 * forma tabellare
	 * 
	 * @return JPanel pannello che viene posizionato a sud del pannello prinicipale
	 */
	public JPanel creatPanelCenterSud(){
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		JLabel label=new JLabel("Biglietti Venduti");
		label.setFont(ParcoFrame.font);
		panel.add(label,BorderLayout.NORTH);	
		
		
		TableBigliettiParcoModel bigliettimodel= new TableBigliettiParcoModel(parco.getBigliettiVenduti());
		JTable table= new JTable(bigliettimodel);
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setMinWidth(0);
		col.setMaxWidth(0);
		col.setPreferredWidth(0);
		col.setResizable(false);
		
		table.setPreferredScrollableViewportSize(new Dimension(980,100));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		JScrollPane jps= new JScrollPane(table);
		panel.add(jps,BorderLayout.CENTER);
		
		
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(bordo);
		panel.setPreferredSize(new Dimension(1056,323));
		
		return panel;
		
	}
	
	

	public String toString() {
		return super.toString() +"[parco=" + parco + ", db=" + db + "]";
	}



	private Parco parco=null;
	private Database db=null;
	private static final Font font= new Font("Verdana", Font.HANGING_BASELINE, 20);
	private static final Border bordo= BorderFactory.createLineBorder(Color.WHITE,3);
	
}
