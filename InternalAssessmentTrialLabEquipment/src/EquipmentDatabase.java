import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class EquipmentDatabase {

	/*
	 * CHECK ONENOTE JAVA TRIAL BLUE ARROWS TO SEE THE DESIGN I AM GOING FOR
	 * 
	 * Now work on right half
	 */
	
	
	/*
	 * CREATED BASIC TREE
	 */
	
	private JFrame frame;
	private JTextField txtHolderName;
	private JTextField textHolderID;
	private JTextField textBorrowStatus;
	private JTextField textBorrowDate;
	private JTextField textDeadline;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentDatabase window = new EquipmentDatabase();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Tree Listener — Doing something when user clicks
	 */
	private TreeSelectionListener createSelectionListener() {
        return new TreeSelectionListener() {
        	//When user clicks on different node
            public void valueChanged(TreeSelectionEvent e) {
            	
            	/*
            	 * Finding path of clicked node
            	 */
                TreePath path = e.getPath();
                int pathCount = path.getPathCount();
      
                //Printing the whole path of the node clicked       
                for (int i = 0; i < pathCount; i++) {
                    System.out.print(path.getPathComponent(i).toString());
                    if (i + 1 != pathCount) {
                        System.out.print("-->");
                    }
                }
                System.out.println("");
                
                //Print the current path
                System.out.print(path.getPathComponent(pathCount-1).toString()+"\n\n");
            }
        };
    }
	
	/**
	 * Create the application.
	 */
	public EquipmentDatabase() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 6, 223, 248);
		frame.getContentPane().add(scrollPane);
		
		/*
		 * Parent node
		 */
		DefaultMutableTreeNode equipmentTree=new DefaultMutableTreeNode("Equipment");  
		
		/*
	     *--------------------------------------------------------------------------------------------- 
	     */
		
		/*
		 * Child 1 
		 */
	    DefaultMutableTreeNode testTubes=new DefaultMutableTreeNode("Test Tubes");  
	    DefaultMutableTreeNode beakers=new DefaultMutableTreeNode("Beakers");  
	    DefaultMutableTreeNode funnels=new DefaultMutableTreeNode("Funnels");  
	    DefaultMutableTreeNode cylinder=new DefaultMutableTreeNode("Graduated Cylinders");  
	    DefaultMutableTreeNode thermometer=new DefaultMutableTreeNode("Thermometers");  
	    //Adding child nodes to below parent
	    equipmentTree.add(testTubes);  
	    equipmentTree.add(beakers);  
	    equipmentTree.add(funnels);  
	    equipmentTree.add(cylinder);  
	    equipmentTree.add(thermometer);  
	    
	    /*
	     *--------------------------------------------------------------------------------------------- 
	     */
	    
	    /*
	     * Child nodes 2
	     */
	    
	    /*
	     * Test Tubes
	     */
	    DefaultMutableTreeNode testTube1000=new DefaultMutableTreeNode("1000");  
	    DefaultMutableTreeNode testTube1001=new DefaultMutableTreeNode("1001");  
	    DefaultMutableTreeNode testTube1002=new DefaultMutableTreeNode("1002");  
	    DefaultMutableTreeNode testTube1003=new DefaultMutableTreeNode("1003");  
	    testTubes.add(testTube1000); testTubes.add(testTube1001); testTubes.add(testTube1002); testTubes.add(testTube1003);      
	    
	    /*
	     * Beakers
	     */
	    DefaultMutableTreeNode beaker2090=new DefaultMutableTreeNode("2090");  
	    DefaultMutableTreeNode beaker2091=new DefaultMutableTreeNode("2091");  
	    DefaultMutableTreeNode beaker2092=new DefaultMutableTreeNode("2092");  
	    DefaultMutableTreeNode beaker2093=new DefaultMutableTreeNode("2093"); 
	    beakers.add(beaker2090);beakers.add(beaker2091);beakers.add(beaker2092);beakers.add(beaker2093);
	    
	    /*
	     * Funnels
	     */
	    DefaultMutableTreeNode funnel3040=new DefaultMutableTreeNode("3040");  
	    DefaultMutableTreeNode funnel3041=new DefaultMutableTreeNode("3041");  
	    DefaultMutableTreeNode funnel3042=new DefaultMutableTreeNode("3042");  
	    DefaultMutableTreeNode funnel3043=new DefaultMutableTreeNode("3043"); 
	    funnels.add(funnel3040);funnels.add(funnel3041);funnels.add(funnel3042);funnels.add(funnel3043);
	    
	    /*
	     * Graduated Cylinders
	     */
	    DefaultMutableTreeNode cylinder4080=new DefaultMutableTreeNode("4080");
	    DefaultMutableTreeNode cylinder4081=new DefaultMutableTreeNode("4081");
	    DefaultMutableTreeNode cylinder4082=new DefaultMutableTreeNode("4082");
	    DefaultMutableTreeNode cylinder4083=new DefaultMutableTreeNode("4083");
	    cylinder.add(cylinder4080);cylinder.add(cylinder4081);cylinder.add(cylinder4082);cylinder.add(cylinder4083);
	    
	    /*
	     * Thermometers
	     */
	    DefaultMutableTreeNode therm5100=new DefaultMutableTreeNode("5100");
	    DefaultMutableTreeNode therm5101=new DefaultMutableTreeNode("5101");
	    DefaultMutableTreeNode therm5102=new DefaultMutableTreeNode("5102");
	    DefaultMutableTreeNode therm5103=new DefaultMutableTreeNode("5103");
	    DefaultMutableTreeNode therm5104=new DefaultMutableTreeNode("5104");
	    thermometer.add(therm5100);thermometer.add(therm5101);thermometer.add(therm5102);thermometer.add(therm5103);thermometer.add(therm5104);
	    
	    /*
	     *--------------------------------------------------------------------------------------------- 
	     */
	    
	    JTree tree = new JTree(equipmentTree);
		scrollPane.setViewportView(tree);
		
		//Using listener
		tree.addTreeSelectionListener(createSelectionListener());
		
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close current window
				frame.dispose();
				//Take user back to Index Screen
				AdminIndex.main(null);
			}
		});
		btnHome.setBounds(294, 172, 117, 29);
		frame.getContentPane().add(btnHome);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close current window
				frame.dispose();
				//Take user to Login Screen
				UIMain.main(null);
			}
		});
		btnLogOut.setBounds(294, 213, 117, 29);
		frame.getContentPane().add(btnLogOut);
		
		/*
	     *--------------------------------------------------------------------------------------------- 
	     */
		
		/*
		 * Displaying info of the chosen item
		 */
		
		JLabel labelHolderName = new JLabel("Holder Name:");
		labelHolderName.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		labelHolderName.setBounds(269, 11, 86, 16);
		frame.getContentPane().add(labelHolderName);
		
		JLabel labelHolderID = new JLabel("Holder ID:");
		labelHolderID.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		labelHolderID.setBounds(269, 38, 86, 16);
		frame.getContentPane().add(labelHolderID);
		
		JLabel labelStatus = new JLabel("Item Status:");
		labelStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		labelStatus.setBounds(269, 66, 86, 16);
		frame.getContentPane().add(labelStatus);
		
		JLabel lblDateBorrowed = new JLabel("Date Borrowed:");
		lblDateBorrowed.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblDateBorrowed.setBounds(269, 94, 86, 16);
		frame.getContentPane().add(lblDateBorrowed);
		
		JLabel lblDateToReturn = new JLabel("To Return Date:");
		lblDateToReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblDateToReturn.setBounds(269, 122, 86, 16);
		frame.getContentPane().add(lblDateToReturn);
		
		txtHolderName = new JTextField();
		txtHolderName.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtHolderName.setBounds(325, 11, 101, 16);
		frame.getContentPane().add(txtHolderName);
		txtHolderName.setColumns(10);
		
		textHolderID = new JTextField();
		textHolderID.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textHolderID.setColumns(10);
		textHolderID.setBounds(325, 38, 101, 16);
		frame.getContentPane().add(textHolderID);
		
		textBorrowStatus = new JTextField();
		textBorrowStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textBorrowStatus.setColumns(10);
		textBorrowStatus.setBounds(325, 66, 101, 16);
		frame.getContentPane().add(textBorrowStatus);
		
		textBorrowDate = new JTextField();
		textBorrowDate.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textBorrowDate.setColumns(10);
		textBorrowDate.setBounds(335, 94, 91, 16);
		frame.getContentPane().add(textBorrowDate);
		
		textDeadline = new JTextField();
		textDeadline.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textDeadline.setColumns(10);
		textDeadline.setBounds(335, 122, 91, 16);
		frame.getContentPane().add(textDeadline);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(259, 6, 173, 154);
		frame.getContentPane().add(panel);
	}
}
