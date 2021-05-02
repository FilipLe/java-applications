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
	 * 
	 * 
	 * PROBLEM: LINE 117 --> tableModel.getRowCount() not working
	 */

	private JFrame frame;
	private JTextField teacherID;
	private JTextField teacherName;
	private UserTableModel tableModel;

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
		 * TeacherID field
		 */
		JLabel lblTeacherID = new JLabel("Teacher ID");
		lblTeacherID.setBounds(63, 116, 72, 16);
		frame.getContentPane().add(lblTeacherID);
		
		teacherID = new JTextField();
		teacherID.setColumns(10);
		teacherID.setBounds(156, 111, 232, 26);
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
		 * Clear Button
		 */
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherName.setText(null);
				teacherID.setText(null); 
			}
		});
		clearButton.setBounds(87, 191, 117, 29);
		frame.getContentPane().add(clearButton);
		
		
		
		/*
		 * Login Button
		 */
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			//We need to load in JSON data and check if user input match with data entered
			public void actionPerformed(ActionEvent e) {
				//Getting the user inputs
				String userName = teacherName.getText();
				String idText = teacherID.getText();
				int id = Integer.parseInt(idText);
				
				System.out.println(tableModel.getRowCount());
				//For loop to iterate through every user on the list to check if entered user exists
				for(int counter = 0; counter < tableModel.getRowCount(); counter++) {
					//Get User
					User user = tableModel.getUser(counter);
					/*
					//If both info of user exists in table model
					if(user.getName() == userName && user.getUserID() == id) {
						//To stop the loop
						counter = tableModel.getRowCount(); 
								
						//Empty field entries
						teacherName.setText(null);
						teacherID.setText(null);
						
						//Message Dialog Box
						JOptionPane.showMessageDialog(null, "Login Successful!","Login Successful", JOptionPane.INFORMATION_MESSAGE);
						
						//Close current window
						frame.dispose();
						
						//Take user to database
						
					}
					
					//if they don't exist in table model
					else{
						JOptionPane.showMessageDialog(null, "Incorrect ID or password","Incorrect ID or password", JOptionPane.ERROR_MESSAGE);
						teacherName.setText(null);
						teacherID.setText(null);
					}
					*/
				}
			}
		});
		btnLogin.setBounds(245, 191, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		
		
		/*
		 * Teacher Name Field
		 */
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(63, 54, 72, 16);
		frame.getContentPane().add(lblName);
		
		teacherName = new JTextField();
		teacherName.setColumns(10);
		teacherName.setBounds(156, 49, 232, 26);
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
