package main_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
			incremento();
			
	}
	//Incremento
	public void incremento() { i++; };
	//Get
	public int getI() { return i; }
	//Attributi
	private int i;
}
