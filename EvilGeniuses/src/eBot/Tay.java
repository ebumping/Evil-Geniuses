package eBot;
import org.jibble.pircbot.*;

public class Tay extends PircBot{
	private static final String channelName = "#ebumping";													
	private final String botName = "bumpingbot";
	
	public Tay(){
		this.setName(botName);
		this.setLogin(botName);
	}
	public String getchannelName(){
		return channelName;
	}
	
	@Override
	public void onMessage(String channel, String sender,
			String login, String hostname, String message){
		if (message.equalsIgnoreCase("time")){
			String time = new java.util.Date().toString();
			sendMessage(channel, sender + ": The time is now " + time);
		}
	}
	
	@Override
	protected void onConnect(){
		System.out.println("Success!");
		joinChannel(channelName);
		
		super.onConnect();
		sendMessage(getchannelName(), "Hello I am a bot");
	}

	
	

}
