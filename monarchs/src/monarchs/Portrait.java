package monarchs;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class Portrait {
	private BufferedImage image;
	
	//Method to create portrait and save the portrait in the disk
	public Portrait(File file, String urlText) 
	{
		//if that file does not exist, then download it
		if(!file.exists()) 
		{
			//download file from provided URL
			downloadFile(file,urlText);
			
			//download message, if image wasn't downloaded before
			System.out.println("Downloading image from: " + urlText);
		}
		//loading file/portrait from hard disk into program
		image = getPortrait(file);
	}
	
	//Method to download the file from internet and save it to our disk
	public void downloadFile(File file, String urlText) {
		try {
			//creating new url from the URL text
			URL url = new URL(urlText);
			
			//open stream to read data from
			InputStream stream = url.openStream();
			
			//reading raw data (array of bytes)
			byte[] rawData = stream.readAllBytes();
			
			//close connection to the website
			stream.close();
			
			//output stream which writes data to the file that we will provide as a parameter (L24)
			OutputStream stream2 = new FileOutputStream(file);
			
			//write all that data to the stream
			stream2.write(rawData);
			stream2.close();
		} catch (Exception e) {
			//If an error occurs in any of the 4 statements above (in try{})
			//then whatever the error is, we are going to crash the program
			throw new RuntimeException(e);
		}
	}
	
	//Method to load image from the file in disk
	public BufferedImage getPortrait(File file) 
	{
		try {
			//open stream to read data from
			InputStream stream = new FileInputStream(file);
			
			//create image, reading data from that stream
			BufferedImage image = ImageIO.read(stream);
			
			//close connection to disk
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
