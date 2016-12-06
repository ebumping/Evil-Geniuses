package eBot;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jibble.pircbot.*;
//to import this right click JRE Sys Lib and import app rar from mybot folder
public class BumpingBotMain {
	private static final String OAUTH = "oauth:g5ztrdza7uu4vfr37ta7peaszvsal1";
	private static final String address = "irc.chat.twitch.tv";
	private static final int port = 6667;
	//These private static final Strings and integers allow the Java program to query the Twitch API via HTTPS
	public static void main(String[] args) throws Exception{
		
		//This starts the bot up
		Tay t = new Tay();
		
		//This enables debugging output
		t.setVerbose(true);
		
		try{
			
		
		//this will connect to the IRC server
		t.connect(address, port, OAUTH);
		//Logger object displays bot connection status messages via console
		}catch(IOException ex){
			Logger.getLogger(Tay.class.getName()).log(Level.SEVERE, null, ex);
		}catch(IrcException ex){
			Logger.getLogger(Tay.class.getName()).log(Level.SEVERE, null, ex);
		}		
	}
}