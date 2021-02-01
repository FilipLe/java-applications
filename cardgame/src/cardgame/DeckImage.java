package cardgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/*
 * Video:
 * https://lbry.tv/@MrCressey:e/Simple-card-game-in-Java-Swing:3?r=CGM9Aoxw5oq2MPfiCj9qgtVutruoUFXo 
 */

public class DeckImage {
	//each card is 100 pixels wide
	final int WIDTH = 100;
	
	//each card is 147 pixels in height
	final int HEIGHT = 147;
	
	
	//New Variable to store the image
	//BufferedImage = a type of variable --> image stored in memory 
	BufferedImage deckImage;	
	
	//Constructor
	DeckImage(){
		//Create stream of data
		InputStream stream = getClass().getResourceAsStream("cards.png");
		
		//read in the data
		try {
			deckImage = ImageIO.read(stream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	//this method returns buffered image
	//with the input of row and column
	BufferedImage getImage(int row, int column) {
		int x = column * WIDTH;
		int y = row * HEIGHT;
		
		//create empty image so that we can paste the card into
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		//GRAPHICS CONTEXTS of an image --> something to control/change image
		Graphics g = image.createGraphics();
		
		g.drawImage(deckImage,0,0,WIDTH,HEIGHT,x,y,x + WIDTH,y + HEIGHT,null);
		return image;
	}
}
