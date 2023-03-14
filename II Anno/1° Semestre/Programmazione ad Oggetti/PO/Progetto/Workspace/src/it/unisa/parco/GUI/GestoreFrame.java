package it.unisa.parco.GUI;


import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javafx.geometry.Insets;
import javax.swing.table.TableColumn;

import it.unisa.Connection.Database;
import it.unisa.parco.Gestore.Gestore;
import it.unisa.parco.Gestore.Parco;
import it.unisa.parco.Gestore.ParcoAcquatico;
import it.unisa.parco.Gestore.ParcoAvventura;
import it.unisa.parco.Gestore.ParcoTematico;

/**
 * 
 * @author Paolo
 * @author Loris Proto
 */
public class GestoreFrame extends JFrame{
	
	
	/**
	 * Costruisce un nuovo frame relativo ai parchi gestisti dal gestore.
	 * @param g Gestore relativo al login
	 * @param db database per prelevare le informazioni relativi al gestore che ha effettuato il login
	 */
	public GestoreFrame(Gestore g, Database db){
		
		this.gestore=g;
		this.db=db;
		
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
	
		add(creatPanelNord(), BorderLayout.NORTH);
		add(creatPanelSud(), BorderLayout.SOUTH);
		add(creatPanelCenter(),BorderLayout.CENTER);
		this.controllaTipoParchi();		

		
		class ClickVaiListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e){				
				
