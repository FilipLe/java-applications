package lists;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

//Class to read in files
public class CityImages {
	//Containter for all 4 images
	private BufferedImage images;
	final public int height = 500;
	final public int width = 500;
	//Coordinate of the bottom left vertex of image
	public int startX = 0;
	public int startY = 0;
	
	//Coordinate of the top right vertex of image
	public int endX = 500;
	public int endY = 500;
	
	CityImages(){
		//Allows us to read data
		InputStream stream = getClass().getResourceAsStream("cities.png");
		
		//To read in that data
		try {
			images = ImageIO.read(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	//Method which cuts out the images and returns 1 of the 4 images
	BufferedImage getImage(int row, int column) {
		//Container for 1 image separately
		BufferedImage image = new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.createGraphics();
		int sx = column * 500;
		int sy = row * 500;
		graphics.drawImage(images,startX,startY,endX,endY,sx,sy,sx+500,sy+500,null);
		return image;
		
	}
}
