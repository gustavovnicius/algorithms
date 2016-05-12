package algorithms.sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class MergeSort {
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled) {
		return sort(shuffled, new Order<T>().ASC);
	}

	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled,
			BiFunction<Comparable<? super T>, T, Boolean> order) {
		if (shuffled.size() <= 1)
			return shuffled;

		Integer mid = shuffled.size() / 2;
		List<T> left = sort(new ArrayList<T>(shuffled.subList(0, mid)));
		List<T> right = sort(new ArrayList<T>(shuffled.subList(mid, shuffled.size())));

		return merge(left, right);
	}

	public <T extends Comparable<? super T>> List<T> merge(List<T> left, List<T> right) {
		List<T> dest = new ArrayList<T>();

		while (!left.isEmpty() && !right.isEmpty()) {
			if (left.get(0).compareTo(right.get(0)) < 0)
				dest.add(left.remove(0));
			else
				dest.add(right.remove(0));
		}

		dest.addAll(left);
		dest.addAll(right);

		return dest;
	}

}
