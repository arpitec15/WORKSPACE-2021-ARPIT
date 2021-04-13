package arrays.educative;

public class NumberOfRotations {

	public static void main(String[] args) {

		int arr[] = { 11, 12, 15, 18, 2, 5, 6, 8 };
		int output = numberOfRotations(arr, 0, arr.length - 1);
		System.out.println("Key is at " + output);
	}

	public static int numberOfRotations(int[] arr, int low, int high) {

		int N = arr.length;
		while (low <= high) {
			
//			Game changer	
//			After reducing search space there might be a case 
//			we will be left with sorted numbers
//			In that case we can't apply rest of the algorithm 
//			so after each iteration we have to check if arr[start] < arr[end] 
//			then return first element of this. 
//			Because arr[start] will be smallest element.
//			-------------------------------------
			 if(arr[low] <= arr[high]){
                 return low;
             }
//			-------------------------------------
			 
			int mid = low + (high - low) / 2;

			int next = (mid + 1) % N;
			int prev = (mid + N - 1) % N;

			if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {

				return mid;

			}

			else if (arr[low] <= arr[mid]) {
				low = mid + 1;
			}

			else if ((arr[mid] <= arr[high])) {

				high = mid - 1;
			}

		}

		return -1;
	}
}
