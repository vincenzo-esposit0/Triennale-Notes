package dvb2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Menu {
	
	public Menu()
	{
		createPanel();
		createFrame();
		DB connessione_1 = new DB();
		this.s = connessione_1.getStatement();
	}
	

	public void createFrame()
	{
		frame = new JFrame();
		frame.setSize(1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Centro Estetico");
		
		
		frame.add(mainPanel);
		frame.setVisible(true);
	}
	
	public void createPanel() 
	{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		
		JPanel p1 = new JPanel();
		area = new JTextArea(20,40);
		area.setText(operations());
		area2 = new JTextArea(20,40);
		p1.setBackground(Color.GRAY);
		
		p1.add(area);
		p1.add(area2);
		
		JPanel p2 = new JPanel();
		textInput = new JTextField(50);
		textInput.setText("Inserire il numero dell'operazione da effettuare");
		createButton();
		p2.setBackground(Color.GRAY);
		
		p2.add(textInput);
		p2.add(inputButton);
		
		
		mainPanel.add(p1, BorderLayout.NORTH );
		mainPanel.add(p2, BorderLayout.CENTER);
	}
	
	public void createButton()
	{
		inputButton = new JButton();
		inputButton.setText("Invio");
		
		class exeQuery implements ActionListener
		{
			public void actionPerformed(ActionEvent e) 
			{
				String c = "";
				op = Integer.parseInt(textInput.getText());
				try 
				{
					if(op == 1)
					{
						String data = JOptionPane.showInputDialog("Inserire Data (yyyy-mm-dd)");
						int ora = Integer.parseInt(JOptionPane.showInputDialog("Inserire Ora"));
						
						String appuntamento =  data + " " + ora;
						rs = s.executeQuery(Query.OP2);
						while(rs.next())
						{
							c = String.valueOf(rs.getDate("Data")) + " " + rs.getInt("Ora");
							
							
							if(c.compareTo(appuntamento) == 0)
							{
								setTextArea("Impossibile prenotare, � gi� previsto un appuntamento!!");
								break;
							}
							verificaAppuntamento = true;
							setTextArea("Prenotazione disponibile!");
						}
						
						if(verificaAppuntamento)
						{
							String temp = "";
							int ID = Integer.parseInt(JOptionPane.showInputDialog("Inserire codice identificativo appuntamento"));
							int durata = Integer.parseInt(JOptionPane.showInputDialog("Inserire probabile durata"));
							String tipo = JOptionPane.showInputDialog("Inserire Tipo");
							String descrizione = JOptionPane.showInputDialog("Inserire descrizione");
							String cd_estetista = JOptionPane.showInputDialog("Inserire codice fiscale estetista");
							int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("Inserire codice identificativo cliente"));
							int id_sala = Integer.parseInt(JOptionPane.showInputDialog("Inserire Orario codice identificativo sala"));
							int id_macchinario = Integer.parseInt(JOptionPane.showInputDialog("Inserire codice identificativo macchinario"));
							
							
							temp = "(" + "\"" + ID + "\"" + "," 
									+ "\"" + data + "\"" + "," 
									+ "\"" + ora + "\"" + "," 
									+ "\"" + durata + "\"" + "," 
									+ "\"" + tipo + "\""  + "," 
									+ "\"" + descrizione  + "\"" + ","
									+ "\"" + cd_estetista + "\"" + "," 
									+ "\"" + id_cliente + "\"" + "," 
									+ "\"" + id_sala + "\"" + "," 
									+ "\"" + id_macchinario + "\""+ ")" ;
						
							
							s.executeUpdate(Query.OP1 + temp);
							
							c = "Appuntamento Aggiunto!";
							setTextArea(c);
						}
						
					}
					
					if(op == 2)
					{
						String appuntamento = JOptionPane.showInputDialog("Inserire Data (yyyy-mm-dd)") + " " + JOptionPane.showInputDialog("Inserire Ora");
						
						rs = s.executeQuery(Query.OP2);
						while(rs.next())
						{
							c = String.valueOf(rs.getDate("Data")) + " " + rs.getInt("Ora");
							
							
							if(c.compareTo(appuntamento) == 0)
							{
								setTextArea("Impossibile prenotare, � gi� previsto un appuntamento!!");
								break;
							}
							verificaAppuntamento = true;
							setTextArea("Prenotazione disponibile!");
						}
						
					}
					
					if(op == 3)
					{
						String data = JOptionPane.showInputDialog("Inserire Data (yyyy-mm-dd)");
						
						rs = s.executeQuery(Query.OP3);
						while(rs.next())
						{
							if(data.compareTo(String.valueOf(rs.getDate("Data"))) == 0)
							{
								c = c + "Ora: " + rs.getInt("Ora") + " "
									+ "Estetista: " + rs.getString("Nome") + "\n";
							}
						}
						setTextArea(c + "Nei Seguenti orari non � possibile prenotare!");
					}
					
					if(op == 4)
					{
						int ora = Integer.parseInt(JOptionPane.showInputDialog("Inserire Orario"));
						
						rs = s.executeQuery(Query.OP4);
						while(rs.next())
						{
							if(ora == rs.getInt("Ora"))
							{
								c = c + "Data: " + String.valueOf(rs.getDate("Data")) + "\n";
							}
						}
						setTextArea(c + "Nei Seguenti giorni non � possibile prenotare all'orario scelto!");
					}
					
					if(op == 5)
					{
						int id_macchinario = Integer.parseInt(JOptionPane.showInputDialog("Inserire Identificativo macchinario"));
						
						rs = s.executeQuery(Query.OP5);
						while(rs.next())
						{
							if(id_macchinario == rs.getInt("ID_Macchinario"))
							{
								c = c + "Data: " + String.valueOf(rs.getDate("Data")) + " " + "Ora: " + rs.getInt("Ora") + "\n";
							}
						}
						setTextArea(c + "Il macchinario � occupato per i seguenti appuntamenti");
					}
					
					if(op == 6)
					{
						
						rs = s.executeQuery(Query.OP6);
						while(rs.next())
						{
							c = c + "Tipo: " + rs.getString("Tipo") + "\n"
								+ " Appuntamenti Effettuati: " + rs.getInt("count(ID)") + "\n";
							
						}
						setTextArea(c);
					}
					
					if(op == 7)
					{
						int ID = Integer.parseInt(JOptionPane.showInputDialog("Inserire Codice identificativo cliente"));
						String nome = JOptionPane.showInputDialog("Inserire Nome");
						String cognome = JOptionPane.showInputDialog("Inserire cognome");
						int eta = Integer.parseInt(JOptionPane.showInputDialog("Inserire Et�"));
						String sesso = JOptionPane.showInputDialog("Inserire sesso cliente");
						
						String temp = "(" + ID + "," 
								+ "\"" + nome + "\"" + "," 
								+ "\"" + cognome + "\"" + "," 
								+ eta  + "," 
								+ "\"" + sesso + "\""+ ")";
						System.out.println(Query.OP7 + temp);
						s.executeUpdate(temp);
						c = "Estetista Aggiunta!";
						setTextArea(c);
					}
					
					if(op == 8)
					{
						String codiceFiscale = JOptionPane.showInputDialog("Inserire Codice Fiscale");
						String nome = JOptionPane.showInputDialog("Inserire Nome");
						String cognome = JOptionPane.showInputDialog("Inserire cognome");
						int eta = Integer.parseInt(JOptionPane.showInputDialog("Inserire Et�"));
						int orario_inizio_turno = Integer.parseInt(JOptionPane.showInputDialog("Inserire Orario inizio turno"));
						int orario_fine_turno = Integer.parseInt(JOptionPane.showInputDialog("Inserire Orario fine turno"));
						int stipendio = Integer.parseInt(JOptionPane.showInputDialog("Inserire Stipendio"));
						String tipo_Contratto = JOptionPane.showInputDialog("Inserire tipo di contratto");
						String DataAssunzione = JOptionPane.showInputDialog("Inserire data assunzione dd/mm/yyyy");
						int OreStraordinarie = Integer.parseInt(JOptionPane.showInputDialog("Inserire OreStraordinarie"));
						int OreTotali = Integer.parseInt(JOptionPane.showInputDialog("Inserire OreTotali"));
						int GiorniDiLavoro =  Integer.parseInt(JOptionPane.showInputDialog("Inserire GiorniDiLavoro"));
						String Specializzazione = JOptionPane.showInputDialog("Inserire Specializzazione");
						int NumeroMacchinari = Integer.parseInt(JOptionPane.showInputDialog("Inserire NumeroMacchinari"));
						int Ore_di_utilizzo = Integer.parseInt(JOptionPane.showInputDialog("Inserire Ore_di_utilizzo "));
						String tipologia = JOptionPane.showInputDialog("Inserire Tipologia");
						
						String temp = "(" + "\"" + codiceFiscale + "\"" + "," 
								+ "\"" + nome + "\"" + "," 
								+ "\"" + cognome + "\"" + "," 
								+ "\"" + eta + "\"" + "," 
								+ "\"" + orario_inizio_turno + "\""  + "," 
								+ "\"" + orario_fine_turno  + "\"" + ","
								+ "\"" + stipendio + "\"" + "," 
								+ "\"" + tipo_Contratto + "\"" + "," 
								+ "\"" + DataAssunzione + "\"" + "," 
								+ "\"" + OreStraordinarie + "\""+ "," 
								+ "\"" + OreTotali + "\""+ ","
								+ "\"" + GiorniDiLavoro + "\""+ "," 
								+ "\"" + Specializzazione + "\""+ "," 
								+ "\"" + NumeroMacchinari + "\""+ "," 
								+ "\"" + Ore_di_utilizzo + "\""+ "," 
								+ "\"" + tipologia + "\""+ ")" ;
						System.out.println(temp);
						s.executeUpdate(Query.OP8 + temp);
						
						c = "Estetista Aggiunta!";
						setTextArea(c);
					}
					
					if(op == 9)
					{
						rs = s.executeQuery(Query.OP9);
						while(rs.next())
						{
							c = c + "Codice Fiscale: " + rs.getString("CodiceFiscale") + "\n"
									+ "Nome: " + rs.getString("Nome") +"\n"
									+ "Cognome: " + rs.getString("Cognome")+ "\n"
									+ "Ore di utilizzo: " + rs.getInt("max(Ore_di_Utilizzo)") + "\n";
						}
						setTextArea(c);
					}
					
					if(op == 10)
					{
						String g = JOptionPane.showInputDialog("Inserire codice fiscale");
						g.toUpperCase();

						rs = s.executeQuery(Query.OP10 + "\"" + g +"\"");
						while(rs.next())
						{
							c = c + "ID: " + rs.getInt("ID") + "\n"
									+ "Nome: " + rs.getString("Nome") + "\n"
									+ "Marca: " + rs.getString("Marca") + "\n"
									+ "Modello: " + rs.getString("Modello") + "\n"
									+ "Descrizione: " + rs.getString("Descrizione") + "\n"
									+ "Tipologia: " + rs.getString("Tipologia") + "\n"
									+ "Antinvecchiamento: " + rs.getString("Antinvecchiamento") + "\n"
									+ "Dimagrimento: " + rs.getString("Dimagrimento") + "\n"
									+ "CD_Estetista: " + rs.getString("CD_Estetista") + "\n"
									+ "ID Sala: " + rs.getInt("ID_Sala") + "\n"
									+ "Ore di utilizzo: " + rs.getInt("Ore_di_Utilizzo") + "\n";
						}
						setTextArea(c);
					}
					
					if(op == 11)
					{
						String g = JOptionPane.showInputDialog("Inserire codice fiscale");
						g.toUpperCase();

						s.executeUpdate(Query.OP11 + "\"" + g +"\"");
						c = "Aggiornamento riuscito!";
						setTextArea(c);
					}
					
					if(op == 12)
					{
						String data = "";
						int id = Integer.parseInt(JOptionPane.showInputDialog("Inserire identificativo appuntamento"));
						String support_query = "select Data From appuntamento Where ID = " + id;
						
						rs = s.executeQuery(support_query);
						System.out.println("ciao");
						
						while(rs.next()) 
						{
							data = String.valueOf(rs.getDate("Data"));
						}
							
						
						rs = s.executeQuery(Query.OP3);
						while(rs.next())
						{
							if(data.compareTo(String.valueOf(rs.getDate("Data"))) == 0)
							{
								c = c + "Ora: " + rs.getInt("Ora") + " "
									+ "Estetista: " + rs.getString("Nome") + "\n";
							}
						}
						setTextArea(c + "Nei Seguenti orari non � possibile spostare l'appuntamento!\n");
						
						int new_ora = Integer.parseInt(JOptionPane.showInputDialog("Inserire nuovo orario"));
						String query =  Query.OP12 + new_ora + " " + "WHERE ID = " + id;
						s.executeUpdate(query);
						area2.append("Orario appuntamento cambiato");
						
					}
					
					if(op == 13)
					{
						rs = s.executeQuery(Query.OP13);
						while(rs.next())
						{
							c = c + "Nome: " + rs.getString("Nome") + "\n"
									+ "Ore: " + rs.getInt("Ore") + "\n";
						}
						setTextArea(c);
					}
					
					if(op == 14)
					{
						rs = s.executeQuery(Query.OP14);
						while(rs.next())
						{
							c = c + "Nome: " + rs.getString("Nome") + "\n"
									+ "Marca: " + rs.getString("Marca") + "\n"
									+ "Modello: " + rs.getString("Modello") + "\n"
									+ "Tipologia: " + rs.getString("Tipologia") + "\n"
									+ "Ore_di_Utilizzo: " + rs.getInt("Ore_di_Utilizzo") + "\n\n";
						}
						setTextArea(c);
					}
					
					if(op == 15)
					{
						int id = Integer.parseInt(JOptionPane.showInputDialog("Inserire ID"));
						String marca = JOptionPane.showInputDialog("Inserire Marca");
						String modello = JOptionPane.showInputDialog("Inserire Modello");
						String nome = JOptionPane.showInputDialog("Inserire Nome");
						String descrizione = JOptionPane.showInputDialog("Inserire Descrizione");
						String tipologia = JOptionPane.showInputDialog("Inserire Tipologia");
						String antivecchiamento = JOptionPane.showInputDialog("Inserire Antivecchiamento");
						String dimagrimento = JOptionPane.showInputDialog("Inserire Dimagrimento");
						String cd_Estetista = JOptionPane.showInputDialog("Inserire Codice Fiscale Estetista");
						int id_Sala = Integer.parseInt(JOptionPane.showInputDialog("Inserire ID Sala"));
						
						String temp = "(" + id + "," 
								+ "\"" + marca + "\"" + "," 
								+ "\"" + modello + "\"" + "," 
								+ "\"" + nome + "\"" + "," 
								+ "\"" + descrizione + "\""  + "," 
								+ "\"" + tipologia  + "\"" + ","
								+ "\"" + antivecchiamento + "\"" + "," 
								+ "\"" + dimagrimento + "\"" + "," 
								+ "\"" + cd_Estetista + "\"" + "," 
								+ "\"" + id_Sala + "\""+ "," 
								+ "0" + ")";
						
						s.executeUpdate(Query.OP15 + temp);
						
						c = "Macchinario Aggiunto!";
						setTextArea(c);
					}
					
					
				}
				catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				
			}
		}
		
		exeQuery e = new exeQuery();
		inputButton.addActionListener(e);
	}
	
	public String operations()
	{
		return "Lista delle operazioni disponibili:\n"
				+ "1.Prenotazione di un appuntamento con assegnazione di sala ed estetista\n"
				+ "2.Verifica della possibilit� di effettuare un appuntamento per un determinato giorno dell�anno ad una determinata ora\n"
				+ "3.Visualizzazione degli orari disponibili per un appuntamento in un determinato giorno\n"
				+ "4.Visualizzazione dei giorni disponibili per un appuntamento in un determinato orario\n"
				+ "5.Visualizzazione del primo appuntamento disponibile per l�utilizzo di un determinato macchinario\n"
				+ "6.Visualizzazione del numero di appuntamenti effettuati in un anno per ogni tipo\n"
				+ "7.Inserimento di un nuovo cliente\n"
				+ "8.Assunzione di una nuova estetista\n"
				+ "9.Visualizzazione dell�estetista che ha lavorato in maggior numero di ore sui macchinari nell�anno corrente\n"
				+ "10.Visualizzazione dei macchinari che pu� utilizzare un�estetista\n"
				+ "11.Modifica del contratto di un�estetista\n"
				+ "12.Modifica dell�orario di un appuntamento (se possibile)\n"
				+ "13.Visualizzazione delle ore di occupazione delle sale in un anno\n"
				+ "14.Visualizzazione dei macchinari che sono stati utilizzati per pi� di 1000 ore in un anno\n"
				+ "15.Acquisto di un nuovo macchinario\n";
	}
	
	public void setTextArea(String s)
	{
		area2.setText(s);
	}
	
	private JFrame frame;
	private JPanel mainPanel;
	private JTextField textInput;
	private JTextArea area;
	private JTextArea area2;
	private JButton inputButton;
	private int op;
	private boolean verificaAppuntamento;
	
	private Statement s;
	private ResultSet rs;

}
