package main_package;

public class FigureGeometriche {
	//Costruttore
	public FigureGeometriche() {
		area=0;
		perimetro=0;
	}
	//Metodi get
	public double getArea() { return area;}
	public double getPerimetro() { return perimetro;}
	//Attributi
	protected double area;
	protected double perimetro;
}
