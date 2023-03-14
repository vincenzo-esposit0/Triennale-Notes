package main_package;

public class Treno {
	
	//Costruttori
	public Treno(int inposti,double iprezzoposti,int inkm,int infermate,String[][] inorario) {
		nposti=inposti;
		prezzoposti=iprezzoposti;
		nkm=inkm;
		nfermate=infermate;
		orario=inorario;
		npostiristorante=0;
		prezzoristorante=0;
		isespresso=false;
	}
	public Treno(int inposti,double iprezzoposti,int inkm,int infermate,String[][] inorario,int inpostiristorante,double iprezzoristorante) {
		nposti=inposti;
		prezzoposti=iprezzoposti;
		nkm=inkm;
		nfermate=infermate;
		orario=inorario;
		npostiristorante=inpostiristorante;
		prezzoristorante=iprezzoristorante;
		isespresso=true;
	}
	
	//Metodi get
	public int getNfermate() { return nfermate; }
	public boolean getIsespresso() { return isespresso; }
	
	//Restituisce il ricavo totale del treno
	public double ricavoTreno() {
		return ((prezzoposti*nkm*nposti)+(prezzoristorante*nkm*npostiristorante));
	}
	
	//restituisce tutte le informazioni sul treno
	public void getTreno() {
		if (isespresso)
			System.out.println("Il treno è un treno espresso.");
		else
			System.out.println("Il treno non è un treno espresso.");
		System.out.println("Numero di posti: "+nposti);
		System.out.println("Prezzo del posto per km: "+prezzoposti);
		System.out.println("Numero di km totali: "+nkm);
		System.out.println("Prezzo totale del viaggio: "+prezzoposti*nkm);
		System.out.println("Numero posti vagone ristorante: "+npostiristorante);
		System.out.println("Prezzo posti vagone ristorante: "+prezzoristorante);
		System.out.println("Prezzo totale del viaggio nel vagone ristorante: "+prezzoristorante*nkm);
		System.out.println("Numero totale di fermate: "+nfermate);
		System.out.println("Stazione di partenza: "+orario[0][0]+" alle ore: "+orario[0][1]);
		System.out.println("Stazione di arrivo: "+orario[nfermate][0]+" alle ore: "+orario[nfermate][1]);	
	}
	
	//Attributi
	private boolean isespresso;
	private int nposti;
	private double prezzoposti;
	private int npostiristorante;
	private double prezzoristorante;
	private int nkm;
	private int nfermate;
	private String[][] orario=new String[nfermate][2];
	
}
