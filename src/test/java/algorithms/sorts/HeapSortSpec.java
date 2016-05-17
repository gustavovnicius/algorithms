package algorithms.sorts;

import static org.javalite.test.jspec.JSpec.it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class HeapSortSpec {
	private List<Integer> sorted;
	private List<Integer> reversed;

	@Before
	public void setup() {
		sorted = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4 }));
		reversed = new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 3, 2, 1 }));
	}

	@Test
	public void ascendingOrderByDefaultTest() {
		HeapSort heap = new HeapSort();

		it(heap.sort(reversed)).shouldBeEqual(sorted);
	}

	@Test
	public void sortWithExplicitOrderTest() {
		HeapSort heap = new HeapSort();

		it(heap.sort(sorted, new Order<Integer>().DESC)).shouldBeEqual(reversed);
	}

	@Test
	public void maxHeapifyTest() {
		List<Integer> toHeap = new ArrayList<Integer>(Arrays.asList(new Integer[] { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 }));
		List<Integer> heapified = new ArrayList<Integer>(
				Arrays.asList(new Integer[] { 16, 14, 10, 8, 7, 9, 3, 2, 4, 1 }));

		HeapSort.MaxHeap<Integer> heap = new HeapSort.MaxHeap<Integer>(toHeap, new Order<Integer>().ASC);

		it(heap.asCollection()).shouldBeEqual(heapified);
	}
}