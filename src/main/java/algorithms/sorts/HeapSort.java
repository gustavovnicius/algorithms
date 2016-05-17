package algorithms.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class HeapSort {
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled) {
		return this.sort(shuffled, new Order<T>().ASC);
	}

	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled,
			BiFunction<Comparable<? super T>, T, Boolean> order) {
		List<T> toShuffle = new ArrayList<T>(shuffled);
		List<T> sorted = new ArrayList<T>();

		toShuffle = new Heap<T>(toShuffle, order).asCollection();

		for (int i = toShuffle.size(); i > 0; i--) {
			sorted.add(0, toShuffle.remove(0));
			new Heap<T>().heapify(toShuffle, 0, order);
		}

		return sorted;
	}

	public static class Heap<T extends Comparable<? super T>> {
		private List<T> heap;

		public Heap() {}

		public Heap(List<T> list, BiFunction<Comparable<? super T>, T, Boolean> order) {
			List<T> toHeap = new ArrayList<T>(list);

			// Build max heap
			for (int i = toHeap.size() / 2; i >= 0; i--)
				this.heapify(toHeap, i, order);

			this.heap = new ArrayList<T>(toHeap);
		}

		public void heapify(List<T> list, Integer index, BiFunction<Comparable<? super T>, T, Boolean> order) {
			Integer left = index * 2 + 1;
			Integer right = left + 1;
			Integer greater = index;

			if (left < list.size() && order.apply(list.get(left), list.get(index))) {
				greater = left;
			}

			if (right < list.size() && order.apply(list.get(right), list.get(greater))) {
				greater = right;
			}

			if (greater != index) {
				Collections.swap(list, index, greater);
				heapify(list, greater, order);
			}
		}

		public List<T> asCollection() {
			return this.heap;
		}
	}

}
