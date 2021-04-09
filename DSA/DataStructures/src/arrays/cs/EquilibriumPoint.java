package arrays.cs;

//Find Equilibrium point where elements before & after it has equal sum

public class EquilibriumPoint {

	public static void main(String[] args) {
		
		int a[]	= {1,6,9,0,7};
		int sum = 0;
		int sum_so_far = 0;
		
		for (int i : a) {
			sum = sum +i;
			
		}
		
		for(int i = 0; i< a.length; i++) {
			
			sum=sum-a[i];
			if(i>0) {
				sum_so_far = sum_so_far + a[i-1];
			}
			
			if (sum == sum_so_far) {
				System.out.println("Equilibrim point is " + i + " Element is " + a[i]); 
			}
		}
		
		

	}

}
