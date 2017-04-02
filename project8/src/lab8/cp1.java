package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cp1 {

	public static void main(String[] args) throws FileNotFoundException{
		wordNumberer();
	}
	
	public static void wordNumberer() throws FileNotFoundException{
		File file = new File("story.txt");
		
		//counting variable 
		
		
		//scanner for file
		Scanner input = new Scanner(file);
		
		while(input.hasNextLine()){
			String line = input.nextLine().trim();
			
			String[] words = line.split(" ");
			System.out.println("There are: " + words.length + " words in the line.");
			
		}
		input.close();
		
	}
	
}
