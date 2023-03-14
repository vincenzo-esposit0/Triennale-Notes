package main_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame {
	//Costruttore
	public Frame() {
		createButtonDisegna();
		createPanel();
		createFrame();
		frame.add(panel);
	}
	
	//Crea il frame
	public void createFrame() {
		frame=new JFrame();
		frame.setSize(300,80);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Richiesta");
		frame.setVisible(true);
	}
	
	//Crea il panel
	public void createPanel() {
		panel=new JPanel();
		panel.add(new JLabel("Numero cerchi: "));
		panel.add(jtf = new JTextField(5));
		panel.add(disegna);
	}
	
	//Crea il bottone
	public void createButtonDisegna() {
		disegna=new JButton("Disegna");
		class AzioneDisegna implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				FrameDisegni ds=new FrameDisegni(Integer.parseInt(jtf.getText()));
			}
		}
		ActionListener listener=new AzioneDisegna();
		disegna.addActionListener(listener);
	}
	
	//Attributi
	public JFrame frame;
	public JPanel panel;
	public JTextField jtf;
	public JButton disegna;
}
