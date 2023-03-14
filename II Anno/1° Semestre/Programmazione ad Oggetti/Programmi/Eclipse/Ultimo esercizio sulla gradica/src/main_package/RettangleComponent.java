package main_package;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent;

public class RettangleComponent extends JComponent{
	//Cpstruttore
	public RettangleComponent(int x) {
		this.x=x;
		rand=new Random();
	}
	
	//Metodo paint
	public void paintComponent(Graphics g) {
		Graphics2D g2= (Graphics2D) g;
		for (int i=0;i<x;i++) {
			Rectangle rettangolo=new Rectangle(rand.nextInt(500),rand.nextInt(500),20,10);
			g2.draw(rettangolo);
		}
	}
	
	//Attrbuti
	public int x;
	public Random rand;
}
