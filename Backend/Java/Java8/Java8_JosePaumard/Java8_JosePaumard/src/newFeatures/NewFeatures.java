package newFeatures;

import java.util.HashMap;
import java.util.function.BiFunction;

public class NewFeatures {

	public static void main(String[] args) {

		HashMap<Integer, String> hm = new HashMap<>();

		hm.put(1, "Arpit");
		hm.put(2, "Himi");
		hm.putIfAbsent(3, "Govind");
//		hm.replace(1, "Raj");
		hm.replace(1, "Raj", "RK");
		hm.compute(2, (k, v) -> v.concat("!!"));
		hm.computeIfAbsent(4, v -> "Hello");
		hm.forEach((k, v) -> System.out.println("Key is " + k + " Value is " + v));

		HashMap<Integer, String> hm2 = new HashMap<>();
		hm2.put(5, "Ghaziabad");
		hm2.put(6, "Lucknow");

		hm.forEach((k, v) -> hm2.merge(k, v, (valueFromMap1, valueFromMap2) -> {
			valueFromMap1.concat(valueFromMap2);
			return valueFromMap1;
		}

		));
		System.out.println();
		hm.forEach((k, v) -> System.out.println("HM 1 Key is " + k + " Value is " + v));
		System.out.println();
		hm2.forEach((k, v) -> System.out.println("HM 2 Key is " + k + " Value is " + v));

	}

}
