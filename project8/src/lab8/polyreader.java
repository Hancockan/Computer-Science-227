package lab8;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import plotter.Plotter;
import plotter.Polyline;

public class polyreader {

	public static void main(String[] args) throws FileNotFoundException{
		
		ArrayList<Polyline> lines = readFile();
		
		Plotter p = new Plotter();
		
		for(int i = 0;i < lines.size();i++){
			p.plot(lines.get(i));
		}
		
	}
	
	public static ArrayList<Polyline> readFile() throws FileNotFoundException{
		
		ArrayList<Polyline> p = new ArrayList<Polyline>();
		
		File file = new File("hello.txt");
		Scanner input2 = new Scanner(file);
		
		String line;
		while(input2.hasNextLine()){
			line = input2.nextLine().trim();
			if(line.length() >= 1){
				if(line.substring(0, 1).compareTo("#") == 0){
					continue;
				}else{
					p.add(lineReader(line));
				}
			}else{
				continue;
			}
		}
		input2.close();
		
		return p;
	}
	
	public static Polyline lineReader(String line){
		Scanner input = new Scanner(line);
		
		int width = 1;
		String color;
		
		if(input.hasNextInt()){
			width = input.nextInt();
		}
		
		color = input.next();
		
		//construct new line to be returned
		System.out.println("The color is: " + color);
		System.out.println("The width is: " + width);
		Polyline p1 = new Polyline(color, width);
		
		while(input.hasNextInt()){
			int point1 = input.nextInt();
			int point2 = input.nextInt();
			p1.addPoint(new Point(point1, point2));
		}
		input.close();
		return p1;
	}
	
}
