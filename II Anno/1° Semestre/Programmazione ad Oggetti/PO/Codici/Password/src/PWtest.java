import java.util.Scanner;

public class PWtest 
{
	public static void main(String[] args) 
	{
	Password pw = new Password();
	Scanner input = new Scanner(System.in);
	
	boolean valida = false;
	while (!valida){
		System.out.print("Inserire password ");
		String password = input.nextLine();
		if(pw.checkPassword(password)==true)
	{
		valida = true;
		System.out.println("Password valida");
	}
		
					}
	input.close();
	}
	
}
