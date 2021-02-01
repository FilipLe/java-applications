package cardgame;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Random;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
/* 
 * IN BLACKJACK:
 * King, Queen, Jack all worth 10 points
 * Numbers are worth their numbers
 * Ace can be either 11 points
 */
public class MainWindow {

	private JFrame frame;
	private JTextField currentTotal;
	//variable to store the total value of the first 2 drawn cards
	public int total;
	//x coordinate of the cards
	public int randomX1;
	public int randomX2;
	
	//y coordinates and the actual values of the cards drawn
	public int randomY1;
	public int randomY2;
	
	//x coordinate of the third card that user hits
	public int randomXNew;
	//Value and y coord
	public int randomYNew;
	
	//set that game has not been won yet initially
	public boolean winState = false; 
	
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
		Random random = new Random();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0x55aa55));
		frame.setBounds(100, 100, 587, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel cardLabel1 = new JLabel("Image goes here");
		cardLabel1.setBounds(6, 6, 100, 147);
		frame.getContentPane().add(cardLabel1);
		
		
		JLabel cardLabel2 = new JLabel("Image goes here");
		cardLabel2.setBounds(118, 6, 100, 147);
		frame.getContentPane().add(cardLabel2);
		
		JButton dealButton = new JButton("Deal");
		dealButton.setBounds(6, 170, 212, 29);
		frame.getContentPane().add(dealButton);
		
		currentTotal = new JTextField();
		currentTotal.setBounds(6, 248, 130, 26);
		frame.getContentPane().add(currentTotal);
		currentTotal.setColumns(10);
		
		JLabel totalLabel = new JLabel("Current total:");
		totalLabel.setBounds(13, 225, 100, 16);
		frame.getContentPane().add(totalLabel);
		
		JLabel HitOrStand = new JLabel(" ");
		HitOrStand.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		HitOrStand.setBounds(297, 55, 160, 16);
		frame.getContentPane().add(HitOrStand);
		
		//Hit text not showing yet because player hasn't dealt with first 2 cards yet
		JButton hitButton = new JButton(" ");
		hitButton.setBounds(307, 77, 100, 29);
		//Make the background of hit button match frame background so user can't see it yet
		hitButton.setBackground(new Color(0x55aa55));
		hitButton.setOpaque(true);
		hitButton.setBorderPainted(false);
		frame.getContentPane().add(hitButton);
		
		//Stand text not showing yet because player hasn't dealt with first 2 cards yet
		JButton standButton = new JButton(" ");
		standButton.setBounds(307, 106, 100, 29);
		//Make the background of stand button match frame background so user can't see it yet
		standButton.setBackground(new Color(0x55aa55));
		standButton.setOpaque(true);
		standButton.setBorderPainted(false);
		frame.getContentPane().add(standButton);
		
		JLabel cardLabelNew = new JLabel(" ");
		cardLabelNew.setBounds(459, 17, 100, 147);
		frame.getContentPane().add(cardLabelNew);
		
		JLabel winOrloseText = new JLabel("");
		winOrloseText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		winOrloseText.setBounds(243, 225, 316, 16);
		frame.getContentPane().add(winOrloseText);
		
		DeckImage deckImage = new DeckImage();
		
		
		//actionLister = function when a button is clicked 
		dealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Numbers 0,1,2,3 excluding 4
				randomX1 = random.nextInt(4);
				//Numbers from 0 to 12, excluding 13
				randomY1 = random.nextInt(13);
				
				randomX2 = random.nextInt(4);
				randomY2 = random.nextInt(13);
				
				System.out.println(randomY1);
				System.out.println(randomY2);
				/*
				 * J when y = 10
				 * Q when y = 11
				 * K when y = 12
				 * A when y = 0
				 * 
				 */
			
				/*
				 * Draw the images
				 */
				BufferedImage cardImage1 = deckImage.getImage(randomX1,randomY1);
				cardLabel1.setIcon(new ImageIcon(cardImage1));
				
				BufferedImage cardImage2 = deckImage.getImage(randomX2,randomY2);
				cardLabel2.setIcon(new ImageIcon(cardImage2));
				
				 
				/* 
				 * IN BLACKJACK:
				 * King, Queen, Jack all worth 10 points
				 * Numbers are worth their numbers
				 * Ace can be either 11 points
				 */
				//Ace worth 11 points
				if(randomY1 == 0) 
					randomY1 = 11;
				//K, Q, J worth 10 points
				if(randomY1 == 10||randomY1 == 11||randomY1 == 12) 
					randomY1 = 10;
				//Normal numerical values, since everything has been shifted by 1, we add 1 into it
				if(randomY1 < 10 && randomY1 > 0) 
					randomY1 += 1;
				
				//Do the same steps for the second set of cards
				if(randomY2 == 0) 
					randomY2 = 11;
				if(randomY2 == 10||randomY2 == 11||randomY2 == 12) 
					randomY2 = 10;
				if(randomY2 < 10 && randomY2 > 0) 
					randomY2 += 1;
				
				//Get the total of the first 2 cards drawn
				total = randomY1 + randomY2;
				String result2 = Integer.toString(total);
				currentTotal.setText(result2);
				
				/*
				 * Ask if user wants to hit or stand after they dealt their first 2 cards
				 */
				HitOrStand.setText("Hit or Stand?");
				
				/*
				 * Hit button appears
				 */
				//'Hit' text appears
				hitButton.setText("Hit");
				//Make color of button white so it is visible
				hitButton.setBackground(new Color(0x000000));
				hitButton.setOpaque(false);
				//Draw borders
				hitButton.setBorderPainted(true);
				
				//'Stand' text appears
				standButton.setText("Stand");
				//Make color of button white so it is visible
				standButton.setBackground(new Color(0x000000));
				standButton.setOpaque(false);
				//Draw borders
				standButton.setBorderPainted(true);
				
							
				/*
				 * Hitting a new card
				 */
				hitButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//Numbers 0,1,2,3 excluding 4
						randomXNew = random.nextInt(4);
						//Numbers from 0 to 12, excluding 13
						randomYNew = random.nextInt(13);
						
						
						//Drawing new card
						BufferedImage cardImageNew = deckImage.getImage(randomXNew, randomYNew);
						cardLabelNew.setIcon(new ImageIcon(cardImageNew));
						
						//Determining the value of new card
						if(randomYNew == 0) randomYNew = 11;
						if(randomYNew == 10||randomYNew == 11||randomYNew == 12) randomYNew = 10;
						if(randomYNew < 10 && randomYNew > 0) randomYNew += 1;
						
						//Adding it to hand's total
						total += randomYNew;
						
						if(total < 21) 
						{
							winOrloseText.setText("You lost! You did not get Blackjack!");
						}
						else if(total > 21) 
						{
							winOrloseText.setText("Bust! You lost!");
						}
						else 
						{
							winOrloseText.setText("You won!");
						}
					}	
				});
				
				
				/*
				 * Standing
				 */
				standButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(total < 21) 
						{
							winOrloseText.setText("You lost! You did not get Blackjack!");
						}
						else if(total > 21) 
						{
							winOrloseText.setText("Bust! You lost!");
						}
						else 
						{
							winOrloseText.setText("You won!");
						}
					}
					
				});
			}
		});
	
		
	}
}
