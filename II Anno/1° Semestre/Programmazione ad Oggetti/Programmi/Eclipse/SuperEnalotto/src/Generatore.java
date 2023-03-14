import java.util.Random;

public class Generatore {
	//Costruttore
	public Generatore() {	
		rand=new Random();
	}
	
	//Metodo che genera i numeri
	public void genera() {
		for(int i=0;i<6;i++) {
			int newn=rand.nextInt(90);
			if(i==0)
				numeri[i]=newn;
			for(int j=0;j<i;j++)
				if (newn==numeri[j])
						i--;
				else
					numeri[i]=newn;
		}
	}
	
	//Metodo toString
	public String toString() {
		return numeri[0]+" "+numeri[1]+" "+numeri[2]+" "+numeri[3]+" "+numeri[4]+" "+numeri[5];
	}
	
	//Attributi
	public int[] numeri= new int[6];
	public Random rand;
}
