package CTDL;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	public static final int CAPACITY = 1000000;
	private E[] data;
	private int size = 0;

	public ArrayList() {
		this(CAPACITY);
	}

	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return data[i];
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
		checkIndex(i, size + 1);
		if (size == data.length)
			throw new IllegalStateException("Array is full");
		for (int k = size - 1; k >= i; k--)
			data[k + 1] = data[k];
		data[i] = e;
		size++;
	}

	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		for (int k = i; k < size - 1; k++)
			data[k] = data[k + 1];
		data[size - 1] = null;
		size--;
		return temp;
	}

	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + i);
	}

	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give warning
		for (int k = 0; k < size; k++)
			temp[k] = data[k];
		data = temp; // start using the new array
	}

	public class ArrayIterator implements Iterator<E> {
		private int j = 0; // index of the next element to report
		private boolean removable = false; // can remove be called at this time?

		public boolean hasNext() {
			return j < size;
		}

		public E next() throws NoSuchElementException {
			if (j == size)
				throw new NoSuchElementException("No next element");
			removable = true; // this element can subsequently be removed
			return data[j++]; // post-increment j, so it is ready for future call to next
		}

		public void remove() throws IllegalStateException {
			if (!removable)
				throw new IllegalStateException("nothing to remove");
			ArrayList.this.remove(j - 1); // that was the last one returned
			j--; // next element has shifted one cell to the left
			removable = false; // do not allow remove again until next is called
		}

	} // ------------ end of nested ArrayIterator class ------------

	public Iterator<E> iterator() {
		return new ArrayIterator(); // create a new instance of the inner class
	}
}