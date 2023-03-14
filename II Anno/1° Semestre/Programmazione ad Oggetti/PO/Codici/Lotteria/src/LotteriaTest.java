import java.util.Scanner;

public class LotteriaTest {
	
	public static void main (String[] args){
	
	Lotteria ltt = new Lotteria("A123");
	System.out.println("Inserire biglietto ");
	Scanner input = new Scanner(System.in);
	String in1 = input.nextLine();
	if(ltt.ifVincente(in1)==true)
		{
		System.out.println("Complimenti, hai vinto");
		}
	else
		{
		System.out.println("Spiacente, non hai vinto");
		}
	input.close();
	}
}