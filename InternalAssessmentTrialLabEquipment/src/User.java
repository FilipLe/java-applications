
public class User {
	private String name;
	private int UserID;
	
	User(String name, int UserID)
	{
		this.name = name;
		this.UserID = UserID;
	}
	
	/*
	 * This is for printing out details after creating account
	 */
	
	//Allowing program to output user's name
	public String getName() 
	{
		return name;
	}
	
	//Output UserID
	public int getUserID()
	{
		return UserID;
	}
}

