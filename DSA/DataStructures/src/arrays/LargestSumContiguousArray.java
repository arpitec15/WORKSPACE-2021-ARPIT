package arrays;

public class LargestSumContiguousArray {

	public static void main(String[] args) {

		int a[] = {-2,-3,4,-1,-2,1,5,-3};
		int meh=0;
		int msf=Integer.MIN_VALUE;
		
		for (int i : a) {
			meh = meh + i;
			
			if(meh < i) {
				meh = i;
			}
			
			if(msf<meh) {
				msf=meh;
			}
			
		}
		
		System.out.println("Maximum sum is = " + msf);
		
		
	}

}
