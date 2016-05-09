package algorithms.sorts;

import java.util.List;

public class InsertionSort {
	public static final Integer ASC = 1;
	public static final Integer DESC = -1;

	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled) {
		if (shuffled.isEmpty())
			return shuffled;
		T head = shuffled.remove(0);

		return recursiveSort(head, sort(shuffled), InsertionSort.ASC);
	}

	private <T extends Comparable<? super T>> List<T> recursiveSort(T element, List<T> shuffled, Integer order) {
		if (shuffled.isEmpty()) {
			shuffled.add(0, element);
			return shuffled;
		}

		if (order.equals(InsertionSort.DESC)) {
			if (shuffled.get(0).compareTo(element) < 0) {
				shuffled.add(0, element);
				return shuffled;
			}
		} else if (order.equals(InsertionSort.ASC)) {
			if (element.compareTo(shuffled.get(0)) < 0) {
				shuffled.add(0, element);
				return shuffled;
			}
		}
		T head = shuffled.remove(0);

		recursiveSort(element, shuffled, order);

		shuffled.add(0, head);
		return shuffled;
	}

	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled, Integer order) {
		if (shuffled.isEmpty())
			return shuffled;
		T head = shuffled.remove(0);

		return recursiveSort(head, sort(shuffled, order), order);
	}

}
