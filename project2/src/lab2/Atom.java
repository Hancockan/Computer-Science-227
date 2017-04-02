package lab2;
/**
 * Model of an atom
 */
public class Atom {
	/**
    * number of neutrons in the atom
    **/
	private int neutrons;
	/**
	* number of electrons in the atom
	**/
	private int electrons;
	/**
	* number of protons in the atom
	**/
	private int protons;
	  /**
	   * constructs an atom with the given amount of protons, neutrons, and electrons
	   * @param givenProtons
	   * the given amount of protons
	   * @param givenNeutrons
	   * the given amount of neutrons
	   * @param givenElectrons
	   * the given amount of electrons
	   */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons){
		/**
		 * sets the number of protons for the atom equal to the number of protons given 
		 */
		protons = givenProtons;
		/**
		 * set the number of neutrons for the atom equal to the number of neutrons given
		 */
		neutrons = givenNeutrons;
		/**
		 * set the number of electrons for the atom equal to the number of electrons given
		 */
		electrons = givenElectrons;
		
	}
	/**
	 * returns the number of protons and neutrons equaling the atomic mass
	 */
	public int getAtomicMass(){
		/**
		 * @return protons and neutrons
		 */
		return (protons + neutrons);
		
	}
	/**
	 * returns the number of protons minus electrons equaling the atomic charge
	 */
	public int getAtomicCharge(){
		/**
		 * @return protons minus electrons
		 */
		return (protons - electrons);
		
	}
	/**
	 * decrements protons and neutrons by 2 for decay
	 */
	public void decay(){
		/**
		 * protons minus 2
		 */
		protons-=2;
		/**
		 * neutrons minus 2
		 */
		neutrons-=2;
		
	}
	
}
