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

public class TeacherLogin {
	
	/*
	 * Teacher LOGIN SCREEN
	 */

	private JFrame frame;
	private JTextField teacherID;
	private JPasswordField teacherPassword;
	private JTextField teacherName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherLogin window = new TeacherLogin();
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
	public TeacherLogin() {
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
		 * TeacherID
		 */
		JLabel lblTeacherID = new JLabel("Teacher ID");
		lblTeacherID.setBounds(63, 76, 72, 16);
		frame.getContentPane().add(lblTeacherID);
		
		teacherID = new JTextField();
		teacherID.setColumns(10);
		teacherID.setBounds(156, 71, 232, 26);
		frame.getContentPane().add(teacherID);
		
		teacherID.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent e) {
				//When user clicks on the placeholder, the text shown below disappears
				if(teacherID.getText().trim().equals("Please enter teacherID here")) {
					teacherID.setForeground(Color.BLACK);
					teacherID.setText(""); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(teacherID.getText().trim().equals("")) {
					//If user did not type anything, when user clicks on different label, text appears in grey again
					teacherID.setForeground(Color.LIGHT_GRAY);
					teacherID.setText("Please enter teacherID here"); 
				}
			}
		});
		
		/*
		 * Password 
		 */
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(63, 137, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		teacherPassword = new JPasswordField();
		teacherPassword.setBounds(156, 132, 232, 26);
		frame.getContentPane().add(teacherPassword);
		
		/*
		 * Encrypting password when input
		 * Decrypting reminder message when field is empty
		 */
		teacherPassword.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent e) {
				//When user clicks on the placeholder, the text shown below disappears
				//When user writes, their input will be encrypted in the form of '•'
				if(teacherPassword.getText().trim().equals("Please enter password")) {
					teacherPassword.setForeground(Color.BLACK);
					teacherPassword.setEchoChar ((char) '•');
					teacherPassword.setText(""); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(teacherPassword.getText().trim().equals("")) {
					//If user did not type anything, when user clicks on different label, text below appears in grey again
					teacherPassword.setForeground(Color.LIGHT_GRAY);
					//Display the message below in text form 
					teacherPassword.setEchoChar ((char) 0);
					teacherPassword.setText("Please enter password"); 
				}
			}
		});
		
		/*
		 * Clear Button
		 */
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherName.setText(null);
				teacherID.setText(null);
				teacherPassword.setText(null); 
			}
		});
		clearButton.setBounds(87, 191, 117, 29);
		frame.getContentPane().add(clearButton);
		
		/*
		 * Login Button
		 */
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(245, 191, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		/*
		 * Teacher Name
		 */
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(63, 28, 72, 16);
		frame.getContentPane().add(lblName);
		
		teacherName = new JTextField();
		teacherName.setColumns(10);
		teacherName.setBounds(156, 23, 232, 26);
		frame.getContentPane().add(teacherName);
		
		teacherName.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent e) {
				//When user clicks on the placeholder, the text shown below disappears
				if(teacherName.getText().trim().equals("Please enter your name here")) {
					teacherName.setForeground(Color.BLACK);
					teacherName.setText(""); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(teacherName.getText().trim().equals("")) {
					//If user did not type anything, when user clicks on different label, text appears in grey again
					teacherName.setForeground(Color.LIGHT_GRAY);
					teacherName.setText("Please enter your name here"); 
				}
			}
		});
		
		/*
		 * Back Button
		 */
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close current window
				frame.dispose();
				//take user to main screen
				UIMain.main(null);
			}
		});
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setBounds(0, 240, 72, 26);
		frame.getContentPane().add(btnBack);
	}
}