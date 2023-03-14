package main_package;

import java.math.*;

public class Cerchio extends FigureGeometriche{
	//Costruttore
	public Cerchio(double raggio) {
		super();
		this.raggio=raggio;
		this.area=Math.PI*Math.pow(raggio, 2);
		this.perimetro=2*Math.PI*raggio;
	}
	//Metodi get e set
	public double getRaggio() { return raggio; }
	public void setRaggio(double raggio) { this.raggio=raggio;} 
	//Metodo toString
	public String toString() {
		return "Cerchio: "+raggio+" "+perimetro+" "+area;
	}
	//Attributi
	private double raggio;
}
