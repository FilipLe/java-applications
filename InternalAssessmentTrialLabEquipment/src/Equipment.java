import java.math.BigDecimal;

import com.github.cliftonlabs.json_simple.JsonObject;

public class Equipment {
	private String type;
	private String ID;
	private String status;
	private String holderName;
	private String holderID;
	
	//Constructor for Equipment
	Equipment(String type, String ID, String status, String holderName, String holderID){
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
	
	public String getID() {
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
		//<key>:<value>
		JsonObject uniqueID = new JsonObject();
		JsonObject properties = new JsonObject();
		uniqueID.put(ID, properties);
		properties.put("type", type);
		properties.put("status", status);
		properties.put("holderName", holderName);
		properties.put("holderID", holderID);
		
		/*
		 * Format we want to save it in:
		 * {
		 * 	1014:{"name":"test tube","status":"unavailable","holder name":"Joe","holderID":"1292"},
		 * 	2032:{"name":"beaker","status":"available","holder name":"null","holderID":"null"}
		 * }
		 */
		return uniqueID;
	}
	
	//This is going to take a Json Object and return an equipment with all the data stored in that object
	public static Equipment fromJsonObject(JsonObject uniqueID) {
		//We need to get key instead of "ID" because that string will not exist
		String ID = (String)uniqueID.get("ID");
		String type = (String)uniqueID.get("type");
		String status = (String)uniqueID.get("status");
		String holderName = (String)uniqueID.get("holderName");
		String holderID = (String)uniqueID.get("holderID");
		return new Equipment(type,ID,status,holderName,holderID);
	}
}
