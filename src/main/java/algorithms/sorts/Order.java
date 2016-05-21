package algorithms.sorts;

import java.util.function.BiFunction;

public class Order<T> {
	public BiFunction<Comparable<? super T>, T, Boolean> ASC = (a, b) -> {
		return a.compareTo(b) >= 0;
	};
	public BiFunction<Comparable<? super T>, T, Boolean> DESC = (a, b) -> {
		return a.compareTo(b) < 0;
	};
}
