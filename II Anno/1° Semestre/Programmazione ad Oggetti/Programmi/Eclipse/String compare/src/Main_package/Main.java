package Main_package;

import Main_package.InputChecker;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Dammi la stringa: ");
		String str=input.nextLine();
		InputChecker.checkInput(str);
	}

}
