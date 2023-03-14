package main_package;

import main_package.Episodio;
import java.util.*;

public class Serial {
	//Costruttore
	public Serial(String titolo,String fep,int n) {
		Scanner input=new Scanner(System.in);
		this.titolo=titolo;
		this.fep=fep;
		int i;
		for (i=0;i<n-1;i++) {
			System.out.print("Dammi il titolo "+i+": ");
			String titoloe=input.nextLine();
			System.out.print("Dammi il titolo "+i+1+": ");
			String titoloen=input.nextLine();
			episodi.add(new Episodio(titoloe,titoloen));
		}
		episodi.get(i).setNnp("");
	}
	//Metodo tostring
	public void tostring() {
		System.out.println("Titolo: "+titolo);
		System.out.println("Primo episodio: "+fep);
		int i=0;
		while (episodi.get(i).getNnp()!="") {
			System.out.println("Episodio "+i+" :"+episodi.get(i).toString());
			i++;
		}
	}
	//Meotod eguals
	public boolean eguals(Episodio x) {
		if((titolo.compareTo(x.titolo)==0));
			return true;
	}
	//Attributi
	ArrayList<Episodio> episodi=new ArrayList<Episodio>();
	private String titolo;
	private String fep;
}
