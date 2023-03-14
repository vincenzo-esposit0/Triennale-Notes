package main_package;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame {
	//Metodo Main
	public static void Main(String[] argv) {
		Frame frame=new Frame();
	}
	//Costruttore 
	public Frame() {
		Ambata amb=new Ambata("Giuseppe","Arienzo",1000);
		createFrame();
		createButtonGioca(amb);
		createPanel(amb);
		frame.add(panel);
	}
	
	//Metodo createFrame
	public void createFrame() {
		frame=new JFrame();
		frame.setVisible(true);
		frame.setSize(550, 350);
		frame.setTitle("Gioco dell'ambata");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Metodo createPannel
	public void createPanel(Ambata amb) {
		panel=new JPanel();
		panel.setLayout(new GridLayout(7,1));
		
		JPanel jp1=new JPanel();
		saldo=new JLabel(amb.getSaldo()+"");
		jp1.add(new JLabel(amb.getNome()+" "+amb.getCognome()));
		jp1.add(new JLabel("Saldo: "));
		jp1.add(saldo);
		
		JPanel jp2=new JPanel();
		jp2.add(new JLabel("Numer0 tra 1 e 45: "));
		jp2.add(nplay);
		
		JPanel jp3=new JPanel();
		jp3.add(new JLabel("Somma scommessa"));
		jp3.add(puntata);
		
		JPanel jp4=new JPanel();
		jp4.add(gioca);
		
		JPanel jp5=new JPanel();
		jp5.add(new JLabel("Numeri estratti"));
		
		JPanel jp6=new JPanel();
		for(int i=0;i<10;i++) {
			numeri[i]= new JTextField(2);
			jp6.add(numeri[i]);
		}
		
		JPanel jp7=new JPanel();
		esito= new JLabel("");
		jp7.add(esito);
		
		panel.add(jp1);
		panel.add(jp2);
		panel.add(jp3);
		panel.add(jp4);
		panel.add(jp5);
		panel.add(jp6);
		panel.add(jp7);
	}
	
	//Metodo createButtonGioca
	public void createButtonGioca(Ambata amb) {
		gioca=new JButton("Gioca");
		class ActionGioca implements ActionListener {
			public void actionPerformed(ActionEvent x) {
				amb.setNplay(Integer.parseInt(nplay.getText()));
				amb.setPutanta(Double.parseDouble(puntata.getText()));
				if (amb.gioca()) {
					esito.setText("Hai vinto !!");
					amb.setSaldo(amb.calcolaVincitą()+amb.getSaldo());
					saldo.setText(" "+amb.getSaldo());
				}else {
					esito.setText("#maiunagioia !!");
					amb.setSaldo(amb.getSaldo()-amb.getPuntata());
					saldo.setText(" "+amb.getSaldo());
				}	
				for(int i=0;i<10;i++) {
					numeri[i].setText(amb.getNumero(i));
				}
			}
		}
		ActionListener listener=new ActionGioca();
		gioca.addActionListener(listener);
	}
	
	//Attributi
	private JFrame frame;
	private JButton gioca;
	private JTextField nplay=new JTextField(2);
	private JTextField puntata=new JTextField(5);
	private JTextField[] numeri=new JTextField[10];
	private JPanel panel;
	private JLabel esito;
	private JLabel saldo;
}
