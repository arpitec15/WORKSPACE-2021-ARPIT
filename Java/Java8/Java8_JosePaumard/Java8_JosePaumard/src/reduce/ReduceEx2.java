package reduce;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceEx2 {

	public static void main(String[] args) {

		int max = -88;

		List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
		List<Integer> list2 = Arrays.asList(0, 1, 2, 3);
		List<Integer> list3 = Arrays.asList(4, 5, 6, 7);
		List<Integer> list4 = Arrays.asList(-4, -5, -6, -7);

		BinaryOperator<Integer> add = Integer::sum;

		BinaryOperator<Integer> op = Integer::max;

		for (int i : list1) {
			max = op.apply(max, i);
		}

		int reduction = reduce(list1, 0, add);
		int reduction1 = reduce(list2, 0, op);
		int reduction2 = reduce(list3, 0, op);

		
		Integer maxVal = list4.stream().reduce(op).get();
		
		System.out.println("Max value is "  + maxVal);

//		System.out.println("Max of list 1 -> " + reduction1);
//		System.out.println("Max of list 2 -> " + reduction2);
		
//		System.out.println("Sum is " + reduction);
//		System.out.println("Max is " + max);

	}

	private static int reduce(List<Integer> list1, int defaultValue, BinaryOperator<Integer> addition) {
		// TODO Auto-generated method stub
		int result = defaultValue;
		for (int value : list1) {
			result = addition.apply(result, value);
//			result = addition.apply(result, value);
		}
		return result;
	}
}
