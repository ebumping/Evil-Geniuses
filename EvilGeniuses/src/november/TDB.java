package november;

import java.util.ArrayList;
import java.util.List;
public class TDB {
	List<User> users = new ArrayList<User>();
	
	public TDB(){
		users.add(new User("Ted", "Cruz", "zodiac@gmail.com"));
		users.add(new User("Dylan ", "Jeffery", "ebumping@gmail.com"));
		
	}
	public void addUser(User user) throws Exception{
		if (user.getFirstName().isEmpty() && user.getLastName().isEmpty() && user.getEmail().isEmpty()){
			throw new Exception("First Name, Last Name and email are required fields");
		}else{
			users.add(user);
		}
	}
	public User findUser(String firstName, String lastName) throws Exception{
		User foundUser = null;
		if(users.contains(firstName) && users.contains(lastName)){
			throw new Exception("User found");
			
		
		}else{
			return foundUser;
		}		
	}
}
	/*
	 * Sort User
	 
	 * Del User
	 */
	





//Break this down by Model\View\Controller classwise
//					  user \ ui \ database
//							\    \find
//							 \	  \list
//								   \Sort
//									\Del