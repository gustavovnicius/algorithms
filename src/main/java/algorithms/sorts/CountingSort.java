package algorithms.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class CountingSort implements Sort {

	@Override
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled) {
		Map<T, Integer> aux = new HashMap<T, Integer>();
		List<T> sorted = new ArrayList<T>();

		shuffled.forEach(element -> {
			aux.put(element, aux.getOrDefault(element, 0) + 1);
		});

		aux.forEach((key, value) -> {
			for (int i = 0; i < value; i++) {
				sorted.add(key);
			}
		});

		return sorted;
	}

	@Override
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled,
			BiFunction<Comparable<? super T>, T, Boolean> order) {
		// TODO Auto-generated method stub
		return null;
	}

}
