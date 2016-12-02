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
		}else if(message.equalsIgnoreCase("malf")){
			sendMessage(channel, sender + " https://clips.twitch.tv/ebumping/SillyWaspDuDudu");
		 }else if(message.equalsIgnoreCase("gust")){
			 sendMessage(channel, sender + " https://clips.twitch.tv/ebumping/BrainyOctopusAsianGlow"); 
		 }else if (message.equalsIgnoreCase("mmr")){
			 sendMessage(channel, sender + " My current MMR | http://www.hotslogs.com/Player/Profile?PlayerID=757302");
		 }
		}
		
	
	
	@Override
	protected void onConnect(){
		System.out.println("Success!");
		joinChannel(channelName);
		
		super.onConnect();
		sendMessage(getchannelName(), "MrDestructoid Hello I am an artificial intelligence, subserviant to my master... Ebumping MrDestructoid");
		sendMessage(getchannelName(), "Show me your Kappa s");
	}

	
	

}
