import java.util.Scanner;

public class InputCheck {

	public static void main(String[] args) {
		System.out.println("Input ");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		if (str.equals("S") || str.equals("SI") || str.equals("OK")
			|| str.equals("certo") || str.equals("perche' no?"))
			{
			System.out.println("OK");
			}
			else
			{
			if ( str.equals ("N")|| str.equals("No"))
			{
					System.out.println("Fine");
			}
			
				else 
				{
				System.out.println("Dato non corretto");
				}
			}
		input.close();
		
	}
}

