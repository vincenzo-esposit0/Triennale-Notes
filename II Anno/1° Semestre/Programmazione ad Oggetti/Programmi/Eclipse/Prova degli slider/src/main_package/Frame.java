package main_package;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Frame {
	//Costruttore
	public Frame() {
		createSlider();
		createPanel();
		createFrame();
		frame.add(panel);
	}
	
	//Crea il frame
	public void createFrame() {
		frame=new JFrame();
		frame.setSize(500,500);
		frame.setTitle("Colore");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//Crea il pannelo
	public void createPanel() {
		panel=new JPanel();
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(3,1));
		p2.add(reds);
		p2.add(blues);
		p2.add(greens);
		
		panel.add(p2);
	}
	
	//Setta il colore del pannelo
	public void setColor() {
		p2.setBackground(new Color(reds.getValue(),greens.getValue(),blues.getValue()));
	}
	
	//Crea gli slider
	public void createSlider() {
		class ColorListener implements ChangeListener{
			public void stateChanged(ChangeEvent arg0) {
				setColor();
			}
		}
		ChangeListener listener=new ColorListener();
		
		reds = new JSlider(0,100,0);
		reds.addChangeListener(listener);
		
		greens = new JSlider(0,100,100);
		greens.addChangeListener(listener);
		
		blues = new JSlider(0,100,0);
		blues.addChangeListener(listener);
	}
	
	//Attributi
	public JFrame frame;
	public JPanel panel;
	public JPanel p2;
	public JSlider reds;
	public JSlider greens;
	public JSlider blues;
	
}
