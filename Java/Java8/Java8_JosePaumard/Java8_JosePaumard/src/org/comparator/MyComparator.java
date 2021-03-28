package org.comparator;

import java.util.Comparator;
import java.util.function.Function;

@FunctionalInterface
public interface MyComparator<T> extends Comparator<T> {

//	public int compare(T t1, T t2);

	public static <U> MyComparator<U> comparing(Function<U, Comparable> f) {
		return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
	}

	public default MyComparator<T> thenMyComparing(Comparator<T> cmp) {
		return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
	}

	public default MyComparator<T> thenMyComparing(Function<T, Comparable> f) {
		return thenMyComparing(comparing(f));
	}

}
