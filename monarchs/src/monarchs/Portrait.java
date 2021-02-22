package monarchs;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class Portrait {
	private BufferedImage image;
	
	//Method to create portrait
	public Portrait(String urlText) 
	{
		//image equal to the portrait that we read from given URL
		image = getPortrait(urlText);
	}
	
	//Method to load image from the internet
	public BufferedImage getPortrait(String urlText) 
	{
		try {
			//creating new url from the URL text
			URL url = new URL(urlText);
			
			//open stream to read data from
			InputStream stream = url.openStream();
			
			//create image, reading data from that stream
			BufferedImage image = ImageIO.read(stream);
			
			//close connection to the website
			stream.close();
			
			//return the image that we created
			return image;
		} catch (Exception e) {
			//If an error occurs in any of the 4 statements above (in try{})
			//then whatever the error is, we are going to crash the program
			throw new RuntimeException(e);
		}
	}
	
	
	//Method to scale the image to fit in the panel
	public BufferedImage scaleImage(int width, int height) 
	{
		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//Getting graphics context for that image
		Graphics graphics = newImage.createGraphics();
		
		//After getting the graphics context, we draw the old image onto the new image at the desired size
		graphics.drawImage(image, 0, 0, width, height, 0, 0, image.getWidth(), image.getHeight(), null);
		
		return newImage;
	}
}
