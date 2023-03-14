package main_package;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class FrameDisegni {
	//Costruttore
	public FrameDisegni(int x) {
		createFrame();
		createRectangle(x);
		frame.setVisible(true);
		
	}
	
	//Crea il frame
	public void createFrame() {
		frame=new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Disegni");
	}
	
	//Crea il panel
	public void createRectangle(int x) {
		RettangleComponent ret=new RettangleComponent(x);
		frame.add(ret);
	}
	
	//Attributi
	public JFrame frame;
	public Rectangle rettangolo;
}
