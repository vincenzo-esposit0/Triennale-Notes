package it.unisa.parco.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import com.mysql.jdbc.PreparedStatement;
import com.sun.glass.events.MouseEvent;

import it.unisa.Connection.Database;
import it.unisa.parco.Gestore.Gestore;
import javafx.geometry.Insets;
import javafx.scene.layout.Border;


/**
 * 
 * @author Paolo
 * @author Loris Proto
 */


public class IndexFrame extends JFrame {
	
	
	
	/**
	 * Costruisce un nuovo frame basandosi su un pannello di login per l'accesso al gestore. Inoltre si connette al database relativo ai parchi
	 * e setta alcuni parametri relativi alle dimensioni del frame e alle sue caratteristiche
	 */
	public IndexFrame(Database db){
		
		this.db=db;
		
		this.creatLoginPanel();					
		loginpanel.setVisible(true);


			
			this.setTitle("Area Login");
			this.setSize(new Dimension(500,500));
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);

		
	}
	
	/**
	 * Questo metodo crea un pannello per il login relativo al gestore.
	 */
	public void creatLoginPanel(){
		
		
		loginpanel= new JPanel();
		JPanel panelcx = new JPanel();
		JPanel panelsud=new JPanel();
		JPanel panelnord= new JPanel();
		
		fusername= new JTextField("Username");
		jpassword= new JPasswordField();
		
		JLabel lnord=new JLabel("Gestore Login");
		lnord.setFont(font);
		
		baccedi= new JButton("Accedi");
		baccedi.setBackground(Color.WHITE);
		baccedi.setFont(font);
		
		
		GridBagConstraints lim= new GridBagConstraints();
		GridBagLayout layout= new GridBagLayout();
		
		panelcx.setLayout(layout);

		panelnord.add(lnord);
		
		lim.gridx=0;
		lim.gridy=0;
		fusername.setPreferredSize(new Dimension(300,50));
		fusername.setFont(new Font("Verdana", Font.BOLD, 20));
		panelcx.add(fusername, lim);
		
		lim.gridx=0;
		lim.gridy=1;
		lim.insets.top=20;
		jpassword.setPreferredSize(new Dimension(300,50));
		panelcx.add(jpassword,lim);
		
		
		panelsud.add(baccedi);
		
		
		loginpanel.setLayout(new BorderLayout());
		loginpanel.add(panelsud, BorderLayout.SOUTH);
		loginpanel.add(panelcx, BorderLayout.CENTER);
		loginpanel.add(panelnord, BorderLayout.NORTH);
		
		loginpanel.setVisible(true);
		this.add(loginpanel);
		
		/**
		 * Classe interna che permette di gestire un evento relativo al mouse nel momento in cui si clicca sul componente fusername.
		 *
		 */
		class FieldTextClickListener implements MouseListener{

			/**
			 * Setta a vuoto la casella di testo "Username".
			 */
			public void mouseClicked(java.awt.event.MouseEvent e) {
				
					 fusername.setText("");
					
			}
			
			public void mouseEntered(java.awt.event.MouseEvent e) {}
			public void mouseExited(java.awt.event.MouseEvent e) {}
			public void mousePressed(java.awt.event.MouseEvent e) {}			
			public void mouseReleased(java.awt.event.MouseEvent e) {}
			
		}
		
		
		class CAccediGestoreListener implements ActionListener {
			
			public void actionPerformed(ActionEvent e){

					
				String sql="SELECT gestore.username, gestore.password FROM gestore WHERE gestore.username='"+fusername.getText()+"' and password='"+jpassword.getText()+"'";
				Vector v = db.eseguiQuery(sql);
				
				if(v.size()==0){
					
					JOptionPane m= new JOptionPane();
					m.showMessageDialog(null, "Username o Password Errati!");
					
				}
				else{
					String[] result=(String[]) v.get(0);
					
					
					JFrame gf= new GestoreFrame(new Gestore(result[0],result[1]), db);
					IndexFrame.this.setVisible(false);		
				}
	
			}
		}
		
		accedilistener= new CAccediGestoreListener();
		baccedi.addActionListener(accedilistener);

		
		MouseListener listener= new FieldTextClickListener();
		fusername.addMouseListener(listener);

	}
	
	
	/*public void creatRegistratiPanel(){
		
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		
		JButton beffettuareg= new JButton("Registrazione");
		
		JLabel luser= new JLabel("Username (* no spazi!)");
		JLabel lpass= new JLabel("Password (* no spazi!)");
		JLabel ltipo= new JLabel("Tipo");
		JLabel lerror= new JLabel();
		
		JComboBox ctipo= new JComboBox();
		registratipanel=new JPanel();
		
		fusername=new JTextField();
		jpassword=new JPasswordField();
		
		registratipanel.setLayout(layout);
		
		
		lim.gridx=0;
		lim.gridy=0;
		lim.fill=GridBagConstraints.BOTH;
		ltipo.setPreferredSize(new Dimension(100,20));
		ltipo.setFont(new Font("Verdana", Font.BOLD, 20));
		layout.setConstraints(ltipo, lim);
		registratipanel.add(ltipo);
		
		lim.gridx=0;
		lim.gridy=1;
		lim.fill=GridBagConstraints.BOTH;
		ctipo.addItem("Agenzia");
		ctipo.addItem("Gestore");
		layout.setConstraints(ctipo, lim);
		registratipanel.add(ctipo);
		 
		lim.gridx=0;
		lim.gridy=2;
		lim.insets.top=10;
		lim.insets.bottom=10;
		lim.insets.left=10;
		lim.insets.right=10;
		lim.fill=GridBagConstraints.BOTH;
		luser.setPreferredSize(new Dimension(100,20));
		luser.setFont(new Font("Verdana", Font.BOLD, 20));
		layout.setConstraints(luser, lim);
		registratipanel.add(luser);
		
		lim.gridx=0;
		lim.gridy=3;
		lim.insets.top=0;
		lim.insets.bottom=0;
		lim.insets.left=0;
		lim.insets.right=0;
		fusername.setPreferredSize(new Dimension(300,50));
		fusername.setFont(new Font("Verdana", Font.BOLD, 20));
		layout.setConstraints(fusername, lim);
		registratipanel.add(fusername);
		
		lim.gridx=0;
		lim.gridy=4;
		lim.insets.top=10;
		lim.insets.bottom=10;
		lim.insets.left=10;
		lim.insets.right=10;
		lim.fill=GridBagConstraints.BOTH;
		lpass.setPreferredSize(new Dimension(100,20));
		lpass.setFont(new Font("Verdana", Font.BOLD, 20));
		layout.setConstraints(lpass, lim);
		registratipanel.add(lpass);
		
		lim.gridx=0;
		lim.gridy=5;
		lim.insets.top=0;
		lim.insets.bottom=0;
		lim.insets.left=0;
		lim.insets.right=0;
		jpassword.setPreferredSize(new Dimension(300,50));
		jpassword.setFont(new Font("Verdana", Font.BOLD, 20));
		layout.setConstraints(jpassword, lim);
		registratipanel.add(jpassword);
		
		
		lim.gridx=0;
		lim.gridy=6;
		lim.insets.top=10;
		lim.insets.bottom=10;
		lim.insets.left=10;
		lim.insets.right=10;
		lim.ipadx=50;
		lim.ipady=50;
		layout.setConstraints(beffettuareg, lim);
		registratipanel.add(beffettuareg);
		
		lim.gridx=0;
		lim.gridy=7;
		lim.insets.top=0;
		lim.insets.bottom=0;
		lim.insets.left=0;
		lim.insets.right=0;
		lim.ipadx=0;
		lim.ipady=0;
		lerror.setVisible(false);
		layout.setConstraints(lerror, lim);
		registratipanel.add(lerror);
		
		registratipanel.setVisible(false);
		this.add(registratipanel);
		
		class CRegistratiListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				lerror.setVisible(false);
				
				if(fusername.getText().isEmpty() || fusername.getText().contains(" ") || new String(jpassword.getPassword()).isEmpty() || new String(jpassword.getPassword()).contains(" ")){
					
					lerror.setText("Campi non compilati correttamente!");
					lerror.setVisible(true);
				}
				
				else{
					
				}
				
			}
		}
		
		ActionListener registratilistener= new CRegistratiListener();
		beffettuareg.addActionListener(registratilistener);
		
	}*/
	
	 	


	public String toString() {
		return super.toString() +"[baccedi=" + baccedi + ", loginpanel=" + loginpanel + ", fusername=" + fusername
				+ ", jpassword=" + jpassword + ", accedilistener=" + accedilistener + ", db=" + db + "]";
	}

	//private JLabel lchoice;	
//	private JButton bgestore;
	private JButton baccedi;
	
	// private JPanel controlpanel;
	private JPanel loginpanel;
//	private JPanel registratipanel;
	
	private JTextField fusername;
	private JPasswordField jpassword;

	private ActionListener accedilistener;
	private Database db=null;
	private static final Font font= new Font("Verdana", Font.HANGING_BASELINE, 20);


}
