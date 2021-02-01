package lists;
//Import the model that specifies the rules of what a list model should be
import javax.swing.AbstractListModel;

public class ListDataModel extends AbstractListModel {
	@Override
	//Returns the size of list
	public int getSize() {
		//Since our picture has 4 cities, we return 4
		return 4;
	}

	@Override
	public Object getElementAt(int index) {
		// Return what is displayed at each item in the list
		if(index == 0) return "France";
		if(index == 1) return "UK";
		if(index == 2) return "Italy";
		if(index == 3) return "Germany";
		//If index != 0,1,2,3 --> return nothing
		return null;
	}

}
