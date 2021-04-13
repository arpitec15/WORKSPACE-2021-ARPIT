package arrays.educative;

public class SmallestCommonNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {6,7,10,25,30,63,64};
		int[] arr2 = {1,4,5,6,7,8,50};
		int[] arr3 = {1,6,10,14};
		Integer findLeastCommonNumber = findLeastCommonNumber(arr1, arr2, arr3);
		System.out.println(findLeastCommonNumber.intValue());
	}

	static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
		// TODO: Write - Your - Code
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length && k < arr3.length) {
			
			if(arr1[i] == arr2[j] && arr2[j] == arr3[k])
				return arr1[i];
			
			
			if(arr1[i]  > arr2[j]) {
				++j;				
			}
			else
				++i;
			
			if(arr1[i] > arr3[k]) {
				++k;
			}
			else if(arr1[i] != arr3[k])
				++i;
			
		}
		return -1;
	}

}
