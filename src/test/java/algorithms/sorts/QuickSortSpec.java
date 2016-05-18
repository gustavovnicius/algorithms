package algorithms.sorts;

import static org.javalite.test.jspec.JSpec.it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class QuickSortSpec {
	private List<Integer> sorted;
	private List<Integer> reversed;

	@Before
	public void setup() {
		sorted = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4 }));
		reversed = new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 3, 2, 1 }));
	}

	@Test
	public void ascendingOrderByDefaultTest() {
		QuickSort insertion = new QuickSort();

		it(insertion.sort(reversed)).shouldBeEqual(sorted);
	}

	@Test
	public void sortWithExplicitOrderTest() {
		QuickSort insertion = new QuickSort();

		it(insertion.sort(sorted, new Order<Integer>().DESC)).shouldBeEqual(reversed);
	}
}