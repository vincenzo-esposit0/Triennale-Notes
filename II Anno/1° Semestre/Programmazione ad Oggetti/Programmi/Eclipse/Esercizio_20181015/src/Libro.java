public class Libro {

    /**
     * Metodi costruttori
     * @param unAutore autore del libro
     * @param unTitolo titolo del libro
     * @param unEditore Editore del libro
     */
    public Libro(String unAutore, String unTitolo, String unEditore){
        titolo = unTitolo;
        autore = unAutore;
        editore = unEditore;
        copieDisponibili = 1;
    }

    /**
     *
     * @param unAutore autore del libro
     * @param unTitolo titolo del libro
     * @param unEditore Editore del libro
     * @param nCopie numero di copie disponibili
     */

    public Libro(String unTitolo, String unAutore , String unEditore, int nCopie){
        titolo = unTitolo;
        autore = unAutore;
        editore = unEditore;
        copieDisponibili = nCopie;
    }

    public String getTitolo(){ return titolo; }
    public String getAutore(){ return autore; }
    public String getEditore(){ return editore; }
    public int getCopie(){ return copieDisponibili;  }

    public void setCopie( int nCopie){ copieDisponibili = nCopie; }

    public void getLibro(){
        System.out.println(getAutore());
        System.out.println(getTitolo());
        System.out.println(getEditore());
        System.out.println(getCopie());
    }


    private String titolo;
    private String autore;
    private String editore;

    private int copieDisponibili;
}
