package november2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import november.TDB;
import november.User;

public class Collections {
	private List<User> users = new ArrayList<User>();
	
	private static Comparator<User> SORT_BY_FIRSTNAME = new Comparator<User>(){
		
		//actual users here

		@Override
		public int compare(User arg0, User arg1) {			
			return arg0.getFirstName().compareTo(arg1.getFirstName());
		}
		
	};
	private Comparator<User> sortByLastName = new Comparator<User>(){
		
		@Override
		public int compare(User argz0, User argz1){
			return argz0.getLastName().compareTo(argz1.getLastName());
		}
		
	};
	
	private void sortListF(){
		System.out.println("Sort by first name");
		Collections.sort(users, SORT_BY_FIRSTNAME);
		
	}

	private static void sort(List<User> users2, Comparator<User> SORT_BY_FIRSTNAME) {
		
		
	}
	public void list(){
		for (User x : users){
			System.out.println(x);
		}
	}
	
	//loop ovr list
	public static void main(String[] argz){
		Collections cs = new Collections();
		cs.list();
		
	}

}
