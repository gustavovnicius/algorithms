package algorithms.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapSort {
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled) {
		List<T> toShuffle = new ArrayList<T>(shuffled);
		List<T> sorted = new ArrayList<T>();

		toShuffle = new MaxHeap<T>(toShuffle).asCollection();

		for (int i = toShuffle.size(); i > 0; i--) {
			sorted.add(0, toShuffle.remove(0));
			new MaxHeap<T>().maxHeapify(toShuffle, 0);
		}

		return sorted;
	}

	public static class MaxHeap<T extends Comparable<? super T>> {
		private List<T> heap;

		public MaxHeap() {

		}

		public MaxHeap(List<T> list) {
			List<T> toHeap = new ArrayList<T>(list);

			// Build max heap
			for (int i = toHeap.size() / 2; i >= 0; i--)
				this.maxHeapify(toHeap, i);

			this.heap = new ArrayList<T>(toHeap);
		}

		public void maxHeapify(List<T> list, Integer index) {
			Integer left = index * 2 + 1;
			Integer right = left + 1;
			Integer maior = index;

			if (left < list.size() && list.get(left).compareTo(list.get(index)) > 0) {
				maior = left;
			}

			if (right < list.size() && list.get(right).compareTo(list.get(maior)) > 0) {
				maior = right;
			}

			if (maior != index) {
				Collections.swap(list, index, maior);
				maxHeapify(list, maior);
			}
		}

		public List<T> asCollection() {
			System.out.println(this.heap);
			return this.heap;
		}
	}

}
