package monarchs;

import java.awt.image.BufferedImage;
import java.io.File;

/*
 * Link to 1st vid: https://www.youtube.com/watch?v=daHqowPkkWo
 * Explanation to everything in full in the video
 * 
 * 2nd vid: https://www.youtube.com/watch?v=oJ8gq1eMhnA
 * Finished 2nd vid
 * 
 * 3rd vid:https://www.youtube.com/watch?v=zvHO6xv06rE
 * 
 * 4th vid:https://odysee.com/@MrCressey:e/Monarch-App-part-4---Displaying-portraits:3
 * 
 * 5th vid: https://odysee.com/@MrCressey:e/Monarch-App-part-5---Caching-portraits:0
 * 
 * Now on 6th vid: https://odysee.com/@MrCressey:e/Monarch-App-part-6---Data-entry-form:2
 * Stopped at 29:09
 */
public class Monarch {
	/*
	 * Private variables disable other programmers from accessing data directly, 
	 * so that they need to use the Methods created below to access that data
	 * This disables them from accidentally changing the data from a different class
	 */
	private String name;
	
	//Gender of monarch
	private Gender gender;
	
	//Start year of the monarch's reign
	private int startYear;
	
	//Start year of the monarch's reign
	private int endYear;
	
	//The monarch's portrait
	private Portrait portrait;
	
	
	//Constructor 
	Monarch(String name, Gender gender, int startYear, int endYear, String urlText)
	{
		//this.name refers to 'name' in line 7
		//copy value of name (L20) inside the constructor into 'name' in the class
		this.name = name;
		this.gender = gender;
		this.startYear = startYear;
		this.endYear = endYear;
		
		File file = new File(name);
		portrait = new Portrait(file,urlText);
	}
	
	
	//Accessor Method to return name of monarch
	//It's public so it's accessible to any programmer
	public String getName() 
	{
		return name;
	}
	
	//Accessor Method to return monarch's gender
	public Gender getGender() 
	{
		return gender;
	}
	
	//Accessor Method to return start year of monarch's reign
	public int getStartYear() 
	{
		return startYear;
	}
	
	//Accessor Method to return end year of monarch's reign
	public int getEndYear() 
	{
		return endYear;
	}
		
	//Accessor Method to return how long the monarch ruled
	public int lengthOfReign() 
	{
		return endYear - startYear;
	}
	
	//Accessor method to return the selected monarch's portrait
	public BufferedImage getImage(int width, int height) 
	{
		return portrait.scaleImage(width, height);
	}
	
	//Method to return Monarch's name
	public String toString() 
	{
		if(gender == Gender.MALE) 
		{
			return "King " + name;
		}
		else if(gender == Gender.FEMALE)
		{
			return "Queen "+ name;
		}
		else 
		{
			return name;
		}
	}
}
