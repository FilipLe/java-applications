import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class EquipmentsTeachers {

	/*
	 * CHECK ONENOTE JAVA TRIAL BLUE ARROWS TO SEE THE DESIGN I AM GOING FOR
	 * 
	 * Now work on JSON for both Equipment managing and User managing, and then go to other Program with Status Lights
	 * 
	 * EQUIPMENT DATABASE FOR TEACHERS
	 * 
	 * 
	 * GOAL: to add the display "available"/"taken" feature
	 */
		
	private JFrame frame;
	private JTextField textBorrowStatus;
	private JTextField textField_EquipmentType;
	private JTextField textField_ITEM_ID;
	public boolean available;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentsTeachers window = new EquipmentsTeachers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Method to check if something is an integer
	 */
	public boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
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
                for (int i = 1; i < pathCount; i++) {
                    System.out.print(path.getPathComponent(i).toString());
                    if (i + 1 != pathCount) {
                        System.out.print("-->");
                    }
                }
                System.out.println("\n");
                
                
                //Accessing the outer most Child node ==> The Item ID
                String itemId = path.getPathComponent(pathCount-1).toString();
                
                //Accessing the second outer most child node ==> equipment type
                String equipmentType = path.getPathComponent(pathCount-2).toString();
                
                //Only if the item Id clicked is an integer, we display on the information board
                if(isInteger(itemId) == true) {
	                //Set the fields to corresponding clicked item
	                textField_EquipmentType.setText(equipmentType);
					textField_ITEM_ID.setText(itemId);
                }
            }
        };
    }
	
	/**
	 * Create the application.
	 */
	public EquipmentsTeachers() {
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
		btnHome.setBounds(259, 237, 91, 29);
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
		btnLogOut.setBounds(353, 237, 91, 29);
		frame.getContentPane().add(btnLogOut);
		
		JLabel labelStatus = new JLabel("Item Status:");
		labelStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		labelStatus.setBounds(264, 91, 86, 16);
		frame.getContentPane().add(labelStatus);
		
		//Box to display borrow status of clicked item
		textBorrowStatus = new JTextField();
		textBorrowStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textBorrowStatus.setColumns(10);
		textBorrowStatus.setBounds(325, 90, 101, 16);
		frame.getContentPane().add(textBorrowStatus);
		
		//Clear button
		JButton btnClear = new JButton("Un-select");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_EquipmentType.setText(null);
				textField_ITEM_ID.setText(null);
				textBorrowStatus.setText(null);
			}
		});
		btnClear.setBounds(274, 206, 148, 29);
		frame.getContentPane().add(btnClear);
		
		JLabel labelItemName = new JLabel("Equipment Type:");
		labelItemName.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		labelItemName.setBounds(264, 35, 86, 16);
		frame.getContentPane().add(labelItemName);
		
		//Box to display equipment name of clicked item
		textField_EquipmentType = new JTextField();
		textField_EquipmentType.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textField_EquipmentType.setColumns(10);
		textField_EquipmentType.setBounds(335, 34, 91, 16);
		frame.getContentPane().add(textField_EquipmentType);
		
		JLabel lblEquipmentId = new JLabel("Equipment ID:");
		lblEquipmentId.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblEquipmentId.setBounds(264, 63, 86, 16);
		frame.getContentPane().add(lblEquipmentId);
		
		//Box to display equipment ID of clicked item
		textField_ITEM_ID = new JTextField();
		textField_ITEM_ID.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textField_ITEM_ID.setColumns(10);
		textField_ITEM_ID.setBounds(325, 63, 101, 16);
		frame.getContentPane().add(textField_ITEM_ID);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(259, 23, 173, 103);
		frame.getContentPane().add(panel);
		
		JLabel lblEquipment = new JLabel("Equipment Information:");
		lblEquipment.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 12));
		lblEquipment.setBounds(264, 6, 162, 16);
		frame.getContentPane().add(lblEquipment);
		
		/*
		 * BORROW BUTTON
		 */
		JButton btnBorrow = new JButton("BORROW");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBorrow.setBounds(264, 150, 162, 44);
		frame.getContentPane().add(btnBorrow);
	}
}
