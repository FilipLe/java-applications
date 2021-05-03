
public class Equipment {
	private String type;
	private int ID;
	private String status;
	private String holderName;
	private String holderID;
	
	//Constructor for Equipment
	Equipment(String type, int ID, String status, String holderName, String holderID){
		this.type = type;
		this.ID = ID;
		this.status = status;
		this.holderName = holderName;
		this.holderID = holderID;
	}
}
