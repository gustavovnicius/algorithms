package algorithms.sorts;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class InsertionSort {
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled) {
		if (shuffled.isEmpty())
			return shuffled;
		T head = shuffled.remove(0);

		return recursiveSort(head, sort(shuffled), Order.ASC);
	}

	private <T extends Comparable<? super T>> List<T> recursiveSort(T element, List<T> shuffled, BiFunction order) {
		if (shuffled.isEmpty()) {
			shuffled.add(0, element);
			return shuffled;
		}

		if ((boolean) order.apply(shuffled.get(0), element)) {
			shuffled.add(0, element);
			return shuffled;
		}

		T head = shuffled.remove(0);

		recursiveSort(element, shuffled, order);

		shuffled.add(0, head);
		return shuffled;
	}

	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled, BiFunction order) {
		if (shuffled.isEmpty())
			return shuffled;
		T head = shuffled.remove(0);

		return recursiveSort(head, sort(shuffled, order), order);
	}

}
