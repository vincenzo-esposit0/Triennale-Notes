package main_package;

import money.ContoCorrente;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<ContoCorrente> conti=new ArrayList<ContoCorrente>();
		conti.add(new ContoCorrente(25));
		conti.add(new ContoCorrente());
		System.out.println("Conti:	"+conti.get(0).getSaldo()+" "+conti.get(1).getSaldo());
		System.out.println("Conti:	"+conti.get(0).getNumeroConto()+" "+conti.get(1).getNumeroConto());
		conti.get(1).deposita(25);
		conti.get(0).preleva(10);
		System.out.println("Conti:	"+conti.get(0).getSaldo()+" "+conti.get(1).getSaldo());
		System.out.println("Conti:	"+conti.get(0).getNumeroConto()+" "+conti.get(1).getNumeroConto());
	}

}
