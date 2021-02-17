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
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
