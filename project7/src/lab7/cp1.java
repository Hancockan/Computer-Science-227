package lab7;

import java.util.Arrays;
import java.util.Random;

public class cp1 {

	public static void main(String[] args){
		int[] nums = {9,-4,3,0,9,-56,34};
		int[] posNums = getPositiveNumbers(nums);
		System.out.println("Array with all numbers: " + Arrays.toString(nums));
		System.out.println("Array with positive numbers: " + Arrays.toString(posNums));
		
		int[] frequency = randomExperiment(10, 1000);
		System.out.println("Random experiment array: " + Arrays.toString(frequency));
	}
	
	public static int[] getPositiveNumbers(int[] numbers){
		
		//first counts positive integers
		int posNums = 0;
		for(int i = 0; i < numbers.length;i++){
			if(numbers[i] > 0){
				posNums++;
			}
		}
		
		//create new array for positive numbers
		int[] positive = new int[posNums];
		
		//go through and assign positive numbers to new array
		int index = 0;
		for(int i = 0; i < numbers.length;i++){
			if(numbers[i] > 0){
				positive[index] = numbers[i];
				index++;
			}
		}
		
		return positive;
	}
	
	public static int[] randomExperiment(int max, int iters){
		
		//random to use
		Random rand = new Random();
		
		//generate a new array of length iters and nums 0 to max
		int[] a = new int[iters];
		for(int i = 0;i < iters;i++){
			a[i] = rand.nextInt(max);
		}
		
		//new array of length max because values with be 0 to max - 1
		int[] b = new int[max];
		
		//for loop going through all of the possible value and counting them
		for(int i = 0;i < max;i++){
			//keep track of number of times value appears
			int occurences = 0;
			
			//check for value appearances 
			for(int w = 0; w < a.length;w++){
				if(a[w] == i){
					occurences++;
				}
			}
			//set value at correct index of array
			b[i] = occurences;
		}
		
		return b;
	}
	
}
