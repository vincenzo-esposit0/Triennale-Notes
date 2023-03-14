import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TestMain {
    public static void main(String[] arg)throws
            Exception{
        File in = new File("C:\\Users\\loren\\IdeaProjects\\Esercizio_20181015\\out\\production" +
                                            "\\Esercizio_20181015\\lib.txt");

        Libreria lib = new Libreria(in);
        ArrayList<Libro> libMiss = lib.warningCopie();

        lib.updateCopie("Fai bei sogni", 250);

        lib.libreria();
    }
}
