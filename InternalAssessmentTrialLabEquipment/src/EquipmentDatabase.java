import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EquipmentDatabase {

	/*
	 * CREATED BASIC TREE
	 */
	
	private JFrame frame;

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
		scrollPane.setBounds(6, 6, 438, 207);
		frame.getContentPane().add(scrollPane);
		
		DefaultMutableTreeNode equipmentTree=new DefaultMutableTreeNode("Equipment");  
	    DefaultMutableTreeNode testTubes=new DefaultMutableTreeNode("Test Tubes");  
	    DefaultMutableTreeNode beakers=new DefaultMutableTreeNode("Beakers");  
	    DefaultMutableTreeNode funnels=new DefaultMutableTreeNode("Funnels");  
	    DefaultMutableTreeNode cylinder=new DefaultMutableTreeNode("Graduated Cylinders");  
	    DefaultMutableTreeNode thermometer=new DefaultMutableTreeNode("Thermometers");  
	    equipmentTree.add(testTubes);  
	    equipmentTree.add(beakers);  
	    equipmentTree.add(funnels);  
	    equipmentTree.add(cylinder);  
	    equipmentTree.add(thermometer);  
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
	    
	    
	    JTree tree = new JTree(equipmentTree);
		scrollPane.setViewportView(tree);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close current window
				frame.dispose();
				//Take user back to Index Screen
				AdminIndex.main(null);
			}
		});
		btnHome.setBounds(99, 225, 117, 29);
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
		btnLogOut.setBounds(228, 225, 117, 29);
		frame.getContentPane().add(btnLogOut);
	}
}
