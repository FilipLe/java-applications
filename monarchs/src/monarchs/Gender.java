package monarchs;

//Class to store gender 
public enum Gender {
	UNKNOWN("Unknown"),
	MALE("Male"),
	FEMALE("Female")
	;
	
	private String text;
	
	Gender(String text)
	{
		this.text = text;
	}
	
	public String toString() 
	{
		return text;
	}
}
