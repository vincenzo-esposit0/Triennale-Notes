import java.util.ArrayList;

public class Treno {

	public Treno(ArrayList<Fermata> fermate, int numeroPosti, int numKm, double prezzoperKm, double incasso)
	{
		this.fermate = fermate;
		this.numeroPosti = numeroPosti;
		this.numKm = numKm;
		this.incasso=incasso;
		this.prezzoperKm=prezzoperKm;
	}
	
	public ArrayList<Fermata> getFermate()
	{
		return fermate;
	}
	
	public int getNumeroPosti()
	{
		return numeroPosti;
	}
	
	public int getNumKm()
	{
		return numKm;
	}
	
	public void setNumeroPosti(int numeroPosti)
	{
		this.numeroPosti=numeroPosti;
	}
	
	public void setNumKm(int numKm)
	{
		this.numKm=numKm;
	}
	
	public double calcIncasso(int numKm, double prezzoperKm)
	{
		double a = numKm*prezzoperKm;
	    incasso = a + incasso;
	    return incasso;
	}
	
	public double getPrezzoperKm()
	{
		return prezzoperKm;
	}
	
	private ArrayList<Fermata> fermate;
	private int numeroPosti;
	private int numKm;
	private double incasso;
	private double prezzoperKm;
		
}
