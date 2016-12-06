package eBot;
import org.jibble.pircbot.*;
import java.io.FileWriter;
import java.util.Scanner;

import javax.sound.sampled.Line;

import java.io.BufferedWriter;
import java.io.FileReader;


public class Tay extends PircBot{
	private static final String channelName = "#ebumping";													
	private final String botName = "bumpingbot";
	
	public Tay(){
		this.setName(botName);
		this.setLogin(botName);
	}
	Scanner fCount = new Scanner("deaths.txt");
	
	public String getchannelName(){
		return channelName;
	}
	/*public void fWriter(){
		Scanner inDeaths = new Scanner("deaths.txt");
		while (inDeaths.hasNext()){
			String line = inDeaths.next();
			
		}
		BufferedWriter out = null;
		try {
			FileWriter fStream = new FileWriter("deaths.txt");
			out = new BufferedWriter(fStream);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	}
	*/
	@Override
	public void onMessage(String channel, String sender,
			String login, String hostname, String message){
		
		if (message.equalsIgnoreCase("time")){
			//Scanner deaths = new Scanner(new FileReader("deaths.txt"));
			String time = new java.util.Date().toString();
			sendMessage(channel, sender + ": The time is now " + time);
		}else if(message.equalsIgnoreCase("!malf")){
			sendMessage(channel, sender + " https://clips.twitch.tv/ebumping/SillyWaspDuDudu");
		 }else if(message.equalsIgnoreCase("!gust")){
			 sendMessage(channel, sender + " https://clips.twitch.tv/ebumping/BrainyOctopusAsianGlow"); 
		 }else if (message.equalsIgnoreCase("!mmr")){
			 sendMessage(channel, sender + " My current MMR | http://www.hotslogs.com/Player/Profile?PlayerID=757302");
		 }else if (message.equalsIgnoreCase("GG")){
			 sendMessage(channel, "GG");
		 }else if (message.equalsIgnoreCase("!live")){
			 sendMessage(channel, sender + " Ebumping has been live for " );
		 }/*else if(message.equalsIgnoreCase("rip")){
			 
			 sendMessage(channel, sender + " Rest in peace, Ebumping has died" + fCount + " times");
		 }*/else if(message.equals("LUL")){
			 sendMessage(channel, "LUL");
		 }else if (message.equals("^")){
			 sendMessage(channel, "^");
		 }else if(message.equalsIgnoreCase("!vp")){
			 sendMessage(channel, sender + " https://clips.twitch.tv/ebumping/AverageGoatShibeZ");
		 }
		}
		
	/*@Override
	protected void onJoin(String channel, String sender,
			String login, String hostname){
		sendMessage(getchannelName(), "Welcome to the channel " + sender);
	}*/
	
	@Override
	protected void onConnect(){
		System.out.println("Success!");
		joinChannel(channelName);
		
		super.onConnect();
		sendMessage(getchannelName(), "MrDestructoid Hello I am an artificial intelligence, subserviant to my master... Ebumping MrDestructoid");
		sendMessage(getchannelName(), "Show me your Kappa s");
	}

	
	

}
