import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TestAerei {

	public static void main(String[] args){
		
		Deposito deposito = new Deposito();
		String[] s = {"a","b","c"};
		Aeromobile a = new Aeromobile(new GregorianCalendar(), new GregorianCalendar(), 2);
		Aeromobile b = new Aeroplano("modello", "codiceVolo", s,new GregorianCalendar(), new GregorianCalendar(), 2 );
		Aeromobile c = new Elicottero ("Roma", "IAIS",new GregorianCalendar(), new GregorianCalendar(), 2 );
		deposito.addAeromobile(a);
		deposito.addAeromobile(b);
		deposito.addAeromobile(c);
		
		JFrame frame = new JFrame();
		frame.setTitle("Deposito");
		JButton button = new JButton("Visualizza");
		frame.add(button,BorderLayout.EAST);
		JComboBox<String> cb = new JComboBox<String>();
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel();
		label1.setText("Categoria");
		panel1.add(cb);
		frame.add(cb,BorderLayout.NORTH);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextArea j = new JTextArea();
		
		for(Aeromobile aeromobile : deposito.getListaVeicoli())
		{
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy MM dd");
			GregorianCalendar cal = aeromobile.getDataRevisione();
			Calendar aa = cal.getInstance();
			aa.add(field, amount);
			String data = formatter.format(aa.getTime());
			cb.addItem(data);
		}
			
		class ClickAndShow implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Aeromobile> cercati = null;
				String a = (String) cb.getSelectedItem();
				Object o = a.getClass();
				
				for (Aeromobile aeromobile : deposito.getListaVeicoli())
				{
					if(aeromobile.getClass()==o)
					{
						cercati.add(aeromobile);
					}
				}

				for(Aeromobile aeromobile : deposito.getListaVeicoli())
				{
					String tot = aeromobile.toString();
		
				}
				
			}
		}
		
		button.addActionListener(new ClickAndShow());
		frame.add(j,BorderLayout.CENTER);
		
	}
}
