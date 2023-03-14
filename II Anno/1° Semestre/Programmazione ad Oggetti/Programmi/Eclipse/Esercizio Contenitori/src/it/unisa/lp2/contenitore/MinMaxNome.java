package it.unisa.lp2.contenitore;

public class MinMaxNome extends ElencoContenitori{
	//Costruttore
	public MinMaxNome() {
		min=contenitori.get(0).nome;
		max=contenitori.get(0).nome;
		for(int i=0;i<contenitori.size();i++) {
			if(contenitori.get(i).nome.compareTo(min)<0)
				min=contenitori.get(i).nome;
			if(contenitori.get(i).nome.compareTo(min)>0)
				max=contenitori.get(i).nome;
		}
	}
	
	//Metodi get
	public String getMin() { return min;}
	public String getMax() { return max;}
	
	//Attributi
	private String min;
	private String max;
}
