package algorithms.sorts;

import java.util.List;
import java.util.function.BiFunction;

public interface Sort {
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled);

	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled,
			BiFunction<Comparable<? super T>, T, Boolean> order);
}
