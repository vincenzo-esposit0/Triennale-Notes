import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {
	//Costruttore
	public Frame(ArrayList<Docente> docenti) {
		this.docenti=docenti;
		createBottoneRicerca();
		createPanel();
		createFrame();
		frame.add(panel);
	}
	
	//Crea il frame
	public void createFrame() {
		frame=new JFrame();	
		frame.setSize(740, 315);
		frame.setTitle("Simulazione prova parte due");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//Crea il panel
	public void createPanel() {
		panel=new JPanel();
			
		JPanel p1=new JPanel();
		p1.add(new JLabel("Nome,"));
		p1.add(new JLabel("Cognome,"));
		p1.add(new JLabel("Struttura"));
			
		JPanel p2=new JPanel();
		jtl1=new JTextField(10);
		jtl1.setText("");
		p2.add(jtl1);
		jtl2=new JTextField(10);
		jtl1.setText("");
		p2.add(jtl2);
		jtl3=new JTextField(10);
		jtl1.setText("");
		p2.add(jtl3);
		p2.add(cerca);
			
		JPanel p3=new JPanel();	
		jta = new JTextArea(12,60);
		p3.add(jta);
			
		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
			
	}
	
	//Create button
	public void createBottoneRicerca() {
		cerca=new JButton("Cerca");
		class Ricerca implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				Rubrica rubrica=new Rubrica(docenti);
				ArrayList<Docente> docenti;
				jta.setText("");
				docenti=rubrica.ricercaGlobale(jtl1.getText(), jtl2.getText(), jtl3.getText());
				for(int i=0;i<docenti.size();i++) {
					jta.append(docenti.get(i).toString()+"\n");
				}
			}
		}
		ActionListener listener=new Ricerca();
		cerca.addActionListener(listener);
	}
		
	//Attributi
	private  JFrame frame;
	private  JPanel panel;
	private  JButton cerca;
	private  JTextField jtl1;
	private  JTextField jtl2;
	private  JTextField jtl3;
	private  JTextArea jta;
	private ArrayList<Docente> docenti;
}
