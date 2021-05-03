import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class TeachersIndex {

	private JFrame frame;

	/*
	 * READ LINES 60-71 
	 */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeachersIndex window = new TeachersIndex();
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
	public TeachersIndex() {
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
		 * CHECK TEACHER'S ACCOUNT
		 */
		JButton btnCheckAccount = new JButton("Check my holdings");
		btnCheckAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close current screen
				frame.dispose();
				
				/*
				 * DISPLAY A TABLE MODEL OF WHAT TEACHERS HAVE BORROWED, THERE WILL BE ALSO A RETURN BUTTON SO THEY CAN RETURN IT
				 * 
				 * First, when we log into teacher, we need a variable to store WHICH teacher is logged in
				 * 
				 * Then, when user presses "Check my holdings", we take them to a Window with a table model
				 * 
				 * Before the table model shows details, we need to specify which user we loading up
				 *  
				 * Everytime we start the program, it loads up the info of the user logged in
				 */
				
			}
		});
		btnCheckAccount.setBounds(18, 62, 412, 53);
		frame.getContentPane().add(btnCheckAccount);
		
		
		/*
		 * BORROW ITEMS
		 */
		JButton btnBorrow = new JButton("Borrow Items");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close current screen
				frame.dispose();
				//take to the database
				EquipmentsTeachers.main(null);
			}
		});
		btnBorrow.setBounds(18, 145, 412, 53);
		frame.getContentPane().add(btnBorrow);
		
		/*
		 * Logout option
		 */
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close current window
				frame.dispose();
				//Take user to main screen
				UIMain.main(null);
			}
		});
		btnLogout.setForeground(Color.DARK_GRAY);
		btnLogout.setBounds(6, 240, 72, 26);
		frame.getContentPane().add(btnLogout);
		
		/*
		 * Text "Select Action"
		 */
		JLabel lblSelectAction = new JLabel("Select Action:");
		lblSelectAction.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSelectAction.setBounds(18, 34, 241, 16);
		frame.getContentPane().add(lblSelectAction);
	}

}
