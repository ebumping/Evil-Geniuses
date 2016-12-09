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
		}
		
		@Override
		public void onUserList(UserListEvent event) throws Exception {
		}
        @Override
        public void onGenericMessage(GenericMessageEvent event) {
        }
        @Override
        public void onConnect(ConnectEvent event){
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

