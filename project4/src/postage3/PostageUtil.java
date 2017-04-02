package postage3;

import java.util.Scanner;

public class PostageUtil
    {
      
      public static void main(String[] args){
    	  @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
    	  System.out.print("Enter a weight: ");
    	  double weight = input.nextDouble();
    	  double price = computePostage(weight);
    	  System.out.printf("Weight: " + weight + " Price: %1.2f", price);
      }
    	
      public static double computePostage(double weight)
      {
        double cost = 0.0;
        
        cost = 0.47;
        
        if(weight > 1){
        	cost = cost + (Math.ceil(weight - 1.00) * 0.21);
        }
        
        if(weight > 3.5){
        	cost = cost + 0.47;
        }
        
        return cost; 
        }
    }