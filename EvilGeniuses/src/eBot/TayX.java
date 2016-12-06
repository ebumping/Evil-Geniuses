package eBot;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.cap.EnableCapHandler;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class TayX extends ListenerAdapter {
	private static final String OAUTH = "oauth:eowkoscj18s4sjcpkhy0x0ay7kqy3z";
	private static final String address = "irc.chat.twitch.tv";
	//private static int port = 6667;
        @Override
        public void onGenericMessage(GenericMessageEvent event) {
                //When someone says ?helloworld respond with "Hello World"
                if (event.getMessage().startsWith("?helloworld"))
                        event.respond("Hello world!");
        }

        public static void main(String[] args) throws Exception {
                //Configure what we want our bot to do
                Configuration configuration = new Configuration.Builder()
                		.setAutoNickChange(false) //Twitch doesn't support multiple users
                	    .setOnJoinWhoEnabled(false) //Twitch doesn't support WHO command
                	    .setCapEnabled(true)
                	    .addCapHandler(new EnableCapHandler("twitch.tv/membership")) //Twitch by default doesn't send JOIN, PART, and NAMES unless you request it
                	    .addServer(address)
                	    .setName("taybumping") //Your twitch.tv username
                	    .setServerPassword(OAUTH) //This is the password
                	    .addAutoJoinChannel("#ebumping") //joins twitch channel
                                .addListener(new MyListener()) //Add our listener that will be called on Events
                                .buildConfiguration();

                //Create our bot with the configuration
                PircBotX tay = new PircBotX(configuration);
                //Connect to the server
                tay.startBot();
        }
}

