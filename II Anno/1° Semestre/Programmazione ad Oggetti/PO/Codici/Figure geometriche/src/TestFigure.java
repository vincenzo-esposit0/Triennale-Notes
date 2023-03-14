import java.util.ArrayList;

public class TestFigure {

	public static void main(String[] args)
	{
		ArrayList<FigureGeometriche> figure = new ArrayList<FigureGeometriche>();
		FigureGeometriche rett = new Rettangolo("blu", 5, 6);
		FigureGeometriche cerc = new Cerchio("verde", 5);
		FigureGeometriche tri = new Cerchio("verde", 5);
		figure.add(rett);
		figure.add(cerc);
		figure.add(tri);
		
		float sommaAree;
		System.out.print("Somma delle aree: ");
		sommaAree = rett.getArea()+cerc.getArea()+tri.getArea();
		System.out.print(sommaAree);
		System.out.println("");//new line per indentare 
		
		float sommaPerimetri;
		System.out.print("Somma dei perimetri: ");
		sommaPerimetri = rett.getPerimetro()+cerc.getPerimetro()+tri.getPerimetro();
		System.out.print(sommaPerimetri);
		System.out.println("");//new line per indentare 
		
	}
}
