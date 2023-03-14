package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import entity.User;

public class Registra implements ActionListener {
	private JTextField nome;
	private JTextField password;
	private JTextField email;
	private JTextField numUser;
	private JTextArea userArea, passwordArea, emailArea;

	public Registra(JTextField nome, JTextField password, JTextField email,
			JTextArea userArea, JTextArea passwordArea, JTextArea emailArea, 
			JTextField numUser) {
		this.nome = nome;
		this.password = password;
		this.email = email;		
		this.numUser = numUser;
		this.userArea = userArea;
		this.emailArea = emailArea;
		this.passwordArea = passwordArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String numOld = this.numUser.getText();
		int numUserInt = 0;
		if(numOld.length() != 0) {
			numUserInt = Integer.parseInt(numOld);			
		}
		
		numUserInt++;
		this.numUser.setText(numUserInt+"");
		this.userArea.append(this.nome.getText()+"\n");
		this.passwordArea.append(this.password.getText()+"\n");
		this.emailArea.append(this.email.getText()+"\n");
	}

}
