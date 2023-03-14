package wbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import listener.RandomUser;
import listener.Registra;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class SecondFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondFrame frame = new SecondFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnMm = new JButton("Registra");
		btnMm.setBounds(20, 244, 131, 21);
		panel.add(btnMm);
		
		textField = new JTextField();
		textField.setBounds(20, 34, 131, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsename = new JLabel("Usename");
		lblUsename.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUsename.setBounds(20, 20, 78, 13);
		panel.add(lblUsename);
		
		JLabel lblCitta = new JLabel("Password");
		lblCitta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCitta.setBounds(20, 73, 69, 13);
		panel.add(lblCitta);

		 textField_1 = new JTextField();
		textField_1.setBounds(20, 86, 131, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEta = new JLabel("Email");
		lblEta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEta.setBounds(20, 127, 46, 13);
		panel.add(lblEta);
		
		textField_2 = new JTextField();
		textField_2.setBounds(20, 142, 131, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Random Users");
		btnNewButton.setBounds(20, 213, 131, 21);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		contentPane.add(scrollPane_2);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_2.setViewportView(textArea_2);
				
		JLabel lblNumeroUtenti = new JLabel("Numero Utenti:");
		lblNumeroUtenti.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNumeroUtenti.setBounds(20, 171, 92, 13);
		panel.add(lblNumeroUtenti);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setBounds(20, 184, 69, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton.addActionListener(new RandomUser(textArea, textArea_1, textArea_2, 
				textField_3));
		btnMm.addActionListener(new Registra(textField, textField_1, textField_2, textArea, textArea_1, textArea_2, textField_3));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
