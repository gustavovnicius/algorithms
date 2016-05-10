package algorithms.sorts;

import java.util.function.BiFunction;

public class Order<T> {	
	public static BiFunction ASC = 	(a, b) -> {  return ((Comparable) a).compareTo(b) > 0; };
	public static BiFunction DESC = (a, b) -> {  return ((Comparable) b).compareTo(a) > 0; };
}
