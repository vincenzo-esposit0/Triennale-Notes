package contenitori;

public class Cilidrico extends Contenitore {
	
	public Cilidrico(String nome, String codice, double prezzo, double capienza, double raggio, double altezza)
	{
		super(nome, codice, prezzo, capienza);
		this.raggio = raggio;
		this.altezza = altezza;
	}
	
	public double getRaggio()
	{
		return this.raggio;
	}
	
	public double getAltezza()
	{
		return this.altezza;
	}
	
	public void setRaggio(double raggio)
	{
		this.raggio = raggio;
	}
	
	public void setAltezza(double altezza)
	{
		this.altezza = altezza;
	}
	
	@Override
	public String toString() {
		return super.toString() + "[Raggio: "+ this.raggio + "]" + "[ALtezza: "+ this.altezza + "]" ;
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject))
			return false;
		
		Cilidrico c1 = (Cilidrico) otherObject;
		return this.altezza == c1.getAltezza() && this.raggio == c1.getRaggio();
	}
	
	@Override
	
	public Object clone()
	{
		Cilidrico cloned = (Cilidrico) super.clone();
		cloned.setAltezza(this.altezza);
		cloned.setRaggio(this.raggio);
		return cloned;
	}
	
	private double raggio;
	private double altezza;

}
