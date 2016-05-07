package algorithms.sorts;

import java.util.List;

public class InsertionSort {

	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled) {
		if (shuffled.isEmpty())
			return shuffled;
		T head = shuffled.remove(0);

		return recursiveSort(head, sort(shuffled));
	}

	private <T extends Comparable<? super T>> List<T> recursiveSort(T element, List<T> shuffled) {
		if (shuffled.isEmpty()) {
			shuffled.add(0, element);
			return shuffled;
		}

		if (element.compareTo(shuffled.get(0)) <= 0) {
			shuffled.add(0, element);
			return shuffled;
		}
		T head = shuffled.remove(0);

		recursiveSort(element, shuffled);

		shuffled.add(0, head);
		return shuffled;
	}

}
