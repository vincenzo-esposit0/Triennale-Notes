package main_package;

public class TriangoloIsoscele extends FigureGeometriche{
	//Costruttore
	public TriangoloIsoscele(double base,double altezza) {
		super();
		this.base=base;
		this.altezza=altezza;
		this.area=(base*altezza)/2;
		this.perimetro=(base+2*(Math.sqrt(Math.pow(base/2, 2)+Math.pow(altezza, 2))))/2;
	}
	//Metodi get e set
	public double getBase() { return base;}
	public double getAltezza() {return altezza;}
	public void setBase(double base) { this.base=base;}
	public void setAltezza(double altezza) { this.altezza=altezza;}
	//Metodo toString
		public String toString() {
			return "Triangolo isoscele: "+base+" "+altezza+" "+perimetro+" "+area;
		}
	//Attributi
	public double base;
	public double altezza;
}
