package wbuilder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import entity.User;
import listener.DynamicListener;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Valutazioni extends JFrame {

	private JPanel contentPane;
	private Random random = null;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Valutazioni frame = new Valutazioni();
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
	public Valutazioni() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 432);
        setPreferredSize(new Dimension(600, 400));
        setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        JPanel panelBtn = new JPanel();
        JButton btnGenerate = new JButton("Random Generation");
        panelBtn.add(btnGenerate);
        panel.add(panelBtn);
        JScrollPane contentpane = new JScrollPane(panel);
        add(contentpane);
        setVisible(true);
        
        btnGenerate.addActionListener(new DynamicListener(panel, contentpane));
	}
}
