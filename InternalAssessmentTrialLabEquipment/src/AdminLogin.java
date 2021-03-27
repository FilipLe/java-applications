import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminLogin {
	
	/*
	 * ADMIN LOGIN SCREEN
	 */

	private JFrame frame;
	private JTextField adminID;
	private JPasswordField adminPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*
		 * AdminID
		 */
		JLabel lblAdminID = new JLabel("AdminID");
		lblAdminID.setBounds(63, 76, 72, 16);
		frame.getContentPane().add(lblAdminID);
		
		adminID = new JTextField();
		adminID.setColumns(10);
		adminID.setBounds(156, 71, 232, 26);
		frame.getContentPane().add(adminID);
		adminID.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent e) {
				//When user clicks on the placeholder, the text shown below disappears
				if(adminID.getText().trim().equals("Please enter AdminID here")) {
					adminID.setForeground(Color.BLACK);
					adminID.setText(""); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(adminID.getText().trim().equals("")) {
					//If user did not type anything, when user clicks on different label, text appears in grey again
					adminID.setForeground(Color.LIGHT_GRAY);
					adminID.setText("Please enter AdminID here"); 
				}
			}
		});
		
		
		/*
		 * Password
		 */
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(63, 137, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		adminPassword = new JPasswordField();
		adminPassword.setBounds(156, 132, 232, 26);
		frame.getContentPane().add(adminPassword);
		/*
		 * Encrypting password when input
		 * Decrypting reminder message when field is empty
		 */
		adminPassword.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent e) {
				//When user clicks on the placeholder, the text shown below disappears
				//When user writes, their input will be encrypted in the form of '•'
				if(adminPassword.getText().trim().equals("Please enter password")) {
					adminPassword.setForeground(Color.BLACK);
					adminPassword.setEchoChar ((char) '•');
					adminPassword.setText(""); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(adminPassword.getText().trim().equals("")) {
					//If user did not type anything, when user clicks on different label, text below appears in grey again
					adminPassword.setForeground(Color.LIGHT_GRAY);
					//Display the message below in text form 
					adminPassword.setEchoChar ((char) 0);
					adminPassword.setText("Please enter password"); 
				}
			}
		});
		
		/*
		 * Clear Button
		 */
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminID.setText(null);
				adminPassword.setText(null); 
			}
		});
		clearButton.setBounds(87, 191, 117, 29);
		frame.getContentPane().add(clearButton);
		
		/*
		 * Login Button
		 */
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String AdminID = adminID.getText();
				String password = adminPassword.getText();
				
				//Correct user and password
				if(AdminID.equals("0") && password.equals("onetwothree")) 
				{
					//close current window
					frame.dispose();
					JOptionPane.showMessageDialog(null, "Login Successful!","Login Successful", JOptionPane.INFORMATION_MESSAGE);
					adminID.setText(null);
					adminPassword.setText(null);
					//Take user to admin index screen
					AdminIndex.main(null);
				}
				//Incorrect user and password
				else 
				{
					JOptionPane.showMessageDialog(null, "Incorrect ID or password","Incorrect ID or password", JOptionPane.ERROR_MESSAGE);
					adminID.setText(null);
					adminPassword.setText(null);
				}
			}
		});
		btnLogin.setBounds(245, 191, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		/*
		 * If ENTER key is pressed login, instead of pressing Login Button
		 *
		 */
		adminPassword.addActionListener(new java.awt.event.ActionListener() {
		      public void actionPerformed(ActionEvent e) {
				  	String AdminID = adminID.getText();
					String password = adminPassword.getText();
							
					if(AdminID.equals("0") && password.equals("onetwothree")) 
					{
					JOptionPane.showMessageDialog(null, "Login Successful!","Login Successful", JOptionPane.INFORMATION_MESSAGE);
					adminID.setText(null);
					adminPassword.setText(null);
					AdminIndex.main(null);
					}
					else 
					{
					JOptionPane.showMessageDialog(null, "Incorrect ID or password","Incorrect ID or password", JOptionPane.ERROR_MESSAGE);
						adminID.setText(null);
						adminPassword.setText(null);
					}
		      }
		});
	    
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Close current window
				frame.dispose();
				//Take user to main screen
				UIMain.main(null);
			}
		});
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setBounds(0, 240, 72, 26);
		frame.getContentPane().add(btnBack);
	}
}
