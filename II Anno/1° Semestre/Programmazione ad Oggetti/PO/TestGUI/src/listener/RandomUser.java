package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import entity.User;

public class RandomUser implements ActionListener {
	private Random random = null;
	private JTextArea userArea, passwordArea, emailArea;
	private JTextField numUser;
	
	public RandomUser(JTextArea userArea, JTextArea passwordArea, JTextArea emailArea, JTextField numUser) {
		random = new Random();
		this.userArea = userArea;
		this.emailArea = emailArea;
		this.passwordArea = passwordArea;
		this.numUser = numUser;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int randomInteger = 0;
		String baseUser = "User";
		String basePassword = "Password";
		String baseEmail = "Email";
		User us = null;
		
		String numOld = this.numUser.getText();
		int numUserInt = 0;
		if(numOld.length() != 0) {
			numUserInt = Integer.parseInt(numOld);			
		}

		for (int i = 0; i < 10; i++) {
			randomInteger = random.nextInt();
			us = new User(baseUser+"_"+randomInteger, basePassword+"_"+randomInteger, baseEmail+"_"+randomInteger);
			this.userArea.append(baseUser+"_"+randomInteger+"\n");
			this.passwordArea.append(basePassword+"_"+randomInteger+"\n");
			this.emailArea.append(baseEmail+"_"+randomInteger+"\n");
			numUserInt++;
		}
		
		this.numUser.setText(numUserInt+"");
	}

}
