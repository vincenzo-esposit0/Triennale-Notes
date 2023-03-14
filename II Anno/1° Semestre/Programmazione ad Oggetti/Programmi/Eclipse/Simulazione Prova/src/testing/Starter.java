package testing;

import gioco.*;
import java.util.Random;

public class Starter {
	public static void main(String arf[]) {
		Random rand=new Random();
		Cliente cl1=new Cliente("HD45JHSU78GSH",50+rand.nextInt(50));
		System.out.println("Cliente prima prima: "+cl1.toString());
		System.out.println();
		for (int i=0;i<10;i++) {
			if(!cl1.acquista(rand.nextDouble()*25, rand.nextBoolean()))
				System.out.println("Saldo insufficiente");
		}
		System.out.println();
		System.out.println("Cliente prima: "+cl1.toString());
		System.out.println();
		cl1.gioca();
		System.out.println();
		System.out.println("Cliente dopo: "+cl1.toString());
	}
}
