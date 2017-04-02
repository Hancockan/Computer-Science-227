package lab3;

import java.util.Random;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */

@SuppressWarnings("unused")
public class RabbitModel
{
  // TODO - add instance variables as needed
  /**
   * instance variable for size of the population
   */
  private int popSize;
  private int lastYear;
  private int yearBefore;
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel()
  {
    // TODO
	  popSize = 1;
	  lastYear = 1;
	  yearBefore = 0;
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
	popSize =(lastYear + yearBefore);
	yearBefore = lastYear;
	lastYear = popSize;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    // TODO
	  popSize = 1;
  }
}