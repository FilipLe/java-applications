import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminIndex {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminIndex window = new AdminIndex();
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
	public AdminIndex() {
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
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminCreateUser.main(null);
			}
		});
		btnCreateUser.setBounds(18, 26, 412, 53);
		frame.getContentPane().add(btnCreateUser);
		
		JButton btnEditUsers = new JButton("Edit User");
		btnEditUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminEditUser.main(null);
			}
		});
		btnEditUsers.setBounds(18, 100, 412, 53);
		frame.getContentPane().add(btnEditUsers);
		
		JButton btnAccessEquipmentDatabase = new JButton("Access Equipment Database");
		btnAccessEquipmentDatabase.setBounds(18, 166, 412, 53);
		frame.getContentPane().add(btnAccessEquipmentDatabase);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIMain.main(null);
			}
		});
		btnLogout.setForeground(Color.DARK_GRAY);
		btnLogout.setBounds(6, 240, 72, 26);
		frame.getContentPane().add(btnLogout);
	}

}
