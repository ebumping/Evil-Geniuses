package eBot;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.cap.EnableCapHandler;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.events.TimeEvent;
import org.pircbotx.hooks.events.UserListEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class TayX extends ListenerAdapter {
	private static final String OAUTH = "oauth:eowkoscj18s4sjcpkhy0x0ay7kqy3z";
	private static final String address = "irc.chat.twitch.tv";
	private static final String channelName = "#ebumping";
	//private Users userlist;
	
	String time = new java.util.Date().toString();
	//private static int port = 6667;
	//List <Users> users = new ArrayList<Users>();
	
		@Override
		public void onTime(TimeEvent event) throws Exception {
			BufferedWriter out = null;
			super.onTime(event);
			event.getTimestamp();
		}
		
		@Override
		public void onUserList(UserListEvent event) throws Exception {
			//userlist = new Users();
			//BufferedWriter usr = null;
			super.onUserList(event);
			event.getUsers().asList();
		
		}
        @Override
        public void onGenericMessage(GenericMessageEvent event) {
                //When someone says ?helloworld respond with "Hello World"
                /*if (event.getMessage().startsWith("?helloworld")){
                    event.respond("Hello world!");
                }else if (event.getMessage().startsWith("!time")){
                	String time = new java.util.Date().toString();
                	event.respond( " : The time is now " + time);
                }else if (event.getMessage().startsWith("!malf")){
                	event.respond(" : https://clips.twitch.tv/ebumping/SillyWaspDuDudu");	
                }else if (event.getMessage().startsWith("!gust")){
                	event.respond(" : https://clips.twitch.tv/ebumping/BrainyOctopusAsianGlow");	
                }else if (event.getMessage().startsWith("!mmr")){
                	event.respond(" : My current MMR | http://www.hotslogs.com/Player/Profile?PlayerID=757302");
                }else if (event.getMessage().equalsIgnoreCase("gg")){
                	event.respondWith("gg");
                }else if (event.getMessage().equals("LUL")){
                	event.respondWith("LUL");
                }else if (event.getMessage().equals("^")){
                	event.respondWith("^");
                }else if (event.getMessage().equals("!tay")){
                	event.respondWith(" MrDestructoid Hello I am an artificial intelligence, subserviant to my master... Ebumping MrDestructoid");
                	event.respondWith("Chat.....Show me your Kappa s");
                }else if (event.getMessage().startsWith("!live")){
                	//event.
                	//use this to show time live
                }*/
        }
        @Override
        public void onConnect(ConnectEvent event){
        	/*BufferedWriter out = null;
        	event.respond(time);
        	try {
				FileWriter tLive = new FileWriter("data.txt");
				out = new BufferedWriter(tLive);
				out.write(time);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} */
        }
       
        public static void main(String[] args) throws Exception {
                //Configure what we want our bot to do
                Configuration configuration = new Configuration.Builder()
                		.setAutoNickChange(false) //Twitch doesn't support multiple users
                	    .setOnJoinWhoEnabled(false) //Twitch doesn't support WHO command
                	    .setCapEnabled(true)
                	    .addCapHandler(new EnableCapHandler("twitch.tv/membership")) //Twitch by default doesn't send JOIN, PART, and NAMES unless you request it
                	    		//Without these responses the channel will confusingly only have 1 user, the bot itself
                	    .addServer(address)
                	    .setName("taybumping") //The bots twitch.tv username
                	    .setServerPassword(OAUTH) //This is the password
                	    .addAutoJoinChannel(channelName) //joins twitch channel
                                .addListener(new MyListener()) //Add our listener that will be called on Events
                                .buildConfiguration();

                //Create our bot with the configuration
                PircBotX tay = new PircBotX(configuration);
                //Connect to the server
                tay.startBot();
        }
}

