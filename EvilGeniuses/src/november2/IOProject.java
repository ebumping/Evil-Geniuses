package november2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class IOProject {
	
	private void loadGames(){
		try{
			Scanner inFile = new Scanner(new FileReader("games.txt"));
			while (inFile.hasNext()){
				String line = inFile.next();
				//System.out.println(line);
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
	}
	public void writeFile(){
		BufferedWriter out = null;
		try{
			FileWriter fstream = new FileWriter("games.txt");
			out = new BufferedWriter(fstream);
			out.write("Nova|Dog");
			out.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] arg){
		IOProject iop = new IOProject();
		iop.writeFile();
		iop.loadGames();
	}

}
