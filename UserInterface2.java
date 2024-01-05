package de.stuttgart.iwb.shopping.system;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;


public class UserInterface2 extends JFrame {

	private static UserInterface userInterface;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	public JTextField textFieldBenutzer;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface2 frame = new UserInterface2(userInterface);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}}});}

	/**
	 * Create the frame.
	 */
	public UserInterface2(UserInterface userInterface) {
		this.userInterface=userInterface;
		setTitle("SelectPage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//text Field that shows the username//
		textFieldBenutzer = new JTextField();
		textFieldBenutzer.setEnabled(false);
		textFieldBenutzer.setBackground(new Color(255, 255, 255));
		textFieldBenutzer.setSelectionColor(new Color(0, 0, 0));
		textFieldBenutzer.setForeground(new Color(119, 136, 153));
		textFieldBenutzer.setFont(new Font("Century", Font.BOLD, 11));
		textFieldBenutzer.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldBenutzer.setEditable(false);
		textFieldBenutzer.setBounds(38, 11, 96, 20);
		contentPane.add(textFieldBenutzer);
		textFieldBenutzer.setColumns(10);
		
		
		//Label Products Overview//
		JLabel lblProductsOverview = new JLabel("Products Overview");
		lblProductsOverview.setFont(new Font("Century", Font.PLAIN, 12));
		lblProductsOverview.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductsOverview.setBounds(20, 39, 615, 28);
		contentPane.add(lblProductsOverview);
		
		//Table where all the Products with corresponding price per 100g are listed//		
		table = new JTable();
		table.setFont(new Font("Century", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Products", "Price pro 100g"},
				{"Apfel", "1,29"},
				{"Banane", "1,99"},
				{"Erdbeere", "2,99"},
			},
			new String[] {
				"Products", "Price pro 100g"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(176, 66, 300, 64);
		contentPane.add(table);
		
		
		//Selection of Products by Kunden//
		final JComboBox <String> Products = new JComboBox <String>();
		Products.setBounds(38, 171, 179, 28);
		contentPane.add(Products);
		Products.addItem("Select Products");
		Products.addItem("Apfel");
		Products.addItem("Banane");
		Products.addItem("Erdbeere");
		
		//Label Anzahl//
		JLabel lblAnzahl = new JLabel("Anzahl [g]");
		lblAnzahl.setBounds(38, 216, 73, 28);
		contentPane.add(lblAnzahl);
		
		
	    //Typing of desired Anzahl by Kunden//
		final JTextField textFieldAnzahl = new JTextField();
		textFieldAnzahl.setBounds(121, 220, 96, 20);
		contentPane.add(textFieldAnzahl);
		textFieldAnzahl.setColumns(10);
		
		//Label of Added Items Table//
		JLabel lblNewLabel = new JLabel("Added Items");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(337, 153, 247, 14);
		contentPane.add(lblNewLabel);
		
		//Table where all the selected Items are listed//
		table_1 = new JTable();
		final DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("Products");
		model1.addColumn("Anzahl [g]");
				
		table_1.setModel(model1);
				
		table_1.setBounds(337, 178, 241, 156);
		contentPane.add(table_1);		
		
		//Add to Warenkorb Button//		
		JButton btnAddtoWarenkorb = new JButton("Add to Warenkorb");
		btnAddtoWarenkorb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String products = (String)Products.getSelectedItem();
				String anzahl = textFieldAnzahl.getText();
	            
				//Pop-Up Window to show products added to Warenkorb//
				Component frame=null;
				{JOptionPane.showMessageDialog(frame,anzahl + "g" + " " + products + " " + "successfully added to Warenkorb");	
			    
				//Products with corresponding anzahl added to table_1//
				model1.addRow(new Object[] {products, anzahl+"g"});
			}};
		});
		btnAddtoWarenkorb.setBounds(38, 258, 140, 35);
		contentPane.add(btnAddtoWarenkorb);
		
		
		//Undo Button//
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String products = (String)Products.getSelectedItem();
				String anzahl = textFieldAnzahl.getText();
				
				//Pop-Up Window to show products removed from Warenkorb//
				Component frame=null;
				JOptionPane.showMessageDialog(frame,anzahl+ "g" +" "+ products+ " "+"removed from Warenkorb");
				textFieldAnzahl.setText("");
				
				//if row selected and undo button is clicked removing from table_1//
				int selectedRow = table_1.getSelectedRow();
				if(selectedRow!=-1) {
				model1.removeRow(selectedRow);
				
				table_1.revalidate();
				table_1.repaint();
			}}
		});
		
		btnUndo.setBounds(38, 304, 140, 34);
		contentPane.add(btnUndo);
		
		
		//Next Button, when clicked jump to userinterface3//
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(505, 391, 89, 23);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				UserInterface3 frame2=new UserInterface3(model1);
				frame2.setTextFieldText2(textFieldBenutzer.getText());
				
				frame2.setModel(model1);
				
				frame2.setVisible(true);
				
				
				frame2.revalidate();
				frame2.repaint();
							
			}});
		
		//Zurück Button//
		JButton btnzurück = new JButton("zurück");
		btnzurück.setBounds(38, 391, 89, 23);
		contentPane.add(btnzurück);
		
		btnzurück.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//resume to userinterface1//
				
				dispose();
			
				
				UserInterface userInterface = new UserInterface();
				userInterface.setVisible(true);
		      
								
				}});}
	
	public void setTextFieldText(String text) {
		textFieldBenutzer.setText(text);
	}
	}
			
		
		
