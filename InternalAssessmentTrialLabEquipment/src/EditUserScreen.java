import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class EditUserScreen {

	private JFrame frame;
	private Random random = new Random();
	private JTextField textField_NewName;
	private JTextField textField_NewID;
	private int userID;
	private JTextField textField_oldName;
	private JTextField textField_oldID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUserScreen window = new EditUserScreen();
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
	public EditUserScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Equipment Management System");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEditUserDetail = new JLabel("EDIT USER INFORMATION");
		lblEditUserDetail.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 17));
		lblEditUserDetail.setBounds(123, 20, 241, 16);
		frame.getContentPane().add(lblEditUserDetail);
		
		JLabel lblNewName = new JLabel("New Name");
		lblNewName.setBounds(74, 130, 72, 16);
		frame.getContentPane().add(lblNewName);
		
		JLabel lblNewId = new JLabel("New ID");
		lblNewId.setBounds(74, 173, 72, 16);
		frame.getContentPane().add(lblNewId);
		
		textField_NewName = new JTextField();
		textField_NewName.setColumns(10);
		textField_NewName.setBounds(158, 125, 252, 26);
		frame.getContentPane().add(textField_NewName);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setBounds(6, 240, 72, 26);
		frame.getContentPane().add(btnBack);
		
		textField_NewID = new JTextField();
		textField_NewID.setColumns(10);
		textField_NewID.setBounds(158, 168, 130, 26);
		frame.getContentPane().add(textField_NewID);
		
		
		/*
		 * Generate random ID for USER
		 */
		JButton btnGenerateID = new JButton("Generate");
		btnGenerateID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userID = random.nextInt(9999);
				if(userID<10) 
				{
					textField_NewID.setForeground(Color.BLACK);
					textField_NewID.setText("000"+userID);
				}
				else if(userID<100)
				{
					textField_NewID.setForeground(Color.BLACK);
					textField_NewID.setText("00"+userID);
				}
				else if(userID<1000) 
				{
					textField_NewID.setForeground(Color.BLACK);
					textField_NewID.setText("0"+userID);
				}
				else 
				{
					textField_NewID.setForeground(Color.BLACK);
					textField_NewID.setText(Integer.toString(userID));
				}
			}
		});
		btnGenerateID.setBounds(293, 165, 117, 29);
		frame.getContentPane().add(btnGenerateID);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(123, 206, 180, 35);
		frame.getContentPane().add(btnSave);
		
		JLabel lbl_oldName = new JLabel("Old Name");
		lbl_oldName.setBounds(74, 48, 72, 16);
		frame.getContentPane().add(lbl_oldName);
		
		JLabel lbl_oldID = new JLabel("Old ID");
		lbl_oldID.setBounds(74, 87, 72, 16);
		frame.getContentPane().add(lbl_oldID);
		
		textField_oldName = new JTextField();
		textField_oldName.setColumns(10);
		textField_oldName.setBounds(158, 43, 252, 26);
		frame.getContentPane().add(textField_oldName);
		
		textField_oldID = new JTextField();
		textField_oldID.setColumns(10);
		textField_oldID.setBounds(158, 82, 252, 26);
		frame.getContentPane().add(textField_oldID);
	}

}
