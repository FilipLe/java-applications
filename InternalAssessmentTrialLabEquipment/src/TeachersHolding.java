import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JPanel;

public class TeachersHolding {

	/*
	 * Window to display the list of borrowed items of each user
	 */
	private JFrame frame;
	private JTable table;
	private UserTableModel tableModel;
	private JTextField textFieldType;
	private JTextField textFieldID;
	
	//Variables that will be accessible across different classes (will be accessed in Edit User Screen)
	/*public static String currentName;
	public static String currentID;*/

	/*
	 * We need a class for equipment so that data regarding equipment is stored
	//The user 
	private User user;
	*/
	
	//Store the position of the being edited user
	int positionOfUser;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeachersHolding window = new TeachersHolding();
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
	public TeachersHolding() {
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
		
		/*
		 * Return Items button
		 */
		JButton btnReturn = new JButton("Return Item");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//If the fields is empty, we cannot edit user
				if(textFieldType.getText().equals("") || textFieldID.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please fill in every field","Please fill in every field", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//Method to return the item
				}
			}
		});
		btnReturn.setBounds(250, 154, 178, 47);
		frame.getContentPane().add(btnReturn);
		
		/*
		 * Back button
		 */
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersIndex.main(null);
			}
		});
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setBounds(6, 240, 72, 26);
		frame.getContentPane().add(btnBack);
		
		/*
		 * Scroll Pane to display users
		 */
		JScrollPane scrollPane_USERS = new JScrollPane();
		scrollPane_USERS.setBounds(6, 57, 233, 171);
		frame.getContentPane().add(scrollPane_USERS);
		
		// Create table inside scroll pane
		table = new JTable();
		
		/*
		//creates the table and saves it in the variable "tableModel", so that we can refer to it in the future
		tableModel = new UserTableModel();
		
		//Loading in previous data of the table model
		tableModel.load();
		
		//Set table model onto this table
		table.setModel(tableModel);
		scrollPane_USERS.setViewportView(table);
		*/
		
		/*
		 * USER INFORMATION Title
		 */
		JLabel lblItemInfo = new JLabel("Item Information:");
		lblItemInfo.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 12));
		lblItemInfo.setBounds(251, 7, 162, 16);
		frame.getContentPane().add(lblItemInfo);
		
		
		/*
		 * EquipmentType
		 */
		JLabel lblType = new JLabel("Equipment Type:");
		lblType.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblType.setBounds(251, 43, 86, 16);
		frame.getContentPane().add(lblType);
		
		textFieldType = new JTextField();
		textFieldType.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textFieldType.setColumns(10);
		textFieldType.setBounds(333, 43, 95, 16);
		frame.getContentPane().add(textFieldType);
		
		
		/*
		 * Equipment ID
		 */
		JLabel lblId = new JLabel("Item ID:");
		lblId.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblId.setBounds(251, 87, 86, 16);
		frame.getContentPane().add(lblId);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textFieldID.setColumns(10);
		textFieldID.setBounds(298, 87, 130, 16);
		frame.getContentPane().add(textFieldID);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(246, 6, 187, 116);
		frame.getContentPane().add(panel);
		
		/*
		 * Heading 
		 */
		JLabel lblUserName = new JLabel(TeacherLogin.loggedInUser + "'s borrowed items list:");
		lblUserName.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblUserName.setBounds(6, 29, 228, 16);
		frame.getContentPane().add(lblUserName);
		
		
		
		/*
		 * Selecting item from the table to return
		 */
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//Finding the row index of the row pressed
				int rowIndex = table.getSelectedRow();
				
				//Ignore this value if this isn't the final value
				//So it does the event below once, instead of twice when a row is clicked
				//If the row index is greater than 0, then the selected row is valid
				//And also if this particular selection is the final selection, then we display info
				if(rowIndex >= 0 && !e.getValueIsAdjusting()) {
					
					
					/*
					 * We need to first create a table model for each teacher
					 * 
					 * Then store all of their information
					 */
					
					
					//Get User at the clicked position
					User user = tableModel.getUser(rowIndex);
					
					//Display selected user's name
					textFieldType.setText(user.getName());
					
					//Display selected user's number
					textFieldID.setText(String.valueOf(user.getUserID()));
					
					/*
					//Assigning to variables to display them in the next EDIT screen at the "OLD info" section
					currentName = user.getName();
					currentID = String.valueOf(user.getUserID());
					*/
				}
			}
		});
	}
}
