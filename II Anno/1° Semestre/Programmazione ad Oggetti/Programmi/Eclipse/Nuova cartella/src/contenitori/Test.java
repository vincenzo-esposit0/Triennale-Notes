package contenitori;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ElencoContenitori all = new ElencoContenitori();
		//ArrayList<Contenitore> contenitori = new ArrayList<Contenitore>();
		DataSet ds = new DataSet();
		
		
		
		for(int i = 0; i < 5; i++) {
			System.out.println("Nome: ");
			String nome = in.nextLine();
			
			System.out.println("Codice: ");
			String codice = in.nextLine();
			
			System.out.println("Prezzo: ");
			double prezzo = Double.parseDouble(in.nextLine());
			
			System.out.println("Capienza: ");
			double capienza = Double.parseDouble(in.nextLine());
			all.add(new Contenitore(nome, codice, prezzo, capienza));
		}
		
		for(Contenitore e : all.getListOfContenitori()) {
			ds.add(e);
		}

		Comparable c1 = ds.getMaximum();
		Comparable c2 = ds.getMinimum();
		
		Contenitore max = (Contenitore) c1;
		Contenitore min = (Contenitore) c2;
		
		System.out.println(max.toString());
		System.out.println(min.toString());
		
		
		
	}

}
