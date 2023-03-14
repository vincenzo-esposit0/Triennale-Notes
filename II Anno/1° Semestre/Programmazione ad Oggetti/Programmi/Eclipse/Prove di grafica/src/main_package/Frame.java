package main_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Frame {
	//Costruttore
	public Frame() {
		createButtonSpara();
		createButtonProva();
		createMenu();
		createPanel();
		createFrame();
		frame.add(panel);
		frame.setJMenuBar(menubar);
	}
	
	//Crea il frame
	public void createFrame() {
		frame=new JFrame();
		frame.setSize(1050,430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Prove di grafica");
		frame.setVisible(true);
		
	}
	
	//Crea il panel
	public void createPanel() {
		panel=new JPanel();

		JPanel p1=new JPanel();
		jcb=new JComboBox();
		jcb1=new JCheckBox("Check");
		jcb.addItem("Prova 1");
		jcb.addItem("Prova 2");
		jcb.addItem("Prova 3");
		p1.add(jcb1);
		p1.add(jcb);
		p1.add(bottone);
		
		JPanel p2=new JPanel();
		jrb1=new JRadioButton("Erica");
		jrb1.setSelected(true);
		jrb2=new JRadioButton("Peppe");
		jrb3=new JRadioButton("Distanza");
		gruppo=new ButtonGroup();
		gruppo.add(jrb1);
		gruppo.add(jrb2);
		gruppo.add(jrb3);
		p2.add(jrb1);
		p2.add(jrb2);
		p2.add(jrb3);
		p2.add(bottone2);
		
		JPanel p3=new JPanel();
		jta=new JTextArea(20,90);
		p3.add(jta);
		
		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
	}
	
	//Crea il menu
	public void createMenu() {
		menubar=new JMenuBar();
		JMenu sm=new JMenu("Prova");
		mi1=new JMenuItem("Exit");
		
		class Azione1 implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("ciao");
				System.exit(1);
			}
		}
		
		ActionListener listener=new Azione1();
		mi1.addActionListener(listener);
		sm.add(mi1);
		menubar.add(sm);
		
	}
	
	//Crea il bottone
	public void createButtonSpara() {
		bottone=new JButton("Spara");
		class Azione implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				jta.setText("");
				if (!jcb1.isSelected()) {
					String sel=(String) jcb.getSelectedItem();
					if (sel.compareTo("Prova 3")==0) {
						jta.append("Prova 3");
					}else if (sel.compareTo("Prova 2")==0) {
						jta.append("Prova 2");
					}else if(sel.compareTo("Prova 1")==0){
						jta.append("Prova 1");
					}
				}else
					jta.append("O check frate altrimenti non ci muoviamo");
				
			}
		}
		ActionListener listener=new Azione();
		bottone.addActionListener(listener);
	}
	
	//Crea il secondo bottone
	public void createButtonProva() {
		bottone2=new JButton("Prova");
		class Prova implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				jta.setText("");
				if (!jcb1.isSelected()) {
					if(jrb1.isSelected()) {
						jta.append("Indescrivibilmente lei...");
					}else if(jrb2.isSelected()) {
						jta.append("Ecchime ;)");
					}else if(jrb3.isSelected()){
						jta.append("Una cosa brutta...");
					}	
				}else
					jta.append("Ancora ? ma si sciem o cosa ?");
			}
		}
		ActionListener listener=new Prova();
		bottone2.addActionListener(listener);
	}
	
	//Attributi
	public JFrame frame;
	public JPanel panel;
	public JComboBox jcb;
	public JTextArea jta;
	public JButton bottone;
	public JButton bottone2;
	public ButtonGroup gruppo;
	public JRadioButton jrb1;
	public JRadioButton jrb2;
	public JRadioButton jrb3;
	public JCheckBox jcb1;
	public JMenuBar menubar;
	public JMenuItem mi1;
	
	
}
