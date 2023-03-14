package main_package;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class CerchioComponent extends JComponent{
	//Costruttore
	public CerchioComponent(int x,int y,int diametro,Color colore) {
		super();
		this.x=x;
		this.y=y;
		this.diametro=diametro;
		this.colore=colore;
	}
	
	//Metodo paint
	public void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D) g;
		Ellipse2D.Double ellisse=new Ellipse2D.Double(x,y,diametro,diametro);
		g2.setColor(colore);
		g2.draw(ellisse);
	}
	
	//Attributi
	private int x;
	private int y;
	private int diametro;
	private Color colore;
}
