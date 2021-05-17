import java.math.BigDecimal;

import com.github.cliftonlabs.json_simple.JsonObject;

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
	
	/*
	 * Method for user to call out info
	 */
	public String getType() {
		return type;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getHolderName(){
		return holderName;
	}
	
	public String getHolderID() {
		return holderID;
	}
	
	
	/*
	 * Converting to json
	 */
	public JsonObject toJsonObject() {
		JsonObject jo = new JsonObject();
	
		jo.put("type", type);
		jo.put("ID", ID);
		jo.put("status", status);
		jo.put("holderName", holderName);
		jo.put("holderID", holderID);
		
		
		/*
		 * 1014
		 * {
		 * 	1014:{"name":"test tube","status":"available}
		 * 	2032:{"name":"beaker","status":available}
		 * }
		 */
		return jo;
	}
	
	//This is going to take a Json Object and return an equipment with all the data stored in that object
	public static Equipment fromJsonObject(JsonObject jo) {
		String type = (String)jo.get("type");
		int ID = ((BigDecimal)jo.get("ID")).intValue();
		String status = (String)jo.get("status");
		String holderName = (String)jo.get("holderName");
		String holderID = (String)jo.get("holderID");
		return new Equipment(type,ID,status,holderName,holderID);
	}
}
