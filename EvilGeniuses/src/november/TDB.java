package november;

import java.util.ArrayList;
import java.util.List;
public class TDB {
	List<User> users = new ArrayList<User>();
	
	public TDB(){
		users.add(new User("Ted", "Cruz", "zodiac@gmail.com"));
		users.add(new User("Dyl", "J", "ebumping@gmail.com"));
		
	}
	public void addUser(User user) throws Exception{
		if (user.getFirstName().isEmpty() && user.getLastName().isEmpty() && user.getEmail().isEmpty()){
			throw new Exception("First Name, Last Name and email are required fields");
		}else{
			users.add(user);
		}
	}
	public User findUser(String firstName, String lastName){
		User foundUser = null;
		if(users.equals(firstName + lastName)){
			return users.get(0);
		}
		return foundUser;
		
			
		
		
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