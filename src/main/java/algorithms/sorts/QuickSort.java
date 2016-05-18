package algorithms.sorts;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class QuickSort {
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled) {
		return sort(shuffled, new Order<T>().ASC);
	}

	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled,
			BiFunction<Comparable<? super T>, T, Boolean> order) {
		return quickSort(shuffled, 0, shuffled.size() - 1, order);
	}

	private <T extends Comparable<? super T>> List<T> quickSort(List<T> shuffled, Integer start, Integer end,
			BiFunction<Comparable<? super T>, T, Boolean> order) {
		if (start < end) {
			Integer pivot = this.partition(shuffled, start, end, order);
			this.quickSort(shuffled, start, pivot - 1, order);
			this.quickSort(shuffled, pivot + 1, end, order);
		}
		return shuffled;
	}

	private <T extends Comparable<? super T>> Integer partition(List<T> shuffled, Integer start, Integer end,
			BiFunction<Comparable<? super T>, T, Boolean> order) {
		T pivot = shuffled.get(end);
		Integer p = start - 1;

		for (int j = start; j < end; j++) {
			if (order.apply(pivot, shuffled.get(j))) {
				p += 1;
				Collections.swap(shuffled, p, j);
			}
		}
		Collections.swap(shuffled, p + 1, end);
		return p + 1;
	}
}
