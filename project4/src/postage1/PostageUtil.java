package postage1;
    public class PostageUtil
    {
      /**
       * Returns the cost of postage for a letter of the given weight.
       * @param weight
       *   given weight in ounces
       * @return
       *   cost of postage for the weight
       */
      public static double computePostage(double weight)
      {
        double cost = 0.0;
        
        if(weight <= 1.00){
        	cost = 0.47;
        }else{
        	if(weight <= 3.50){
        		cost = 0.47 + (Math.ceil(weight - 1.00) * 0.21);
        	}else{
        		cost = 0.94 + (Math.ceil(weight - 1.00) * 0.21);
        	}
        }        
        return cost; 
        }
    }