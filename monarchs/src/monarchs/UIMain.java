package monarchs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
/*
 *
 */
public class UIMain {

	private JFrame frame;
	private MonarchTableModel tableModel;
	private JTabbedPane tabbedPane;
	private JPanel tablePanel;
	private JPanel addPanel;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnBack;
	private JTextField nameTextField;
	private JTextField urlTextField;

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
		
		/*
		 * Table related stuff
		 */
		
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
		
		/*
		 * Portrait label
		 */
		
		JLabel portraitLabel = new JLabel("New label");
		portraitLabel.setBounds(286, 7, 137, 159);
		tablePanel.add(portraitLabel);
		
		
		//Displaying portrait of the monarch in the clicked row
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {	
				//Finding the row index of the row pressed
				int rowIndex = table.getSelectedRow();
				
				//Ignore this value if this isn't the final value
				//So it does the event below once, instead of twice when a row is clicked
				//If the row index is greater than 0, then the selected row is valid
				//And also if this particular selection is the final selection, then we print out the monarch
				if(rowIndex >= 0 && !e.getValueIsAdjusting()) {
					//displaying portrait of the monarch clicked
					Monarch monarch = tableModel.getMonarch(rowIndex);
					
					//using dimensions of label to work out how big the portraits need to be
					int width = portraitLabel.getWidth();
					int height = portraitLabel.getHeight();
					
					//getting the images
					BufferedImage image = monarch.getImage(width,height);
					portraitLabel.setIcon(new ImageIcon(image));		
				}
			}
		});
		
		
		/*
		 * Info panel
		 */
		addPanel = new JPanel();
		tabbedPane.addTab("Info", null, addPanel, null);
		addPanel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(6, 6, 115, 30);
		addPanel.add(lblNewLabel);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(6, 43, 115, 30);
		addPanel.add(lblGender);
		
		JLabel lblStartYear = new JLabel("Start Year");
		lblStartYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartYear.setBounds(6, 73, 115, 30);
		addPanel.add(lblStartYear);
		
		JLabel lblEndYear = new JLabel("End Year");
		lblEndYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndYear.setBounds(6, 104, 115, 30);
		addPanel.add(lblEndYear);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(133, 8, 290, 26);
		addPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		JComboBox genderComboBox = new JComboBox();
		genderComboBox.setModel(new DefaultComboBoxModel(Gender.values()));
		genderComboBox.setBounds(133, 46, 139, 27);
		addPanel.add(genderComboBox);
		
		JSpinner startYearSpinner = new JSpinner();
		startYearSpinner.setModel(new SpinnerNumberModel(1900, 1000, 2100, 1));
		startYearSpinner.setBounds(133, 75, 97, 26);
		addPanel.add(startYearSpinner);
		
		JSpinner endYearSpinner = new JSpinner();
		endYearSpinner.setModel(new SpinnerNumberModel(1900, 1000, 2100, 1));
		endYearSpinner.setBounds(133, 106, 97, 26);
		addPanel.add(endYearSpinner);
		
		JLabel lblImage = new JLabel("Image URL");
		lblImage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImage.setBounds(6, 129, 115, 30);
		addPanel.add(lblImage);
		
		urlTextField = new JTextField();
		urlTextField.setColumns(10);
		urlTextField.setBounds(133, 131, 290, 26);
		addPanel.add(urlTextField);
		
		//When the "Submit" button is clicked
		btnBack = new JButton("Submit");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get the information in the field and store it
				String name = nameTextField.getText();
				Gender gender = (Gender) genderComboBox.getSelectedItem();
				int startYear = (int) startYearSpinner.getValue();
				int endYear = (int) endYearSpinner.getValue();
				String imageUrl = urlTextField.getText();
				//Create new monarch with the given information
				Monarch newMonarch = new Monarch(name, gender, startYear, endYear, imageUrl);
				//Adding new monarch to the table (updating it)
				tableModel.addMonarch(newMonarch);
				//Switch to first tab
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack.setBounds(284, 169, 139, 38);
		addPanel.add(btnBack);	
	}
}
