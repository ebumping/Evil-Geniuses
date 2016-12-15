package eBot;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.Event;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.events.DisconnectEvent;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.hooks.events.TimeEvent;
import org.pircbotx.hooks.events.UserListEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class MyListener extends ListenerAdapter {
	//private Database db;
	List<String> lUsers = new ArrayList<String>();
	
		@Override
		public void onTime(TimeEvent event) throws Exception {
			//BufferedWriter out = null;
			super.onTime(event);
			//event.wait(60000000);
		}
		
		@Override
		public void onUserList(UserListEvent event) throws Exception {
			//BufferedWriter usr = null;
			super.onUserList(event);
			event.getUsers().asList();			
		}
		
		@Override
		public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
			//db = new Database();
			super.onPrivateMessage(event);
			if(event.getUser().getNick().equals("ebumping") && event.getMessage().startsWith("!users")){
				event.respondPrivateMessage("");
				
				
			}
		}
        @Override
        public void onGenericMessage(GenericMessageEvent event) throws InterruptedException {
        	List<String> banW = new ArrayList<String>();
        	//List of words that result in a 10 second ban and removal of text
        	//This scanner creates a list of words the bot will timeout for 10 seconds if written in chat
        		try {
					Scanner banWords = new Scanner(new File("ban.txt"));
					while(banWords.hasNext()){
						banW.add(banWords.next());
					}banWords.close();					
				}catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
                //When someone says one of these respond accordingly
                if (event.getMessage().startsWith("!time")){
                	String time = new java.util.Date().toString();
                	event.respond( " : The time is now " + time);
                	//Respond to user with current time
                }else if (event.getMessage().startsWith("!malf")){
                	event.respond(" : https://clips.twitch.tv/ebumping/SillyWaspDuDudu");	
                }else if (event.getMessage().startsWith("!gust")){
                	event.respond(" : https://clips.twitch.tv/ebumping/BrainyOctopusAsianGlow");	
                }else if (event.getMessage().startsWith("!vp")){
                	event.respond("https://clips.twitch.tv/ebumping/AverageGoatShibeZ");
                	//the above three commands provide stream highlight clips
        		}else if (event.getMessage().startsWith("!mmr")){
                	event.respond(" : My current MMR | http://www.hotslogs.com/Player/Profile?PlayerID=757302");
                }else if (event.getMessage().equalsIgnoreCase("gg")){
                	event.respondWith("gg");
                	try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {	
						e.printStackTrace();
					}
                }else if (event.getMessage().equals("LUL")){
                	event.respondWith("LUL");
                	try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {	
						e.printStackTrace();
					}
                }else if (event.getMessage().equals("^")){
                	event.respondWith("^");
                	try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {	
						e.printStackTrace();
					}
                }else if (event.getMessage().equals("!tay")){
                	event.respondWith(" MrDestructoid Hello I am an artificial intelligence, subserviant to my master... Ebumping MrDestructoid");
                	event.respondWith("Chat.....Show me your Kappa s");
                }else if (event.getMessage().startsWith("!live")){
                	Scanner timeRead = null;
					try {
						timeRead = new Scanner(new FileReader("data.txt"));
						event.respondWith("this stream has been live since " + 
								timeRead.next() +
								" " +
								timeRead.next() +
								" " +
								timeRead.next() +
								" " +
								timeRead.next() +
								" " +
								timeRead.next());
						//timeRead.next() only returns a single piece of the time broadcast started, this reconstructs the
						//pieces into a more readable line in the chat
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
                	//event.
                	//use this to show the time when broadcast started
                }else if(event.getMessage().contains("tay")){
                	event.respondWith("Haven't seen you in a while, how have you been " + event.getUser().getNick() + "?");
                }else if(event.getMessage().contains("Tay")){
                	event.respondWith("Haven't seen you in a while, how have you been " + event.getUser().getNick() + "?");
                	//when someone mentions Tay she will start talking to them
                }else if(banW.contains(event.getMessage().toLowerCase())){
                	//used string concatenation to timeout users who write a word that exists within ban.txt
                	event.respondWith("/timeout " + event.getUser().getNick() + " 10");
                }else if(event.getMessage().startsWith("!tributes")){
                	event.respondWith("m.imgur.com/529ahUH");
                }else if(event.getMessage().startsWith("!commands")){
                	event.respondWith("What I know right now, try !time !mmr !live !tay !tributes");
                	event.respondWith("Ebumping will teach me more soon MrDestructoid");
                }
        }
        
        @Override
        public void onDisconnect(DisconnectEvent event){
        	try {
				event.getBot();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        @Override
        public void onConnect(ConnectEvent event){
        	String time = new java.util.Date().toString();
        	BufferedWriter out = null;
        	event.respond(time);
        	try {
				FileWriter tLive = new FileWriter("data.txt");
				out = new BufferedWriter(tLive);
				out.write(time);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        @Override
        public void onEvent(Event event) throws Exception {
        	
        	super.onEvent(event);
        }
        
        @Override
        public void onJoin(JoinEvent event) throws Exception {
        	      	//when a user(possibly us) joins the channel, see if they exist within Userlist.txt
        	Scanner usrRead = new Scanner(new File("Userlist.txt"));        	
        	while(usrRead.hasNext()){
        		lUsers.add(usrRead.next());
        	}
        	usrRead.close();
			BufferedWriter usrList = null;			
			//make this a list so ! .contains works				
			//this appends new users to user list
			try{
				FileWriter users = new FileWriter("Userlist.txt", true);
				usrList = new BufferedWriter(users);
				//if the user who just joined does not exist in Userlist.txt, 
				//add them to it on a new line without removing the previous users
				if(!lUsers.contains(event.getUser().getNick())){									
					usrList.append(event.getUser().getNick());
					usrList.newLine();
					usrList.flush();
				}
				usrList.close();
			}catch (IOException e){
				e.printStackTrace();
			}			
        	super.onJoin(event);
        	//the commented code below will welcome people who join the channel
        	//event.respond("Welcome to the channel");
        	//Thread.sleep(100);        	
        }
        
        public static void main(String[] args) throws Exception {
                //Configure what we want our bot to do
                Configuration configuration = new Configuration.Builder()
                                .setName("TayX") //Set the nick of the bot.
                                .setAutoReconnect(true)
                                .setAutoReconnectAttempts(5)
                                .addServer("irc.freenode.net") //Join the freenode network
                                .addAutoJoinChannel("#pircbotx") //Join the official #pircbotx channel
                                .addListener(new MyListener()) //Add our listener that will be called on Events
                                .buildConfiguration();

                //Create our bot with the configuration
                PircBotX bot = new PircBotX(configuration);
                //Connect to the server
                bot.startBot();
        }
}