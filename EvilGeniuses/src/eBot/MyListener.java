package eBot;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.Event;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.pircbotx.hooks.events.TimeEvent;
import org.pircbotx.hooks.events.UserListEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class MyListener extends ListenerAdapter {
	private Users userlist;
;
	
	
		@Override
		public void onTime(TimeEvent event) throws Exception {
			//BufferedWriter out = null;
			super.onTime(event);
			
		}
		
		@Override
		public void onUserList(UserListEvent event) throws Exception {

			//BufferedWriter usr = null;
			super.onUserList(event);
			event.getUsers().asList();
			
//append
			
			
		}
		@Override
		public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
			userlist = new Users();
			super.onPrivateMessage(event);
			if(event.getUser().getNick().equals("ebumping") && event.getMessage().startsWith("!users")){

				event.respondPrivateMessage("");
				
				
			}
		}
        @Override
        public void onGenericMessage(GenericMessageEvent event) {
                //When someone says one of these respond accordingly
                if (event.getMessage().startsWith("!time")){
                	String time = new java.util.Date().toString();
                	event.respond( " : The time is now " + time);
                }else if (event.getMessage().startsWith("!malf")){
                	event.respond(" : https://clips.twitch.tv/ebumping/SillyWaspDuDudu");	
                }else if (event.getMessage().startsWith("!gust")){
                	event.respond(" : https://clips.twitch.tv/ebumping/BrainyOctopusAsianGlow");	
                }else if (event.getMessage().startsWith("!vp")){
                	event.respond("https://clips.twitch.tv/ebumping/AverageGoatShibeZ");
        		}else if (event.getMessage().startsWith("!mmr")){
                	event.respond(" : My current MMR | http://www.hotslogs.com/Player/Profile?PlayerID=757302");
                }else if (event.getMessage().equalsIgnoreCase("gg")){
                	event.respondWith("gg");
                	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {	
						e.printStackTrace();
					}
                }else if (event.getMessage().equals("LUL")){
                	event.respondWith("LUL");
                	
                }else if (event.getMessage().equals("^")){
                	event.respondWith("^");
                	
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
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
                	//event.
                	//use this to show time live
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        @Override
        public void onEvent(Event event) throws Exception {
        	
        	super.onEvent(event);
        }
        
        @Override
        public void onJoin(JoinEvent event) throws Exception {
			BufferedWriter usrList = null;
			try{
				FileWriter users = new FileWriter("Userlist.txt");
				usrList = new BufferedWriter(users);
				usrList.append(event.getUser().getNick());
				usrList.close();
			}catch (IOException e){
				e.printStackTrace();
			}
			
        	super.onJoin(event);
        	event.respond("Welcome to the channel");
        	Thread.sleep(1000);
        	
        }
        public static void main(String[] args) throws Exception {
                //Configure what we want our bot to do
                Configuration configuration = new Configuration.Builder()
                                .setName("TayX") //Set the nick of the bot.
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