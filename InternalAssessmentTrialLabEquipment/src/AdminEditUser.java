import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminEditUser {

	private JFrame frame;
	private JTable table;
	private UserTableModel tableModel;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*
		 * Edit button
		 */
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(251, 26, 152, 29);
		frame.getContentPane().add(btnEdit);
		
		/*
		 * Delete button
		 */
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(251, 79, 152, 29);
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
		//Set table model onto this table
		table.setModel(tableModel);
		scrollPane_USERS.setViewportView(table);
		
		/*
		 * Save Changes button
		 */
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(251, 199, 152, 29);
		frame.getContentPane().add(btnSaveChanges);
	}
}
