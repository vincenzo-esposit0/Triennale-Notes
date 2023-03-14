package main_package;

public class Rettangolo extends FigureGeometriche {
	//Costruttore
	public Rettangolo(double latomax, double latomin) {
		super();
		this.latomax=latomax;
		this.latomin=latomin;
		this.perimetro=latomax+latomin*2;
		this.area=latomin*latomax;
	}
	//Metodi get e set
	public double getLatoMax() { return latomax; }
	public double getLatoMin() { return latomin; }
	public void setLatoMax(double latomax) { this.latomax=latomax;} 
	public void setLatoMin(double latomin) { this.latomin=latomin;} 
	//Metodo toString
	public String toString() {
		return "Rettangolo: "+latomax+" "+latomin+" "+perimetro+" "+area;
	}
	//Attributi
	public double latomax;
	public double latomin;
}
