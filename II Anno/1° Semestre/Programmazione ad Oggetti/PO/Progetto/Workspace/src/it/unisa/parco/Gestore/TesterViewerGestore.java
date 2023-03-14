package it.unisa.parco.Gestore;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import it.unisa.Connection.Database;
import it.unisa.parco.GUI.GestoreFrame;
import it.unisa.parco.GUI.IndexFrame;

public class TesterViewerGestore {
	
	
	public static void main(String[] args) throws SQLException{
		
		Database db;
		db= new Database("progetto_parchi_lp","root","password");
		if(db.connetti()){
			
			IndexFrame indexf=new IndexFrame(db);
		}

		
	}

}