package lab9;

import java.util.ArrayList;

public class cp2PartTwo {

	public static void main(String[] args){
		Thing one = new Thing("car");
		Thing two = new Thing("dog");
		Thing box1 = new Thing();
		Thing box2 = new Thing();
		
		box1.addThing(one);
		box1.addThing(box2);
		box2.addThing(two);
		
		
		listAllPresents(box2);
		
	}
	
	public static void listAllPresents(Thing thing){
		if(thing.isPresent()){
			System.out.println(thing.getDescription());
		}else{
			ArrayList<Thing> things = thing.getContents();
			
			for(int i = 0;i < things.size();i++){
				listAllPresents(things.get(i));
			}
			
		}
	}
	
}
