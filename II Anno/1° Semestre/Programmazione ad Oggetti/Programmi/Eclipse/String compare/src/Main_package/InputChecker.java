package Main_package;

public class InputChecker {
	//metodo
		
	public static void checkInput(String str) {
		if ((str.equals("S"))||(str.equals("SI"))||(str.equals("OK"))||(str.equals("certo")))
			System.out.println("OK");
		else if ((str.equals("N"))||(str.equals("No"))) {
			System.out.println("Fine");
		}
		else
			System.out.println("Dato non coretto");
	}
}
