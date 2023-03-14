package contenitori;

public class Cubico extends Contenitore {
	public Cubico(String nome, String codice, double prezzo, double capienza, double ampiezza)
	{
		super(nome, codice, prezzo, capienza);
		this.ampiezza = ampiezza;
	}
	
	public void setAmpiezza(double ampiezza)
	{
		this.ampiezza = ampiezza;
	}
	
	public double getAmpiezza()
	{
		return ampiezza;
	}
	
	@Override
	public String toString() {
		return super.toString() + "[Ampiezza: "+ this.ampiezza+ "]";
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject))
			return false;
		
		Cubico c1 = (Cubico) otherObject;
		return this.ampiezza == c1.getAmpiezza();
	}
	
	@Override
	public Object clone()
	{
		Cubico cloned = (Cubico) super.clone();
		cloned.setAmpiezza(this.ampiezza);
		return cloned;
	}
	
	
	
	private double ampiezza;
}
