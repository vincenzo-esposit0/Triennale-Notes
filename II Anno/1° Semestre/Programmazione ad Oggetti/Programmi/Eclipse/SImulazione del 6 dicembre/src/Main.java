import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		createPanel();
		createBottoneRicerca();
		createFrame();
		
		frame.add(panel);
	}
	//Crea il frame
	public static void createFrame() {
		frame=new JFrame();
		
		frame.setSize(600, 420);
		frame.setTitle("Simulazione prova parte due");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	//Crea il panel
	public static void createPanel() {
		panel=new JPanel();
		
		JPanel p1=new JPanel();
		p1.add(new JLabel("Nome                         "));
		p1.add(new JLabel("Cognome                     "));
		p1.add(new JLabel("Struttura                                      "));
		
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
		jta = new JTextArea(500,100);
		p3.add(jta);
		
		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
		
	}
	
	//Create button
	public static void createBottoneRicerca() {
		cerca=new JButton("Cerca");
		class Ricerca implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				try {
					Rubrica rubrica=new Rubrica("file.txt");
					rubrica.ricercaGlobale(jtl1.getText(), jtl2.getText(), jtl3.getText());
				} catch (FileNotFoundException e) {
					System.out.println("Errore nella lettura del file");
				}
			}
		}
		ActionListener listener=new Ricerca();
		cerca.addActionListener(listener);
	}
	
	//Attributi
	private static JFrame frame;
	private static JPanel panel;
	private static JButton cerca;
	private static JTextField jtl1;
	private static JTextField jtl2;
	private static JTextField jtl3;
	private static JTextArea jta;
	

}
