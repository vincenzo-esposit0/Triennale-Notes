import java.util.ArrayList;

public class Stazione {
	
	private ArrayList<Treno> stazione;
	
	public Stazione()
	{
		this.stazione=new ArrayList<Treno>();
	}
	
	public Treno getTreno(int i)
	{
		return stazione.get(i);
	}
	
	public void addTreno(Treno treno)
	{
		stazione.add(treno);
	}
		
	public int size()
	{
		return stazione.size();
	}
	
}
