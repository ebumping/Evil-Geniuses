package eBot;

import java.util.ArrayList;
import java.util.List;

public class Users {
	private String nick;
	public Users(String nick){
		this.nick = nick;
		//for(Users x : users);		
		
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

}
