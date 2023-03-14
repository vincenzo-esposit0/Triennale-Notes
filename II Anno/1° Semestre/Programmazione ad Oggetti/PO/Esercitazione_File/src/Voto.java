import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
 
public class Voto implements Serializable {
    private String descrizione;
    private float voto;
    private Date data;
 
    public Voto(String descrizione, float voto, String dataShort)
            throws ParseException {
        this.descrizione = descrizione;
        this.voto = voto;
        DateFormat fdata = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        data = fdata.parse(dataShort);
    }
 
    public String getDescrizione() {
        return descrizione;
    }
 
    public float getVoto() {
        return voto;
    }
    
    @Override
    public String toString() {
        DateFormat fdata = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        String d = fdata.format(data);
        return d + " - " + descrizione + ":  " + voto;
    }
}