package arrays.cs;

public class DiffAdjacentK {

	public static void main(String[] args) {
		int arr1[] = {7, 6, 7, 6, 7, 6, 5, 4, 5, 4, 3, 2, 1, 2, 3};
	    int arr2[] = {2, 3, 2, 4, 5, 6, 7};
	  
	    System.out.println(findFirstOccurrenceIfAdjecentValueDifferBy1(arr1, 2));
//	    System.out.println(findFirstOccurrenceIfAdjecentValueDifferBy1(arr2, 2));
	}

	private static int findFirstOccurrenceIfAdjecentValueDifferBy1(int[] arr, int val) {
		 if (arr.length == 0) {
		      return -1;
		    }

		    int start = 0;

		    while (start < arr.length) {
		      if (arr[start] == val) {
		        return start;
		      }

		      int diff = Math.abs(arr[start] - val);
		      start = start + diff;
		    }
		    return -1;
		  }	

}
