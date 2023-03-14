import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TestMensa {
	public static void main(String[] args){
	ServizioMensa sm = new ServizioMensa();
	
	sm.addTesserino(new TesserinoStudente("123", new GregorianCalendar(), 10.00, 1, true, "123", "Davide", "Senatore", true));
	sm.addTesserino(new TesserinoStudente("456", new GregorianCalendar(), 10.00, 1, true, "456", "Mauro", "Vitale", true));
	sm.addTesserino(new TesserinoStudente("789", new GregorianCalendar(), 10.00, 1, true, "789", "Paolo", "Vigorito", true));
	sm.addTesserino(new TesserinoStudente("101", new GregorianCalendar(), 10.00, 1, true, "101", "Loris", "Proto", true));
	sm.addTesserino(new TesserinoStudente("111", new GregorianCalendar(), 10.00, 1, true, "111", "Giulia", "Cirillo", true));
	
	sm.addTesserino(new TesserinoPersonale("Lettere", 10.00, true, "AAA", "Ugo", "Vaccaro", true));
	sm.addTesserino(new TesserinoPersonale("Lingue", 10.00, true, "BBB", "Bruno", "Carpentieri", true));
	sm.addTesserino(new TesserinoPersonale("Medicina", 10.00, true, "CCC", "Giuseppe", "Polese", true));
	sm.addTesserino(new TesserinoPersonale("Informatica", 10.00, true, "DDD", "Ernesto", "Bisogno", true));
	sm.addTesserino(new TesserinoPersonale("Ingegneria", 10.00, true, "EEE", "Margherita", "Napoli", true));
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField text = new JTextField();
	JTextField text2 = new JTextField();
	
	
	text.setText("Cassa : " + sm.calcolaTotale());
	
	text2.setEditable(false);
	text.setEditable(false);
	text.setVisible(true);
	text2.setVisible(true);
	
	JButton bpaga = new JButton("Paga");
	JOptionPane pane= new JOptionPane(); // Selezione tesserino nulla

	
	//////////////////////////////////////////////////////////
	JComboBox<String> combobox = new JComboBox<String>();
	for (Tesserino tesserino : sm.getLista())
	{
		combobox.addItem(tesserino.getCodice());			
	}
	//////////////////////////////////////////////////////////
	class ClickSelCombo implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			for(Tesserino tesserino : sm.getLista())
			{
				if(tesserino.getCodice()==combobox.getSelectedItem()){
					text2.setText(tesserino.getNome() + "\n"+ tesserino.getCognome() +"\n\nStato: "+
				tesserino.getAttivo());
					bpaga.setVisible(true);
		
				}
				
			}	
		}
	};
	///////////////////////////////////////////////////////////

	combobox.addActionListener(new ClickSelCombo());
	
	///////////////////////////////////////////////////////////
	
	Integer[] numero ={1,2,3};
	JComboBox combobox1 = new JComboBox(numero);
	
	class ClickNumPasti implements ActionListener
	{		
		public void actionPerformed(ActionEvent e)
		  {
		   bpaga.setVisible(true);
		  }
	}
	combobox1.addActionListener(new ClickNumPasti());
		
	///////////////////////////////////////////////////////////
			
	class Pagamento implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
			{
			int n = (int)combobox1.getSelectedItem();
			String ts = (String) combobox.getSelectedItem();
			for (int j=0; j<=n;j++)
			{
				sm.usaTesserino(ts);
			}
	
			text.setText("Cassa : " + sm.calcolaTotale());
			
			JOptionPane p= new JOptionPane();
			p.showMessageDialog(null,"Pagamento effettuato");
			}
		}
	
	bpaga.addActionListener(new Pagamento());
	
	
	
	
	frame.add(bpaga,BorderLayout.EAST);
	frame.add(text2, BorderLayout.NORTH);
	frame.add(text, BorderLayout.SOUTH);
	frame.setTitle("Gestione mensa");
	frame.setSize(500,500);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.add(combobox1);
	JLabel label = new JLabel();
	label.setText("Codice tessera");
	panel.add(label);
	frame.add(panel, BorderLayout.CENTER);
	JPanel panel2 = new JPanel();
	JLabel label2 = new JLabel();
	label.setText("Numero pasti");
	panel2.add(combobox);
	panel2.add(label2);
	frame.add(panel2, BorderLayout.WEST);
	combobox.setBackground(Color.GREEN);
	frame.setBackground(Color.GRAY);
	combobox1.setBackground(Color.GREEN);
	
	}
	
	///////////////////////////////////////////////////////////	
	
	
}


	