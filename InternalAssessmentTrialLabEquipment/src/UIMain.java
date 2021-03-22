import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/*
 * Watch this Video from 14:00 onwards: https://www.youtube.com/watch?v=-hpX9oEvoXc
 */
public class UIMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIMain window = new UIMain();
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
	public UIMain() {
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
		
		JButton adminLoginButton = new JButton("Admin");
		adminLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(null);
			}
		});
		adminLoginButton.setBounds(110, 51, 229, 75);
		frame.getContentPane().add(adminLoginButton);
		
		JButton teacherLoginButton = new JButton("Teacher");
		teacherLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherLogin.main(null);
			}
		});
		teacherLoginButton.setBounds(110, 148, 229, 75);
		frame.getContentPane().add(teacherLoginButton);
		
	}
}
