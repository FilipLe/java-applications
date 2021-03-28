import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;

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
		scrollPane.setBounds(6, 6, 438, 260);
		frame.getContentPane().add(scrollPane);
		
		DefaultMutableTreeNode equipmentTree=new DefaultMutableTreeNode("Equipment");  
	    DefaultMutableTreeNode testTubes=new DefaultMutableTreeNode("Test Tubes");  
	    DefaultMutableTreeNode beakers=new DefaultMutableTreeNode("Beakers");  
	    equipmentTree.add(testTubes);  
	    equipmentTree.add(beakers);  
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
	    
	    JTree tree = new JTree(equipmentTree);
		scrollPane.setViewportView(tree);
	}
}
