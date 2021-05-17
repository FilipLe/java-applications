import java.math.BigDecimal;

import com.github.cliftonlabs.json_simple.JsonObject;

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
	
	
	//Converting to JSONObj()
	public JsonObject toJsonObject() {
		JsonObject jo = new JsonObject();
		
		//JSON format: <key>:<value> --> UserID is unique ==> Make it a key
		jo.put(String.valueOf(UserID), name);
		
		/*
		 * [
		 * 	{7159:"Filip"},
		 * 	{3244:"Jason},
		 * 	etc.
		 * ]
		 */
		
		//return the JSON Object created
		return jo;
	}
	
	//This is going to take a Json Object and return a user with all the data stored in that object
	public static User fromJsonObject(JsonObject jo) {
		String name = (String)jo.get("name");
		int UserID = ((BigDecimal)jo.get("UserID")).intValue();
		return new User(name,UserID);
	}
}

