package main_package;

import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.Rectangle; 
import javax.swing.JPanel; 
import javax.swing.JComponent; 
import java.awt.geom.Ellipse2D;

public class RectangleComponent extends JComponent{ 
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ellisse1=new Ellipse2D.Double(400, 700, 200, 200);
		Ellipse2D.Double ellisse2=new Ellipse2D.Double(600, 700, 200, 200);
		Ellipse2D.Double ellisse3=new Ellipse2D.Double(500, 40, 200, 800);
		g2.draw(ellisse1);
		g2.draw(ellisse2);
		g2.draw(ellisse3);
	}
}