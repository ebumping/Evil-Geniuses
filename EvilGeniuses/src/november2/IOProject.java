package november2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class IOProject {
	
	private void loadGames(){
		try{
			Scanner inFile = new Scanner(new FileReader("games.txt"));
			while (inFile.hasNext()){
				String line = inFile.next();
				System.out.println(line);
				int x = line.indexOf("|");						
				String hint = line.substring(0, x);
				
				//Game g = new Game(hint, word);
				System.out.println(hint);
				
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] arg){
		IOProject iop = new IOProject();
		iop.loadGames();
	}

}
