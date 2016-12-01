package november2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class IOProject {
	
	/*private void loadGames(){
		try{
			Scanner inFile = new Scanner(new FileReader("games.txt"));
			while (inFile.hasNext()){
				String line = inFile.next();				
				int x = line.indexOf("|");						
				String hint = line.substring(0, x);
				String ans = line.substring(x+1, line.length());
				System.out.println(hint);
				System.out.println(ans);				
			}
			inFile.close();
		}catch (FileNotFoundException e){			
			e.printStackTrace();
		}
	}*/
	//List hero builds
	private void hots(){
	try{
		Scanner inHoTS = new Scanner(new FileReader("hots.txt"));
		while(inHoTS.hasNext()){
			String line = inHoTS.next();
			int x = line.indexOf("|");			
			String hero = line.substring(0, x);
			String build = line.substring(x+1, line.length());
			//String altBuild = line.substring(")something");
			System.out.println(hero);
			System.out.println(build);
			//System.out.println(altBuild);
		}inHoTS.close();
	}catch(FileNotFoundException e) {
		e.printStackTrace();}
	}
	public void writeFile(){
		BufferedWriter out = null;
		try{
			FileWriter fstream = new FileWriter("games.txt");
			out = new BufferedWriter(fstream);
			//out.write();			
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] arg){
		IOProject iop = new IOProject();
		iop.writeFile();
		//iop.loadGames();
		iop.hots();
	}

}
