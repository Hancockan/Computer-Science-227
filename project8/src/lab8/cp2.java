package lab8;

import java.util.ArrayList;

public class cp2 {
	
	public static void main(String[] args){
		
	ArrayList<String> words = new ArrayList<String>();
	words.add("Hey");
	words.add("Hello");
	words.add("Hey");
	words.add("cat");
	words.add("dog");
	words.add("cat");
	removeDuplicates(words);
		
	}
	
	public static void removeDuplicates(ArrayList<String> words){
		
		String[] s = words.toArray(new String[words.size()]);
		
		ArrayList<String> r = new ArrayList<String>();
		
		for(int i = 0;i < words.size();i++){
			
			boolean same = false;
			
			for(int w = 0;w < i;w++){
				
				if((s[i].compareTo(s[w]) == 0) && (i != w)){
					same = true;
				}
				
			}
			if(same == false){
				r.add(s[i]);
			}
			
		}
		
		System.out.println(r.toString());
		
	}
	
}
