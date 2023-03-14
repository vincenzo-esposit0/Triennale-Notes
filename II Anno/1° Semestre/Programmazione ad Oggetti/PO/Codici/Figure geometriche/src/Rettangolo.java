
public class Rettangolo extends FigureGeometriche{

	public Rettangolo(String colore, float base, float altezza)
	{	
	super(colore);
	this.base=base;
	this.altezza=altezza;
	}
	
	public float getArea()
	{
		return base*altezza;
	}
	
	public float getPerimetro()
	{
		return (base+altezza)*2;
	}
	
	private float base;
	private float altezza;
}
