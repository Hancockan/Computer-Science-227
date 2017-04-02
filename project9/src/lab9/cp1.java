package lab9;

public class cp1 {

	public static void main(String[] args){
		int[] arr = {20,1 ,2 ,3 ,10 ,4 ,5 ,6 ,7 ,8 ,9,15};
		
		System.out.println("Largest integer in array: " + maxInArray(arr,0,arr.length - 1));
		
		
		System.out.println("Total balls in pyramid: " + pyramidBalls(6));
	}
	
	public static int maxInArray(int[] array, int start, int end){
		
		//return the value in the array if its an array of one int
		if(start == end){
			return array[start];
		}else{
			//this is where the array will be divided
			int mid = (start + end)/2;
			int largest = Math.max(maxInArray(array,start,mid), maxInArray(array, mid + 1, end));
			return largest;
		}
		
	}
	
	public static int pyramidBalls(int n){
		
		//recursive case
		if(n == 1){
			return 1;
		}else{
			int volume = (n * n) + pyramidBalls(n - 1);
			return volume;
		}
		
	}
	
}
