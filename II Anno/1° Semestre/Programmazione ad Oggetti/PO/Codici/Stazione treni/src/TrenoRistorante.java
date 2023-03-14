import java.util.ArrayList;

public class TrenoRistorante extends Treno
	{
	public TrenoRistorante(ArrayList<Fermata> fermate, int numeroPosti, int numKm,  int postiRistoro,double prezzoperKm, double incasso)
	{
		
		super(fermate,numeroPosti,numKm,prezzoperKm,incasso);
		
		this.postiRistoro=postiRistoro;
	}

	public int getPostiRistoro()
	{
		return postiRistoro;
	}
	
	public void setPostiRistoro(int postiRistoro)
	{
		this.postiRistoro=postiRistoro;
	}
	
	public double getIncassoRistoro(double incasso, double tassaRistoro)
	{
		return incasso + tassaRistoro;
	}
	
	private int postiRistoro;
	private final double tassaRistoro = 200.00;
}
