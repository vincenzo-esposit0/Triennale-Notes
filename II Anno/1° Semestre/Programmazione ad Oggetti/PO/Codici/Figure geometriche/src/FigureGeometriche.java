
public abstract class FigureGeometriche {
	public FigureGeometriche(String colore)
	{
		this.colore=colore;
	}
	
	public String getColore()
	{
		return colore;
	}
	
	public abstract float getArea();
	
	public abstract float getPerimetro();
	
	private String colore;
}
