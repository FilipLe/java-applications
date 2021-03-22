import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminCreateUser {

	private Random random = new Random();
	private JFrame frame;
	private JTextField textField_Name;
	private JTextField textField_userID;
	private int userID;
	private JTextField textField_password;
	private UserTableModel tableModel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCreateUser window = new AdminCreateUser();
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
	public AdminCreateUser() {
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
		 * NAME
		 */
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(69, 73, 55, 16);
		frame.getContentPane().add(lblName);
		
		textField_Name = new JTextField();
		textField_Name.setText("Please enter teacher's name here");
		textField_Name.setBounds(136, 68, 254, 26);
		frame.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		textField_Name.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent e) {
				//When user clicks on the placeholder, the text shown below disappears
				if(textField_Name.getText().trim().equals("Please enter teacher's name here")) {
					textField_Name.setForeground(Color.BLACK);
					textField_Name.setText(""); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_Name.getText().trim().equals("")) {
					//If user did not type anything, when user clicks on different label, text appears in grey again
					textField_Name.setForeground(Color.LIGHT_GRAY);
					textField_Name.setText("Please enter teacher's name here"); 
				}
			}
		});
		
		/*
		 * UserID
		 */
		JLabel lblUserID = new JLabel("UserID");
		lblUserID.setBounds(69, 118, 61, 16);
		frame.getContentPane().add(lblUserID);
		
		textField_userID = new JTextField();
		textField_userID.setBounds(136, 113, 130, 26);
		frame.getContentPane().add(textField_userID);
		textField_userID.setColumns(10);
		
		textField_userID.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent e) {
				//When user clicks on the placeholder, the text shown below disappears
				if(textField_userID.getText().trim().equals("UserID")) {
					textField_userID.setForeground(Color.BLACK);
					textField_userID.setText(""); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_userID.getText().trim().equals("")) {
					//If user did not type anything, when user clicks on different label, text appears in grey again
					textField_userID.setForeground(Color.LIGHT_GRAY);
					textField_userID.setText("UserID"); 
				}
			}
		});
		
		/*
		 * Generate random UserID
		 */
		JButton btnGenerateID = new JButton("Generate");
		btnGenerateID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userID = random.nextInt(9999);
				if(userID<10) 
				{
					textField_userID.setForeground(Color.BLACK);
					textField_userID.setText("000"+userID);
				}
				else if(userID<100)
				{
					textField_userID.setForeground(Color.BLACK);
					textField_userID.setText("00"+userID);
				}
				else if(userID<1000) 
				{
					textField_userID.setForeground(Color.BLACK);
					textField_userID.setText("0"+userID);
				}
				else 
				{
					textField_userID.setForeground(Color.BLACK);
					textField_userID.setText(Integer.toString(userID));
				}
			}
		});
		btnGenerateID.setBounds(273, 113, 117, 29);
		frame.getContentPane().add(btnGenerateID);
		
		/*
		 * Password button
		 */
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(69, 165, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		/*
		 * Save button
		 */
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			/*
			 * We want to first check that all 3 fields are not empty
			 * 
			 * If they are filled, add them to UserTableModel
			 * 
			 * Check lines 195-220 in UIMain Monarchs App
			 */
			public void actionPerformed(ActionEvent e) {
				//If one of the fields is empty (that is why we use OR == ||)
				if(textField_password.getText().trim().equals("")|| 
					textField_userID.getText().trim().equals("")||
					textField_Name.getText().trim().equals("")) 
				{
					JOptionPane.showMessageDialog(null, "There is an empty field. Please fill all fields to continue.","EMPTY FIELD", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					/*
					 * Read the input in the fields
					 */
					String name = textField_Name.getText();
					int userID = Integer.parseInt(textField_userID.getText());
					String password = textField_password.getText();
					
					//Creating the new User from User class
					User newUser = new User(name,userID,password);
					
					System.out.println(newUser.getName());
					System.out.println(newUser.getUserID());
					System.out.println(newUser.getPassword());
					
					//Adding the new user to the table model (updating it)
					tableModel.addUser(newUser);
					
					//Go back to the ADMIN MAIN SCREEN after saving the new user
					AdminIndex.main(null);
				}
			}
		});
		btnSave.setBounds(146, 209, 180, 35);
		frame.getContentPane().add(btnSave);
		
		/*
		 * Password textfield
		 */
		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(136, 160, 254, 26);
		frame.getContentPane().add(textField_password);
		
		/*
		 * Back Button
		 */
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminIndex.main(null);
			}
		});
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setBounds(0, 240, 72, 26);
		frame.getContentPane().add(btnBack);
		
		/*
		 * When typing in password
		 */
		textField_password.addFocusListener(new FocusAdapter(){
			@Override
			public void focusGained(FocusEvent e) {
				//When user clicks on the placeholder, the text shown below disappears
				if(textField_password.getText().trim().equals("Please set the user a password")) {
					textField_password.setForeground(Color.BLACK);
					textField_password.setText(""); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_password.getText().trim().equals("")) {
					//If user did not type anything, when user clicks on different label, text appears in grey again
					textField_password.setForeground(Color.LIGHT_GRAY);
					textField_password.setText("Please set the user a password"); 
				}
			}
		});
	}
}
