package algorithms.sorts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class HeapSort {
	public <T extends Comparable<? super T>> List<T> sort(List<T> shuffled) {
		List<T> toShuffle = new ArrayList<T>(shuffled);
		List<T> sorted = new ArrayList<T>();

		toShuffle = new MaxHeap<T>(toShuffle).asCollection();

		for (int i = toShuffle.size(); i > 0; i--) {
			sorted.add(0, toShuffle.remove(0));
			new MaxHeap<T>().maxHeapify(toShuffle, 0);
		}

		return sorted;
	}

	public static class MaxHeap<T extends Comparable<? super T>> implements List<T> {
		private List<T> heap;

		public MaxHeap() {

		}

		public MaxHeap(List<T> list) {
			List<T> toHeap = new ArrayList<T>(list);

			// Build max heap
			for (int i = toHeap.size() / 2; i >= 0; i--)
				this.maxHeapify(toHeap, i);

			this.heap = new ArrayList<T>(toHeap);
		}

		public void maxHeapify(List<T> list, Integer index) {
			Integer left = index * 2 + 1;
			Integer right = left + 1;
			Integer maior = index;

			if (left < list.size() && list.get(left).compareTo(list.get(index)) > 0) {
				maior = left;
			}

			if (right < list.size() && list.get(right).compareTo(list.get(maior)) > 0) {
				maior = right;
			}

			if (maior != index) {
				Collections.swap(list, index, maior);
				maxHeapify(list, maior);
			}
		}

		public List<T> asCollection() {
			System.out.println(this.heap);
			return this.heap;
		}

		@Override
		public int size() {
			return this.heap.size();
		}

		@Override
		public boolean isEmpty() {
			return this.heap.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return this.heap.contains(o);
		}

		@Override
		public Iterator<T> iterator() {
			return this.heap.iterator();
		}

		@Override
		public Object[] toArray() {
			return this.heap.toArray();
		}

		@Override
		public <T> T[] toArray(T[] a) {
			return this.heap.toArray(a);
		}

		@Override
		public boolean add(T e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends T> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int index, Collection<? extends T> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub

		}

		@Override
		public T get(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public T set(int index, T element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void add(int index, T element) {
			// TODO Auto-generated method stub

		}

		@Override
		public T remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator<T> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<T> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<T> subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
