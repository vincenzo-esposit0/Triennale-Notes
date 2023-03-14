import java.util.Scanner;

public class TestSerratura {
	public static void main(String[] args){
		
	Serratura srr = new Serratura("",false);
	
	System.out.println("Inserisci la prima lettera ");
	Scanner in1 = new Scanner(System.in);
	String charComb = in1.nextLine();
	srr.setPosition(charComb);
	System.out.println("Inserisci la seconda lettera ");
	Scanner in2 = new Scanner(System.in);
	String charComb2 = in2.nextLine();
	srr.setPosition(charComb2);
	System.out.println("Inserisci la terza lettera ");
	Scanner in3 = new Scanner(System.in);
	String charComb3 = in3.nextLine();
	srr.setPosition(charComb3);
	System.out.println("Password impostata");
	System.out.println("Inserire password ");
	Scanner in4 = new Scanner (System.in);
	String pwInserita = in4.nextLine();
	srr.unlock(pwInserita);
	if(srr.isOpen()==true)
		{
		System.out.print("Serratura aperta");}
		else{
			System.out.print("Serratura chiusa");
		}
	
		};
}

