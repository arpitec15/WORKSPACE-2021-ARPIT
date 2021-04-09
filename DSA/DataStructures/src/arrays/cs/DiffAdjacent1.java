package arrays.cs;

public class DiffAdjacent1 {

	public static void main(String[] args) {
		int arr1[] = {70,60,70,80,90,110,130};
	    int arr2[] = {2, 3, 2, 4, 5, 6, 7};
	  
	    System.out.println(findFirstOccurrenceIfAdjecentValueDifferByK(arr1, 130,20));
//	    System.out.println(findFirstOccurrenceIfAdjecentValueDifferBy1(arr2, 2));
	}

	private static int findFirstOccurrenceIfAdjecentValueDifferByK(int[] arr, int val, int k) {
		 if (arr.length == 0) {
		      return -1;
		    }

		    int start = 0;

		    while (start < arr.length) {
		      if (arr[start] == val) {
		        return start;
		      }

		      int diff = Math.abs(arr[start] - val);
		      diff = diff/k;
		      start = start + diff;
		    }
		    return -1;
		  }	

}
