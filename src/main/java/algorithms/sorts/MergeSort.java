package algorithms.sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class MergeSort implements Sort {
	@Override
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled) {
		return sort(shuffled, new Order<T>().ASC);
	}

	@Override
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled,
			BiFunction<Comparable<? super T>, T, Boolean> order) {
		if (shuffled.size() <= 1)
			return shuffled;

		Integer mid = shuffled.size() / 2;
		List<T> left = sort(new ArrayList<T>(shuffled.subList(0, mid)), order);
		List<T> right = sort(new ArrayList<T>(shuffled.subList(mid, shuffled.size())), order);

		return merge(left, right, order);
	}

	public <T extends Comparable<? super T>> List<T> merge(List<T> left, List<T> right,
			BiFunction<Comparable<? super T>, T, Boolean> order) {
		List<T> dest = new ArrayList<T>();

		while (!left.isEmpty() && !right.isEmpty()) {
			if (order.apply(right.get(0), left.get(0)))
				dest.add(left.remove(0));
			else
				dest.add(right.remove(0));
		}

		dest.addAll(left);
		dest.addAll(right);

		return dest;
	}

}