				controllaRigaSelezionata(table);
			}
			
			
		}

		bvai.addActionListener(new ClickVaiListener());

		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,500);
		this.setTitle("Area Gestore");
		this.setResizable(false);

	}

	
	/**
	 * Questo metodo crea un pannello che viene posizionato a nord del frame. Include un pulsante "Esci" per fare il logout dal sistema.
	 * 
	 * @return JPanel il pannello posizionato a nord.
	 */
	public JPanel creatPanelNord(){
		
		JPanel panel= new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.setBorder(bordo);
		panel.setBackground(Color.lightGray);
		
		JLabel lbenvenuto= new JLabel("Benvenuto  ");
		lbenvenuto.setFont(font);
		panel.add(lbenvenuto, BorderLayout.WEST);
		
		
		JLabel lgestore= new JLabel(String.valueOf(gestore.getUsername()));
		lgestore.setFont(font);
		lgestore.setForeground(Color.WHITE);
		panel.add(lgestore);
		
		
		JButton besci= new JButton("Esci");
		besci.setFont(font);
		besci.setBackground(Color.WHITE);
		panel.add(besci, BorderLayout.EAST);
		
		/**
		 * Classe interna. Questo evento associato al pulsante besci serve per fare il logout.
		 *
		 */
		class ClickEsciListener implements ActionListener{
			
			/**
			 * Evento necessario per fare il logout dal sistema nel momento in cui viene cliccato il pulsante "Esci".
			 */
			public void actionPerformed(ActionEvent e){
				db.disconnetti();
				System.exit(0);
				
			}
			
			
		}		
		
		besci.addActionListener(new ClickEsciListener());
		
		return panel;
		
		
	}
	
	/**
	 * Questo metodo crea un pannello che viene posizionato a sud del frame. Contiene un pulsante "Vai al parco".
	 * 
	 * @return JPanel panello che viene posizionato a sud del frame
	 */
	public JPanel creatPanelSud(){
		
		bvai= new JButton("Vai al Parco");
		bvai.setPreferredSize(new Dimension(180,80));
		bvai.setFont(font);
		bvai.setBackground(Color.WHITE);
		
		JPanel panel= new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		panel.add(bvai, BorderLayout.EAST);
		
	
		
		return panel;
		
	}
	
	/**
	 * Questo metodo creat un pannello che viene posizionato al centro del frame. Il pannello contiene una tabella dove vengono mostrati i dati
	 * in forma tabellare.
	 * 
	 * @return JPanel pannello che viene posizionato al centro del frame.
	 */
	public JPanel creatPanelCenter(){
		
		
		JPanel panel= new JPanel();
		TableParcoModel parcomodel= new TableParcoModel(gestore.getParchi());
		table= new JTable(parcomodel);

		
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setMinWidth(0);
		col.setMaxWidth(0);
		col.setPreferredWidth(0);
		col.setResizable(false);
		
		col = table.getColumnModel().getColumn(1);
		col.setResizable(false);
		col = table.getColumnModel().getColumn(2);
		col.setResizable(false);
		
		table.setPreferredScrollableViewportSize(new Dimension(980,100));
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jps= new JScrollPane(table);
		
		panel.add(jps);
		panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		
		return panel;

}
	
	/**
	 * Questo metodo preleva le informazioni riguardanti i vari tipi di parchi e viene popolato l'arraylist relativo ai parchi gestiti dal gestore.
	 */
	
	private void controllaTipoParchi(){
		
		
		String sql="SELECT p.codice, p.nome, p.sede, p.biglietti_disp FROM gestore g JOIN parco p ON g.username=p.gestore WHERE g.username='"+ gestore.getUsername() + "'";
		Vector v = db.eseguiQuery(sql);
		
		for(int i=0;i<v.size();i++){
			
	
			String[] result = (String[]) v.get(i);
			
			sql="SELECT pac.numpiscine FROM pacquatico pac JOIN parco ON pac.parco=parco.codice WHERE parco.codice='"+ result[0]+"'";	

			Vector vse;
			String[] resultse=null;
			
			if((vse= (db.eseguiQuery("SELECT pac.numpiscine FROM pacquatico pac JOIN parco ON pac.parco=parco.codice WHERE parco.codice='"+ result[0]+"'"))).size()==1){
				
				resultse= (String[]) vse.get(0);
				
				gestore.addParco(new ParcoAcquatico(result[0],result[1],result[2],Integer.parseInt(result[3]),Integer.parseInt(resultse[0])));

			}
			
			else if((vse= (db.eseguiQuery("SELECT pav.percorso FROM pavventura pav JOIN parco ON pav.parco=parco.codice WHERE parco.codice='"+ result[0]+"'"))).size()==1){

				resultse= (String[]) vse.get(0);
				
				gestore.addParco(new ParcoAvventura(result[0],result[1],result[2],Integer.parseInt(result[3]),resultse[0]));
		
			}
			
			else if((vse= (db.eseguiQuery("SELECT pt.tema FROM ptematico pt JOIN parco ON pt.parco=parco.codice WHERE parco.codice='"+ result[0]+"'"))).size()==1){
				
				resultse= (String[]) vse.get(0);
				
				gestore.addParco(new ParcoTematico(result[0],result[1],result[2],Integer.parseInt(result[3]),resultse[0]));
				
			}	
			
			else{
				
				gestore.addParco(new Parco(result[0],result[1],result[2],Integer.parseInt(result[3])));
			}
			
		}	
		
		
		
	}
	
	
	/**
	 * Questo metodo controlla la riga selezionata relativo al parco a cui si vuole accedere. Cattura un eccezione del tipo 
	 * ArrayIndexOutOfBoundsException nel momento in cui si clicca su una parte della che non contiene alcuna informazione relativa al parco.
	 * 
	 * @param table tabella 
	 */
	private void controllaRigaSelezionata(JTable table){
		
		
		try{

			int row;
    		row = table.getSelectedRow();
    		Parco p= (Parco) table.getValueAt(row, 0);		
    		ParcoFrame parco= new ParcoFrame(p,db);
    		
		}

		catch(ArrayIndexOutOfBoundsException ex){
			
			JOptionPane m= new JOptionPane();
			m.showMessageDialog(null, "Riga non selezionata!");
			
		}
	}


	
	
	public String toString() {
		
		return  super.toString() + "[gestore=" + gestore + ", db=" + db + ", bvai=" + bvai + ", table=" + table + "]";
	}



	private Gestore gestore=null;
	private static final Border bordo= BorderFactory.createLineBorder(Color.WHITE);
	private Database db=null;
	private static final Font font= new Font("Verdana", Font.HANGING_BASELINE, 20);
	private JButton bvai;
	private JTable table;
}
