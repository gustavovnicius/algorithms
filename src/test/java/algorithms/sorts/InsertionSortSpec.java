package algorithms.sorts;

import static org.javalite.test.jspec.JSpec.it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class InsertionSortSpec {
	@Test
	public void sortTest() {
		InsertionSort insertion = new InsertionSort();

		List<Integer> shuffled = new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 2, 3, 1 }));
		List<Integer> sorted = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4 }));

		it(insertion.sort(shuffled)).shouldEqual(sorted);
	}

	@Test
	public void sortOrderTest() {
		InsertionSort insertion = new InsertionSort();

		List<Integer> shuffled = new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 2, 4, 1 }));
		List<Integer> sorted = new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 3, 2, 1 }));

		it(insertion.sort(shuffled, new Order<Integer>().DESC)).shouldEqual(sorted);
	}
}
