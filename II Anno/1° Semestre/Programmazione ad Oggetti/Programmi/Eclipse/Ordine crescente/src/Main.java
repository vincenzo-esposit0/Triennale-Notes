import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Dammi i double: " );
		double a=input.nextDouble();
		double b=input.nextDouble();
		double c=input.nextDouble();
		if ((a>b)&&(a>c)) {
				System.out.println("Il maggiore è: "+a);
		}
		else if (b>c){
			System.out.println("Il maggiore è: "+b);
		}
		else {
			System.out.println("Il maggiore è: "+c);
		}		
	}
}
