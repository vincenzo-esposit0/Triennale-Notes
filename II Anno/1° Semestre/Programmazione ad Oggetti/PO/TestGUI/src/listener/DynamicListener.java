package listener;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import entity.User;

public class DynamicListener implements ActionListener{
	private JScrollPane contentpane;
	private JPanel panel;
	
	public DynamicListener(JPanel panel, JScrollPane contentpane) {
		this.panel = panel;
		this.contentpane = contentpane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int randomInteger = 0;
		String baseUser = "User";
		String basePassword = "Password";
		String baseEmail = "Email";
		User us = null;
		ArrayList<User> users = new ArrayList<User>();
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			randomInteger = random.nextInt();
			us = new User(baseUser+"_"+randomInteger, basePassword+"_"+randomInteger, baseEmail+"_"+randomInteger);
			users.add(us);
			
//			-----------------------------------------------------------------------
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(0, 4, 0, 0));

			JPanel panel_2 = new JPanel();
			panel_1.add(panel_2);
			
			panel_2.add(new JLabel(baseUser+"_"+randomInteger));
			
			JPanel panel_3 = new JPanel();
			panel_1.add(panel_3);
			
			JComboBox<Double> comboBox = new JComboBox<Double>();
			for(double n=1; n<=5; n++) {
				comboBox.addItem(n);
			}
			panel_3.add(comboBox);
			
			JPanel panel_4 = new JPanel();
			panel_1.add(panel_4);
			
			JButton btnVota = new JButton("Vota");
			panel_4.add(btnVota);
			
			JPanel panel_5 = new JPanel();
			panel_1.add(panel_5);
			
			JLabel lblMedia = new JLabel("0");
			panel_5.add(lblMedia);
			
			btnVota.addActionListener(new Vota(us, comboBox, lblMedia));
//			-----------------------------------------------------------------------			
			
            this.panel.add(panel_1);
            this.panel.setPreferredSize(new Dimension(0, 50 * this.panel.getComponents().length));
            this.contentpane.validate();
		}
	}

}
