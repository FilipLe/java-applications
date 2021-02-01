package lists;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JLabel;

public class MainWindow {

	private JFrame frame;
	//Declaring imageLabel so it can be accessed any method inside the class
	JLabel imageLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 689, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 169, 500);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		ListDataModel dataModel = new ListDataModel();
		list.setModel(dataModel);
		
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();
				showPicture(index);
			}
		});
		
		imageLabel = new JLabel("New label");
		imageLabel.setBounds(180, 6, 500, 500);
		frame.getContentPane().add(imageLabel);
		
	}
	
	private void showPicture(int number) {
		/*
		 * Program code for displaying the picture
		 */
		//Makes a new class of CityImages ==> read in 
		//image file and stores the image in images
		CityImages cityImages = new CityImages();
		
		//declare cityImage
		BufferedImage cityImage = null;
		
		
		//Get photo of France
		if(number == 0)
			cityImage = cityImages.getImage(0,0);
		//Get photo of UK
		else if(number == 1)
			cityImage = cityImages.getImage(0,1);
		//Get photo of Italy
		else if(number == 2)
			cityImage = cityImages.getImage(1,0);
		//Get photo of Germany
		else if(number == 3)
			cityImage = cityImages.getImage(1,1);
		
		imageLabel.setIcon(new ImageIcon(cityImage));
	}
}
