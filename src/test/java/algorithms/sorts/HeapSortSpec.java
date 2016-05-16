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
		List<Integer> shuffled = new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 3, 2, 1 }));

		it(heap.sort(shuffled)).shouldBeEqual(sorted);
	}
	
	@Test
	public void maxHeapifyTest() {
		List<Integer> toHeap = new ArrayList<Integer>(Arrays.asList(new Integer[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1 }));
		List<Integer> heapified = new ArrayList<Integer>(Arrays.asList(new Integer[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1 }));
		
		HeapSort.MaxHeap<Integer> heap = new HeapSort.MaxHeap<Integer>(toHeap);
		
		it(heap.asCollection()).shouldBeEqual(heapified);
	}
}