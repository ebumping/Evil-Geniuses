package november2;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class IOAssignment {
	private void loadGames() throws FileNotFoundException{
		Scanner inFile = new Scanner(new FileReader("games.txt"));
		
		while(inFile.hasNext()){
			String line = inFile.next();
			System.out.println(line);
			
			int x = line.indexOf("|");
			String hint = line.substring(0, x);
			System.out.println(hint);
			
			String remainderOfLine = line.substring(x +1, line.length());
			int nextPipe = remainderOfLine.indexOf("|");
			String word = remainderOfLine.substring(0, nextPipe);
			System.out.println(word);
			
			remainderOfLine = remainderOfLine.substring(nextPipe, remainderOfLine.length());
			
		}
		inFile.close();
	}
	
	
	
	//getNextToken(String remainder) recursion
	public static void main(String[] args) throws FileNotFoundException{
		IOAssignment ioa = new IOAssignment();
		ioa.loadGames();
	}

}
