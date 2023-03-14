package dvb2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
	public DB()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/centroestetico?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", USER, PASSWORD);
			System.out.println("Connessione riuscita");
			this.s = con.createStatement();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public DB(String user, String password)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/officina?user="+user+"&password="+password+"useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", USER, PASSWORD);
			System.out.println("Connessione riuscita");
			this.s = con.createStatement();

		
		}
		catch(Exception e)
		{
			System.out.println(e);
		} 
		
	}
	
	public Statement getStatement() { return s; }
	
	private Connection con;
	private Statement s;
	
	private final String USER = "root";
	private final String PASSWORD = "metin2server";
}
