package de.stuttgart.iwb.shopping.system;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Font;

public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
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
	public UserInterface() {
		setTitle("LoginPage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Label Username//
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Century", Font.PLAIN, 12));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(283, 91, 75, 28);
		contentPane.add(lblUsername);
		
		//textField Username//
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(250, 130, 160, 31);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		//Label Password//
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Century", Font.PLAIN, 12));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(283, 206, 75, 28);
		contentPane.add(lblPassword);
		
		//textField Password//
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(250, 248, 160, 31);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		//login Button//
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Century", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=textFieldUsername.getText();
				String psd=textFieldPassword.getText();
				//success login only with the correct username and password// 
				if(uname.equals("BenutzerA")&&psd.equals("A")
						|| uname.equals("BenutzerB")&& psd.equals("B")
						|| uname.equals("BenutzerC") && psd.equals("C"))
				{
					
					//Pop-Up Window//
	        Component frame=null;
				{JOptionPane.showMessageDialog(frame,"Welcome" + " " + uname + "!" + " "+ "you are successfully logged in");
				
				//Jump to userinterface2//
				UserInterface2 userinterface2 = new UserInterface2 ();
				userinterface2.setVisible(true);
				
			
				}}
			
				else
				{
				//failed login Pop-Up Window//
					Component frame=null;
					JOptionPane.showMessageDialog(frame,"Invalid username or password");
				}
	
		
					
				
			}});
	    btnLogin.setBounds(459, 388, 142, 36);
		contentPane.add(btnLogin);
		
		//Cancel Button//
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Century", Font.PLAIN, 12));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Clear textField//
				textFieldUsername.setText("");
				textFieldPassword.setText("");
				
			}
		});
		btnCancel.setBounds(49, 388, 142, 36);
		contentPane.add(btnCancel);
	}
}
