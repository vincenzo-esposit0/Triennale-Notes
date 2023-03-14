import java.io.Serializable;
 
public class Alunno implements Serializable {
    private String cognome;
    private String nome;
    private Voto [] voti;
    private int nv = 0;
 
    public Alunno(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
        voti = new Voto[100];
    }
    
    public void aggiungiVoto(Voto voto) {
        voti[nv] = voto;
        nv++;
    }
    
    @Override
    public String toString() {
        String s = cognome + " " + nome + ":" + "\r\n";
        for(int i=0; i<nv; i++)
            s += voti[i].toString() + "\r\n";
        return s;
    }
}