package monarchs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 *
 */
public class UIMain {

	private JFrame frame;
	private MonarchTableModel tableModel;
	private JTabbedPane tabbedPane;
	private JPanel tablePanel;
	private JPanel infoPanel;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnBack;

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
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tablePanel = new JPanel();
		tabbedPane.addTab("Table", null, tablePanel, null);
		tablePanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 277, 214);
		tablePanel.add(scrollPane);
		
		table = new JTable();
		//creates the table and saves it in the variable "tableModel", so that we can refer to it in the future
		tableModel = new MonarchTableModel();
		//Set table model onto this table
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Show Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Switch to second tab
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton.setBounds(284, 170, 139, 50);
		tablePanel.add(btnNewButton);
		
		infoPanel = new JPanel();
		tabbedPane.addTab("Info", null, infoPanel, null);
		infoPanel.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Switch to first tab
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack.setBounds(284, 170, 139, 50);
		infoPanel.add(btnBack);
		
	}
}
