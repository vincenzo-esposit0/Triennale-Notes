package main_package;

import java.awt.*;
import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		JButton bottone=new JButton("Cliccami tutto");
		ClickListener listener=new ClickListener();
		final JLabel label=new JLabel("Contatore: "+listener.getI());
		JPanel panel=new JPanel();
		bottone.addActionListener(listener);
		panel.add(bottone);
		panel.add(label);
		frame.add(panel);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
