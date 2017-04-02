package lab9;

import java.io.File;
import java.util.ArrayList;

public class FileFinderCP2 {

	
	public static void main(String[] args){
		File file = new File(".");
		
		
		
		System.out.println(findFiles(file).toString());
	}
	
	/**
	 * Returns a list of files beneath the given file or directory.
	 * 
	 * @param file
	 * @return
	 */
	public static ArrayList<String> findFiles(File file) {
		// create an empty array list...
		ArrayList<String> arr = new ArrayList<String>();

		if (!file.isDirectory()) {
			arr.add(file.getName());
		} else {
			// recursively search the subdirectory
			for (int i = 0;i < file.listFiles().length;i++) {
				arr.addAll(findFiles(file.listFiles()[i]));
			}
		}

		// and return the filled-up ArrayList
		return arr;
	}

	/**
	 * Recursive helper method includes an array list as an argument. Filenames
	 * are added to the array list as they are found.
	 * 
	 * @param file
	 * @param list
	 */
	/*
	private static void findFiles(File file, ArrayList<String> list) {
		if (!file.isDirectory()) {
			list.add(file.getName());
		} else {
			// recursively search the subdirectory
			for (File f : file.listFiles()) {
				findFiles(f, list);
			}
		}
	}
	*/

}
