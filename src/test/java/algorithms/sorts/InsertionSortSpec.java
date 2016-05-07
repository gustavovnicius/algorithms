package algorithms.sorts;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.javalite.test.jspec.JSpec.*;

public class InsertionSortSpec {
	@Test
	public void sortTest() {
		InsertionSort insertion = new InsertionSort();
		List<Integer> shuffled = Arrays.asList(new Integer[] { 4, 2, 3, 1 });
		List<Integer> sorted = Arrays.asList(new Integer[] { 1, 2, 3, 4 });
		it(insertion.sort(shuffled)).shouldEqual(sorted);
	}
}
