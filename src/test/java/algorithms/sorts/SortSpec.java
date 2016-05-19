package algorithms.sorts;

import static org.javalite.test.jspec.JSpec.it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortSpec {
	private List<Integer> sorted;
	private List<Integer> reversed;

	@Test
	public void sortingTest() {
		ascendingSortOrderByDefault(InsertionSort.class);
		ascendingSortOrderByDefault(MergeSort.class);
		ascendingSortOrderByDefault(HeapSort.class);
		ascendingSortOrderByDefault(QuickSort.class);
		ascendingSortOrderByDefault(CountingSort.class);

		explicitSortOrder(InsertionSort.class);
		explicitSortOrder(MergeSort.class);
		explicitSortOrder(HeapSort.class);
		explicitSortOrder(QuickSort.class);
	}

	private void ascendingSortOrderByDefault(Class<? extends Sort> sort) {
		setup();
		try {
			Sort s = sort.newInstance();
			it(s.sort(reversed)).shouldBeEqual(sorted);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private void explicitSortOrder(Class<? extends Sort> sort) {
		setup();
		try {
			Sort s = sort.newInstance();
			it(s.sort(sorted, new Order<Integer>().DESC)).shouldBeEqual(reversed);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private void setup() {
		sorted = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4 }));
		reversed = new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 3, 2, 1 }));
	}

}
