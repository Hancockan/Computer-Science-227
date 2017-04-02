package lab5;

public class Basketball{
	
  private double diameter;
  private boolean inflated;
	
  public Basketball(double givenDiameter)
  {
	  diameter = givenDiameter;
	  inflated = false;
  }

  public boolean isDribbleable()
  {
    if(inflated == true){
    	return true;
    }else{
    	return false;
    }
  }

  public double getDiameter()
  {
    return diameter;
  }

  public double getCircumference()
  {
    return (Math.PI * diameter);
  }

  public void inflate()
  {
	  inflated = true;
  }
}