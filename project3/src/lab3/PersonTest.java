package lab3;

public class PersonTest {

	public static void main(String[] args){
		Person A = new Person("Andrew", 19);
		System.out.println("Name: " + A.getName() + "\nAge:" + A.getAge());
		System.out.println("Length of name: " + A.getName().length());
	}
	
}
