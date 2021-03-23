import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

/*
 * For the ADMIN only
 * 
 * A table displaying all users, with all of their details
 * 
 * ADMIN can edit/delete user
 */
public class UserTableModel extends AbstractTableModel{
	
	//Admin as default user
	private User[] presetUser = new User[] 
	{
			new User("Admin", 0, "onetwothree")
	};
	
	//Creating arrayList to store the users
	private ArrayList<User> users = new ArrayList<>();
	
	//Add default to array
	UserTableModel()
	{
		users.addAll(Arrays.asList(presetUser));
	}
	
	/*
	 * Get the user clicked on the table model ==> So that we can edit them, or delete them
	 */
	public User getUser(int rowIndex) {
		return users.get(rowIndex);
	}
	
	
	/*
	 * Insert monarch into the Scroll Pane
	 */
	public void addUser(User newUser) {
		//Adding new user into the table
		users.add(newUser);
		
		//updates table
		fireTableDataChanged();
	}

	/*
	 * Column Headings (Name, UserID, Password
	 */
	public String getColumnName(int columnIndex) 
	{
		if(columnIndex == 0) 
		{
			return "Name";
		}
		else if(columnIndex == 1)
		{
			return "UserID";
		}
		else if(columnIndex == 2)
		{
			return "Password";
		}
		else
		{
			return null;
		}
	}
	
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return users.size();
	}


	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}


	public Object getValueAt(int rowIndex, int columnIndex) {
		User user = users.get(rowIndex);
		/*
		 * DISPLAYING INPUT ON TABLE
		 * 
		 * Error fixed. Now need to fix error in addUser() in AdminCreateUser and  work on reading input from AdminCreateUser and displaying it on TableModel
		 */
		if(columnIndex == 0) 
		{
			return user.getName();
		}
		else if(columnIndex == 1)
		{
			return user.getUserID();
		}
		else if(columnIndex == 2)
		{
			return user.getPassword();
		}
		else
		{
			return null;
		}
	}
}
