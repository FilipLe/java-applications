
public class User {
	private String name;
	private int UserID;
	private String password;
	
	User(String name, int UserID, String password)
	{
		this.name = name;
		this.UserID = UserID;
		this.password = password;
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
	
	//Output password
	public String getPassword() 
	{
		return password;
	}
}

