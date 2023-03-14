package Main_package;

import java.util.*;
import javax.swing.*;
import Main_package.Quadrato;

public class main {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Dammi il lato del quadrato");
		Quadrato qua= new Quadrato(Float.parseFloat(input));
		System.out.println("Il lato del quadrato creato è: " + qua.getLato());
		System.out.println("Il perimetro del quadrato è: " + qua.calcPerimetro());
		System.out.println("Dammi il nuovo lato: ");
		Scanner in= new Scanner(System.in);
		qua.setLato(in.nextFloat());
		System.out.println("Il lato del quadrato creato è: " + qua.getLato());
		System.out.println("Il perimetro del quadrato è: " + qua.calcPerimetro());
		System.exit(0);
	}
}
