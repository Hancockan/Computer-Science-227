package lab6;

public class cp1 {

	public static void main(String[] args){
		System.out.print("The initials are: ");
		System.out.println(Initials("Andrew Alan Hancock"));
		System.out.println("Index of first vowel in cat: " + Vowel("brown cat"));
	}
	
	public static String Initials(String name){		
		String initials = "";
		String[] names = name.split(" ");
		
		for(int i = 0;i < names.length;i++){
			initials = initials + names[i].substring(0, 1);
		}
		return initials;		
	}
	
	public static int Vowel(String text){
		String vowels = "aeiou";
		for(int i = 0;i < text.length();i++){
			for(int t = 0;t < vowels.length();t++){
				if(text.charAt(i) == vowels.charAt(t)){
					return i;
				}
			}
		}
		return -1;
	}
	
}
