package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import entity.User;

public class Vota implements ActionListener{
	private JComboBox<Double> voti;
	private User us;
	private JLabel media;
	
	public Vota(User us, JComboBox<Double> voti, JLabel media) {
		this.us = us;
		this.voti = voti;
		this.media = media;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Double letto = (Double) this.voti.getSelectedItem();
		this.us.vota(letto);
		this.media.setText(this.us.getMedia()+"");
	}

}
