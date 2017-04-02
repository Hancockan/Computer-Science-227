package lab9;

import java.io.File;

public class cp2 {

	public static void main(String[] args){
		File file = new File("F:/");
		System.out.println("File count: " + fileCounter(file));
	}
	
	public static int fileCounter(File file){
		if(!file.isDirectory()){
			return 1;
		}else{
			//create an array with all the subfiles and then go through them and count
			File[] files = file.listFiles();
			int totalCount = 0;
			for(int i = 0;i < files.length;i++){
				totalCount += fileCounter(files[i]);
			}
			return totalCount;
		}
	}
	
}
