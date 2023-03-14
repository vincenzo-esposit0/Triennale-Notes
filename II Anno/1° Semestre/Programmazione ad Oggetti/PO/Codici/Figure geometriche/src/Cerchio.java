
public class Cerchio extends FigureGeometriche{

	public Cerchio(String colore, float raggio)
	{
		super(colore);
		this.raggio= raggio;
		
	}
	
	public float getArea()
	{
		return (float)((raggio*raggio)*tt);
	}
	
	public float getPerimetro()
	{
		
		return (float)((raggio+raggio)*tt);
	}
	
	private float raggio;
	private final double tt = 3.14;
}
