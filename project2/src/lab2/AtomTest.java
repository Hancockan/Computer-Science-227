package lab2;

public class AtomTest {

	public static void main(String[] args){
		
		Atom Uranium238 = new Atom(92, 146, 92);
		System.out.println(Uranium238.getAtomicMass());
		System.out.println(Uranium238.getAtomicCharge());
		Uranium238.decay();
		System.out.println(Uranium238.getAtomicMass());
		System.out.println(Uranium238.getAtomicCharge());
	}
	
}
