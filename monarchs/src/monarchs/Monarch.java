package monarchs;
/*
 * Link to vid: https://www.youtube.com/watch?v=daHqowPkkWo
 * Explanation to everything in full in the video
 */
public class Monarch {
	String name;
	
	//Since there are only 2 genders, we only need to use boolean
	boolean isMale;
	
	//Start year of the monarch's reign
	int startYear;
	
	//End year of the monarch's reign
	int endYear;
	
	
	//Constructor 
	Monarch(String name, boolean isMale, int startYear, int endYear)
	{
		//this.name refers to 'name' in line 7
		//copy value of name (L20) inside the constructor into 'name' in the class
		this.name = name;
		this.isMale = isMale;
		this.startYear = startYear;
		this.endYear = endYear;
	}
	
	//An action to calculate how long the monarch ruled
	int lengthOfReign() 
	{
		return endYear - startYear;
	}
	
	//Method to return Monarch's name
	public String toString() 
	{
		if(isMale == true) 
		{
			return "King " + name;
		}
		else
		{
			return "Queen "+ name;
		}
	}
}
