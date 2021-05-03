import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class AdminEditUser {

	/*
	 * GO TO Monarch App UI Main for the Listener thingy
	 * + LINES 165-180 to continue editing my Listener thingy
	 * WORK ON EDIT BUTTON
	 */
	private JFrame frame;
	private JTable table;
	private UserTableModel tableModel;
	private JTextField textFieldName;
	private JTextField textFieldID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminEditUser window = new AdminEditUser();
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
	public AdminEditUser() {
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
		 * Edit button
		 */
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Close current window
				frame.dispose();
				
				//Take user to edit user screen
				EditUserScreen.main(null);
			}
		});
		btnEdit.setBounds(276, 133, 152, 29);
		frame.getContentPane().add(btnEdit);
		
		/*
		 * Delete button
		 */
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(276, 174, 152, 29);
		frame.getContentPane().add(btnDelete);
		
		/*
		 * Back button
		 */
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminIndex.main(null);
			}
		});
		btnBack.setForeground(Color.DARK_GRAY);
		btnBack.setBounds(6, 240, 72, 26);
		frame.getContentPane().add(btnBack);
		
		/*
		 * Scroll Pane to display users
		 */
		JScrollPane scrollPane_USERS = new JScrollPane();
		scrollPane_USERS.setBounds(6, 6, 233, 222);
		frame.getContentPane().add(scrollPane_USERS);
		
		// Create table inside scroll pane
		table = new JTable();
		
		//creates the table and saves it in the variable "tableModel", so that we can refer to it in the future
		tableModel = new UserTableModel();
		
		//Loading in previous data of the table model
		tableModel.load();
		
		//Set table model onto this table
		table.setModel(tableModel);
		scrollPane_USERS.setViewportView(table);
		
		/*
		 * Save Changes button
		 */
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(276, 215, 152, 29);
		frame.getContentPane().add(btnSaveChanges);
		
		/*
		 * USER INFORMATION Title
		 */
		JLabel lblUserInformation = new JLabel("User Information:");
		lblUserInformation.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 12));
		lblUserInformation.setBounds(251, 7, 162, 16);
		frame.getContentPane().add(lblUserInformation);
		
		
		/*
		 * USER'S NAME
		 */
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblUserName.setBounds(251, 43, 86, 16);
		frame.getContentPane().add(lblUserName);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textFieldName.setColumns(10);
		textFieldName.setBounds(317, 43, 111, 16);
		frame.getContentPane().add(textFieldName);
		
		
		/*
		 * USER'S ID
		 */
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblUserId.setBounds(251, 87, 86, 16);
		frame.getContentPane().add(lblUserId);
		
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
		 * Selecting user from the table to Edit or Delete
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
					
					//Get User at the clicked position
					User user = tableModel.getUser(rowIndex);
					
					//Display selected user's name
					textFieldName.setText(user.getName());
					
					//Display selected user's number
					textFieldID.setText(String.valueOf(user.getUserID()));
				}
			}
		});
	}
}
