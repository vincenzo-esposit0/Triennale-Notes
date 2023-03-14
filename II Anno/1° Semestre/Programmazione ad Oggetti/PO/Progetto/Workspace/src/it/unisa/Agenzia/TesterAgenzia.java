package it.unisa.Agenzia;

import it.unisa.Agenzia.GUI.LoginFrame;
import it.unisa.Connection.Database;
import it.unisa.parco.GUI.GestoreFrame;
import it.unisa.parco.Gestore.Gestore;

public class TesterAgenzia {

	public static void main(String[] args) {
		Database db;
		db= new Database("progetto_parchi_lp","root","password");
		if(db.connetti()){
			LoginFrame lagenziaframe= new LoginFrame(db);
		}
		
	}

}
