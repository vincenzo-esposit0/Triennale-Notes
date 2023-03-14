
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class Libreria {

    public Libreria(File inFile)throws
            Exception{

        Scanner in = new Scanner(inFile);
        libri = read(in);

    }


    private ArrayList<Libro> read(Scanner in) throws
            Exception{
        ArrayList<Libro> unaLibreria = new ArrayList<Libro>();
        String a, b, c, d;
        int e;


        while(in.hasNextLine()){
            a = in.nextLine();
            b = in.nextLine();
            c = in.nextLine();
            d = in.nextLine();

            unaLibreria.add(new Libro(a, b, c, Integer.parseInt(d)));
        }

        return unaLibreria;

    }

    public void libAutore(String unAutore){

        for(int i = 0; i < libri.size(); i++) {
            if (unAutore.compareTo(libri.get(i).getAutore()) == 0)
                libri.get(i).getLibro();;
        }
    }

    public void stringTitolo(String subTitolo){
        for(int i = 0; i < libri.size(); i++){
            if(libri.get(i).getTitolo().contains(subTitolo))
                libri.get(i).getLibro();;
        }
    }

    public void copieMax(){
        int max = libri.get(0).getCopie();

        for(int i = 0; i < libri.size(); i++){
            if(max < libri.get(i).getCopie())
                max = libri.get(i).getCopie();
        }

        for(int i = 0; i < libri.size(); i++){
            if(max == libri.get(i).getCopie())
                libri.get(i).getLibro();
        }
    }

    public ArrayList<Libro> warningCopie(){
        ArrayList<Libro> rifornimentoLibri = new ArrayList<Libro>();

        for(int i = 0; i < libri.size(); i++){
            if((libri.get(i).getCopie()) <= SOGLIA_COPIE)
                rifornimentoLibri.add(new Libro(libri.get(i).getTitolo(), libri.get(i).getAutore(),
                        libri.get(i).getEditore(), libri.get(i).getCopie()));

        }
        return rifornimentoLibri;
    }

    public void updateCopie(String unTitolo, int unNuovoCopie) throws
            Exception{
        File inFile;
        PrintStream inPS;

        inFile = new File("C:\\Users\\loren\\IdeaProjects\\Esercizio_20181015\\out\\production" +
                                        "\\Esercizio_20181015\\aggCopie.txt");
        inPS = new PrintStream(inFile);

        for(int i = 0; i < libri.size(); i++) {
            if (unTitolo.compareTo(libri.get(i).getTitolo()) == 0)
                libri.get(i).setCopie(unNuovoCopie);
        }

        for(int i = 0; i < libri.size(); i++) {
            inPS.println(libri.get(i).getAutore());
            inPS.println(libri.get(i).getTitolo());
            inPS.println(libri.get(i).getEditore());
            inPS.println(libri.get(i).getCopie());

        }

    }

    public void libreria(){
        for(int i = 0; i < libri.size(); i++){
            libri.get(i).getLibro();
        }

    }




    private ArrayList<Libro> libri;

    private final int SOGLIA_COPIE = 3;

}
