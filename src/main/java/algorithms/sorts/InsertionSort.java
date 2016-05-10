package algorithms.sorts;

import java.util.List;
import java.util.function.BiFunction;

public class InsertionSort {
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled) {
		return sort(shuffled, new Order<T>().ASC);
	}

	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled,
			BiFunction<Comparable<? super T>, T, Boolean> order) {
		int length = shuffled.size();
		for (int j = 1; j < length; j++) {
			T key = shuffled.get(j);
			int i = j - 1;
			while ((i >= 0) && order.apply(shuffled.get(i), key)) {
				shuffled.set(i + 1, shuffled.get(i));
				i--;
			}
			shuffled.set(i + 1, key);
		}
		return shuffled;
	}

}
