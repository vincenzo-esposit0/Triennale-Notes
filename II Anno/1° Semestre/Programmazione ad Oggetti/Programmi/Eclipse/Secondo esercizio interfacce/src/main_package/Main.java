package main_package;

public class Main {
	public static void main(String arg[]) {
		DataSet dataset=new DataSet();
		TestDue uno=new TestDue("Erica");
		TestDue due=new TestDue("Brescia");
		TestDue tre=new TestDue("Amore");
		TestDue quattro=new TestDue("Trovata");
		TestDue cinque=new TestDue("Distanza");
		dataset.add(uno.getCompare());
		dataset.add(due.getCompare());
		dataset.add(tre.getCompare());
		dataset.add(quattro.getCompare());
		dataset.add(cinque.getCompare());
		System.out.println("Massimo parole: "+dataset.getMaximum());
		System.out.println("Minimo parole: "+dataset.getMinimum());
		System.out.println();
		DataSet cdataset=new DataSet();
		Country cuno=new Country("Italia",125);
		Country cdue=new Country("Spagna",15);
		Country ctre=new Country("Russia",500);
		Country cquattro=new Country("Africa",250);
		Country ccinque=new Country("Germania",200);
		cdataset.add(cuno.getCompare());
		cdataset.add(cdue.getCompare());
		cdataset.add(ctre.getCompare());
		cdataset.add(cquattro.getCompare());
		cdataset.add(ccinque.getCompare());
		System.out.println("Massimo country: "+cdataset.getMaximum());
		System.out.println("Minimo country: "+cdataset.getMinimum());
		System.out.println();
	}
}
