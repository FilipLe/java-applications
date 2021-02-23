package monarchs;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

public class MonarchTableModel extends AbstractTableModel{
	//Creating Monarchs in a private array (people cannot change the data)
	private Monarch[] presetMonarchs = new Monarch[] {
			//Format: Name: isMale : start of reign: end of reign
			new Monarch("Henry VIII", Gender.MALE, 1509, 1547, "https://englishhistory.net/wp-content/uploads/2017/03/henry8afterholbein3.jpg"),
			new Monarch("Mary I", Gender.FEMALE, 1553, 1558, "https://englishhistory.net/images/tudor/elizsister.jpg"),
			new Monarch("Elizabeth I", Gender.FEMALE, 1558, 1603, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Darnley_stage_3.jpg/1200px-Darnley_stage_3.jpg"),
			new Monarch("Richard III", Gender.MALE, 1483, 1485, "https://cdn.britannica.com/47/182247-050-644E75E2/Richard-III-panel-artist.jpg")
	};
	
	//arraylist to store the monarchs
	//Arraylist is different from array that once an array is created, the size is fixed, but not in arraylists
	private ArrayList<Monarch> monarchs = new ArrayList<>();
	
	
	//Setting the table to start with the 4 fixed monarchs above
	MonarchTableModel()
	{
		monarchs.addAll(Arrays.asList(presetMonarchs));
	}
	
	public Monarch getMonarch(int rowIndex) {
		return monarchs.get(rowIndex);
	}
	
	//putting monarch into the table
	public void addMonarch(Monarch monarch) {
		//Adding monarch into the table
		monarchs.add(monarch);
		//updates table
		fireTableDataChanged();
	}
	
	public String getColumnName(int columnIndex) 
	{
		//changing column headings
		if(columnIndex == 0) 
		{
			return "Name";
		}
		else if(columnIndex == 1)
		{
			return "Gender";
		}
		else if(columnIndex == 2)
		{
			return "Start Year";
		}
		else if(columnIndex == 3)
		{
			return "End Year";
		}
		else 
		{
			return null;
		}
		
	}
	
	@Override
	public int getRowCount() {
		//Returns length of array/number of rows
		return monarchs.size();
	}

	@Override
	public int getColumnCount() {
		// 4 columns: a column for name, gender, start year, and end year
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Return the data that goes in each cell of the table
		
		// Row index to figure out which Monarch we are currently looking at
		// Each Monarch will have their own row
		Monarch monarch = monarchs.get(rowIndex);
		
		
		//working out which piece of data about
		if(columnIndex == 0) 
		{
			//Name is the first column
			return monarch.getName();
		}
		else if(columnIndex == 1) 
		{
			//Gender column
			return monarch.getGender().toString();
		} 
		else if(columnIndex == 2) 
		{
			//Start year
			return monarch.getStartYear();
		}
		else if(columnIndex == 3) 
		{
			//End year
			return monarch.getEndYear();
		}
		else 
		{
			return null;
		}
		
	}
}
