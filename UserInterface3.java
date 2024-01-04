package de.stuttgart.iwb.shopping.system;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.table.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserInterface3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	//For the purpose of transferring table data from userinterface2//
	JTable Warenkorb;
	private JTextField textFieldGesamtkosten;
	
	//For the purpose of transferring table data from userinterface2//
	public UserInterface3() {
		this(new DefaultTableModel());
	}
	
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface3 frame = new UserInterface3();
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
	//Table Model table Model in Klammern is for the purpose of transferring table data from userinterface2//
	public UserInterface3(TableModel tableModel) {
		setTitle("WarenkorbAnsicht");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Label Selected Products as Header of the page//
		JLabel lblNewLabel = new JLabel("Selected Products ");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 11, 564, 15);
		contentPane.add(lblNewLabel);
		
		
		//Proceed to payment Button at the moment without actionListener assign action Listener?//
		JButton btnProceedtopayment = new JButton("Proceed to payment");
		btnProceedtopayment.setBounds(414, 318, 190, 37);
		contentPane.add(btnProceedtopayment);
		
		//Zurück Button//
		JButton btnzurück = new JButton("zurück");
		btnzurück.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//resume userinterface2//
				UserInterface2 userinterface2 = new UserInterface2 ();
				userinterface2.setVisible(true);
			}
		});
		btnzurück.setBounds(40, 375, 89, 23);
		contentPane.add(btnzurück);
		
		
		//transferring added-Item-table (table_1) from userinterface 2//
		initComponents();
		Warenkorb.setModel(tableModel);
		Warenkorb.setBounds(107, 37, 415, 168);
		contentPane.add(Warenkorb);
		
		
		this.validate();
		this.repaint();
	}
		
		private void initComponents() {
			Warenkorb=new JTable();
			
			
			//GesamtKosten Label//
			JLabel lblGesamtkosten = new JLabel("Gesamtkosten");
			lblGesamtkosten.setHorizontalAlignment(SwingConstants.CENTER);
			lblGesamtkosten.setBounds(258, 231, 89, 30);
			contentPane.add(lblGesamtkosten);
			
			//textField that could include methods calculating Gesamtkosten?//
			textFieldGesamtkosten = new JTextField();
			textFieldGesamtkosten.setBounds(395, 230, 127, 33);
			contentPane.add(textFieldGesamtkosten);
			textFieldGesamtkosten.setColumns(10);
		}
	}
	
	
		//To-Do-List//
//1. Adding Function: Calculate Total Cost of Added Items? How?//
//2. Transferring Benutzer Name from interface 1 to 2 and 3//
		
		
		
		
		
		
		
		
	

