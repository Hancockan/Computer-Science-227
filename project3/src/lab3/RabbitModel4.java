package lab3;

import java.util.Random;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */

public class RabbitModel4
{
  // TODO - add instance variables as needed
  /**
   * instance variable for size of the population
   */
  private int popSize;
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel4()
  {
    // TODO
	  popSize = 0;
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    // TODO - returns a dummy value so code will compile
    return popSize;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
    // TODO
	  Random rand = new Random();
	  popSize = popSize + rand.nextInt(11);
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    // TODO
	  popSize = 0;
  }
}