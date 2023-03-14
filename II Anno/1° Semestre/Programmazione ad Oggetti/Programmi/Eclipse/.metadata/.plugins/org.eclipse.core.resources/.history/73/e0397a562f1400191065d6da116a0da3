package database;

public class Query {

	protected static String OP1 = "insert into appuntamento (ID, Data, Ora, Durata, Tipo, Descrizione, CD_Estetista, ID_Cliente, ID_Sala, ID_Macchinario ) values ";
	
	protected static String OP2 = "select appuntamento.Data,appuntamento.ora\r\n" + 
									"from appuntamento";
	protected static String OP3 = "select Data, Ora, Nome\r\n" + 
									"from (appuntamento RIGHT OUTER join estetista on CD_Estetista = CodiceFiscale)";
	
	protected static String OP4 = "select Ora, Data\r\n" + 
										"from appuntamento";
	
	protected static String OP5 = "SELECT ID_Macchinario, Data, Ora FROM centroestetico.appuntamento order by ID_Macchinario";
	
	protected static String OP6 = "select Tipo, count(ID)\r\n" + 
									"from Appuntamento\r\n" + 
									"group by Tipo";
	
	protected static String OP7 = "insert into centroestetico.cliente (ID, Nome, Cognome, Età, Sesso) values ";
	
	protected static String OP8 = "insert into centroestetico.estetista (CodiceFiscale,Nome,Cognome,Età,Orario_inizio_turno,Orario_fine_turno,Stipendio,"
									+ "Tipo_Contratto,DataAssunzione,OreStraordinarie,OreTotali,GiorniDiLavoro,Specializzazione,NumeroMacchinari,Ore_di_utilizzo,Tipologia)\r\n"
									+"values ";
	
	protected static String OP9 = "select CodiceFiscale,nome,cognome,max(Ore_di_Utilizzo)\r\n" + 
									"from estetista";
	
	protected static String OP10 = "select *\r\n" + 
									"from macchinario\r\n" + 
									"where CD_estetista like ";
	
	protected static String OP11 = "UPDATE estetista\r\n" + 
									"SET tipo_contratto = 'Indeterminato' \r\n" + 
									"WHERE CodiceFiscale like ";
	
	protected static String OP12 = "UPDATE appuntamento \r\n" + 
										"SET Ora = ";
	
	protected static String OP13 = "SELECT Nome,sum(durata)as Ore\r\n" + 
									"FROM (centroestetico.Sala RIGHT OUTER join centroestetico.appuntamento on sala.ID=appuntamento.ID_Sala)\r\n" + 
									"group by ID_Sala\r\n" + 
									"order by nome;";
	
	protected static String OP14 = "select macchinario.nome,macchinario.Marca,macchinario.modello,macchinario.Tipologia,macchinario.Ore_di_Utilizzo "
									+ "from macchinario "
									+ "where macchinario.Ore_di_Utilizzo >= \"1000\"";
	
	protected static String OP15 = "insert into centroestetico.macchinario (ID,Nome,Marca,Modello,Descrizione,Tipologia,Antinvecchiamento,Dimagrimento,CD_Estetista,ID_Sala,Ore_di_Utilizzo)\r\n" + 
									"values ";
}
