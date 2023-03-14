package it.unisa.Agenzia.GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unisa.Agenzia.Agenzia;
import it.unisa.Connection.Database;
import it.unisa.parco.GUI.ParcoFrame;
/**
 * 
 * @author Paolo Vigorito
 * @author Vincenzo Loris Proto
 * 
 */
public class LoginFrame extends JFrame{
	/**
	 * Costruzione del frame per il login
	 * 
	 * @param db database per prelevare le informazioni relative all' agenzia di cui si farà il login
	 */
	public LoginFrame(Database db){
		
		this.db=db;
		this.setLayout(new BorderLayout());
		
		add(creatPanelNord(),BorderLayout.NORTH);
		add(creatPanelCenter(),BorderLayout.CENTER);
		
		
		this.setTitle("Area Login");
		this.setSize(new Dimension(500,500));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	
	
	
	
	/**
	 * Il pannello a nord contiene il pulsante per uscire e un titolo
	 * 
	 * @return JPanel pannello che viene posizionato a nord del frame che lo contiene
	 */
	public JPanel creatPanelNord(){
		
		JPanel panel= new JPanel();
		
		
		JLabel lbenvenuto= new JLabel("Area Login Agenzia");
		lbenvenuto.setFont(font);
		panel.add(lbenvenuto);
		
		JButton besci= new JButton("Esci");
		besci.setBackground(Color.WHITE);
		besci.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				System.exit(0);
				
			}
			
		});
		
		panel.add(besci);
		
		panel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panel.setBackground(Color.orange);
		return panel;
		
	}
	
	/**
	 * Il pannello centrale consente l'inserimento dell'iva ( JtextField) e con il JButton "ACCEDI" permette il login
	 * 
	 * @return JPanel pannello che viene posizionato al centro del frame che lo contiene
	 */
	public JPanel creatPanelCenter(){
		
		
		JPanel panel= new JPanel();
		GridBagLayout layout= new GridBagLayout();
		GridBagConstraints lim= new GridBagConstraints();
		
		panel.setLayout(layout);
		JLabel lpiva= new JLabel("Partita Iva");
		lpiva.setFont(font);
		set(lim,0,0,1,1,GridBagConstraints.HORIZONTAL, 1, 0);
		panel.add(lpiva,lim);
		
		JTextField pivatext= new JTextField();
		pivatext.setFont(font);
		pivatext.setInputVerifier(new MyStandardVerifier());
		set(lim,0,1,1,1,GridBagConstraints.HORIZONTAL, 1, 0);
		panel.add(pivatext,lim);
		
		JButton blogin= new JButton("Accedi");
		blogin.setFont(font);
		blogin.setBackground(Color.ORANGE);
		set(lim,0,2,1,1,GridBagConstraints.VERTICAL, 1,0 );
		panel.add(blogin,lim);
		
		blogin.addActionListener(new ActionListener(){
			/**
			 * Selezione dell'agenzia in base alla pIVA. in caso di pIVA non presente nel database si lancia un messaggio di errore 
			 */
			public void actionPerformed(ActionEvent e){
				
				String sql="SELECT agenzia.*FROM agenzia WHERE agenzia.piva='"+pivatext.getText()+"'";
				Vector v= db.eseguiQuery(sql);
				if(v.size()==0){
					
					JOptionPane mess= new JOptionPane();
					mess.showMessageDialog(null, "PIVA NON ESISTENTE!");
				}
				
				else{
					
					String[] resultagenzia= (String[]) v.get(0);
					Agenzia a= new Agenzia(resultagenzia[0],resultagenzia[1],resultagenzia[2],resultagenzia[3],Double.parseDouble(resultagenzia[4]));
					AgenziaFrame agenziaframe= new AgenziaFrame(db,a);
					
				}
				
				
				
			}
		});
	
		
		panel.setBackground(Color.LIGHT_GRAY);
		return panel;
	}
	/**
	* con questo metodo settiamo tutti i parametri dei gridbag
	 */
	private void set(GridBagConstraints lim, int gridx, int gridy, int gridwidth, int gridheight, int fill, int weightx, int weighty){
		lim.gridx = gridx;
		lim.gridy = gridy;
		lim.gridwidth = gridwidth;
		lim.gridheight = gridheight;
		lim.fill=fill;
		lim.weightx=weightx;
		lim.weighty=weighty;
	}
	
	/**
	 * Questo metodo consente la verifica dell'input del JTextField della pIVA
	 */
	private class MyStandardVerifier extends InputVerifier {
		
		public boolean verify(JComponent input) {
			
			String text = ((JTextField) input).getText();
			Pattern p = Pattern.compile("^[0-9]{11}$");
			Matcher matcher= p.matcher(text);
			
			if(!matcher.matches()){
				
				JOptionPane m= new JOptionPane();
				m.showMessageDialog(null, "Campo PIVA non corretto! Inserire esattamente 11 caratteri!");
				return false;	
				
			}
			
			return true;
		}
	}
	
	
	
	public String toString() {
		return super.toString() +"[db=" + db + "]";
	}

	public static final Font font= new Font("Verdana", Font.HANGING_BASELINE, 20);

	private Database db;

	

}
