package monarchs;

import javax.swing.table.AbstractTableModel;

public class MonarchTableModel extends AbstractTableModel{
	//Creating Monarchs in a private array (people cannot change the data)
	private Monarch[] monarchs = new Monarch[] {
			//Format: Name: isMale : start of reign: end of reign
			new Monarch("Henry VIII", true, 1509, 1547),
			new Monarch("Mary I", false, 1553, 1558),
			new Monarch("Elizabeth I", false, 1558, 1603)
	};
	
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
		return monarchs.length;
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
		Monarch monarch = monarchs[rowIndex];
		
		
		//working out which piece of data about
		if(columnIndex == 0) 
		{
			//Name is the first column
			return monarch.getName();
		}
		else if(columnIndex == 1) 
		{
			//Gender column
			
			//Check if the monarch is a male and return their gender
			if(monarch.getIsMale()) 
			{
				return "Male";
			}
			else 
			{
				return "Female";
			}
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
	
	Monarch getMonarch(int index) {
		return monarchs[index];
	}
}
