import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
public class RandomInt {
	
	public static void main (String[] args) throws IOException{
		Random randomGenerator = new Random();
		double tot = 0;
		double j = 0;
		PrintWriter pw = new PrintWriter("numeri.txt");
		for (int i = 1; i<=10; i++){
		int randomInt = randomGenerator.nextInt(99);
		System.out.println("Generated " + randomInt);
		tot = randomInt + tot;
		j = i;	
		pw.println(randomInt);
		}
		
		System.out.println("Done");
		double medium = tot/j;
		System.out.println("Medium " + medium );
		pw.println(medium);
		pw.close();
	}
	
	private static double tot;
}	
