
public class TriangoloIsoscele extends FigureGeometriche{

	public TriangoloIsoscele(String colore, float base, float lato, float altezza)
	{
		super(colore);
		this.base=base;
		this.lato=lato;
		this.altezza=altezza;
	}
	
	public float getPerimetro()
	{
		return ((lato*2)+base);
	}
	
	public float getArea()
	{
		return base*altezza;
	}
	
	private float base;
	private float lato;
	private float altezza;
}
