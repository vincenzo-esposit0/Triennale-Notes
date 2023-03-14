import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {
	//Costruttore
	public Frame() {
		gen=new Generatore();
		createButton();
		createPanel();
		createFrame();
		frame.add(panel);
	}
	
	//Crea il frame
	public void createFrame() {
		frame=new JFrame();
		frame.setSize(400,400);
		frame.setTitle("Superenalotto");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//Crea il pannelo
	public void createPanel() {
		panel=new JPanel();
		
		JPanel p1=new JPanel();
		n = new JTextField(2);
		n.setText("1");
		p1.add(bottone);
		p1.add(n);
		
		JPanel p2=new JPanel();
		ta = new JTextArea(20,30);
		p2.add(ta);
		
		panel.add(p1);
		panel.add(p2);
	}
	
	//Crea il bottone
	public void createButton() {
		bottone=new JButton("Genera");
		class Genera implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				ta.setText("");
				for (int i=0;i<Integer.parseInt(n.getText());i++) {
					gen.genera();
					ta.append(gen.toString()+"\n");
				}
			}		
		}
		ActionListener listener=new Genera();
		bottone.addActionListener(listener);
	}
	
	//Attributi
	public JFrame frame;
	public JPanel panel;
	public JButton bottone;
	public JTextField n;
	public JTextArea ta;
	public Generatore gen;
}
