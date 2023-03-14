package main_package;

import java.util.*;

public class TestFigureGeometriche {
	public static void main(String arg[]) {
		Random gen=new Random();
		ArrayList<FigureGeometriche> figure=new ArrayList<FigureGeometriche>();
		double totarea=0;
		double totperimetro=0;
		for(int i=0;i<5;i++) {
			figure.add(new Cerchio(gen.nextDouble()*5));
			figure.add(new Rettangolo(gen.nextDouble()*5,gen.nextDouble()*5));
			figure.add(new TriangoloIsoscele(gen.nextDouble()*5,gen.nextDouble()*5));
		}
		for(int i=0;i<15;i++) {
			System.out.println(i+": "+figure.get(i).toString());
			totarea+=figure.get(i).getArea();
			totperimetro+=figure.get(i).getPerimetro();
		}
		System.out.println();
		System.out.println("Totale perimetri: "+totperimetro);
		System.out.println("Totale aree: "+totarea);
	}
}
