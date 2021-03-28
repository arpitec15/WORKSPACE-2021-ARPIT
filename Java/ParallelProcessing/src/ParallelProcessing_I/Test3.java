package ParallelProcessing_I;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test3 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(4, 2);

		Optional<Integer> reduce = list.stream().reduce(Integer::sum);
//		System.out.println(reduce);

//		Sum s = (a,b) -> {
//			return a+b;
//		};
//		
//		System.out.println(s.add(3, 5));

//		3 kinds of TV, one is Samsung, Sony, MI
//								5k  , 10k , 3k

		TV samsung = new TV("Samsung ", 5000);
		TV sony = new TV("Sony ", 10000);
		TV mi = new TV("MI ", 3000);

		List<TV> tvList = Arrays.asList(samsung, sony, mi);

		Optional<Integer> maxPrice = tvList.stream().map(p -> p.getPrice()).reduce(Integer::max);
		Optional<Integer> minPrice = tvList.stream().map(p -> p.getPrice()).reduce(Integer::min);

		System.out.println("max Price " + maxPrice);
		System.out.println("min Price " + minPrice);

	}

}
