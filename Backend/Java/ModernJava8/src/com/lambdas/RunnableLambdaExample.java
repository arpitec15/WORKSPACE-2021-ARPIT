package com.lambdas;

import java.util.Comparator;
import java.util.function.Consumer;

public class RunnableLambdaExample {

	public static void main(String[] args) {

		Runnable runnableLambda = () -> {
			System.out.println("in Lambda");
		};
		new Thread(runnableLambda).start();

//		Comparator
//		Before Java 8
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}

		};

		System.out.println("Before Java 8 : Comparison : " + comparator.compare(3, 2));

//		After Java 8
		Comparator<Integer> compLambda = (a, b) -> {
			return a.compareTo(b);
		};

		System.out.println("After Java 8 : Comparison : " + compLambda.compare(3, 2));
	}

}
