package contenitori;
import java.util.ArrayList;

public class ElencoContenitori {
	
	public ElencoContenitori()
	{
		this.contenitori = new ArrayList<Contenitore>();
	}
	
	public void add(Contenitore x)
	{
		this.contenitori.add(x);
	}
	
	public ArrayList<Contenitore> getListOfContenitori()
	{
		return this.contenitori;
	}
	
	
	
	ArrayList<Contenitore> contenitori;
}
