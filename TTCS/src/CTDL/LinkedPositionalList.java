package CTDL;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E>{
	private static class Node<E> implements Position<E> {
		private E element;
		private String flag;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public E getElement() throws IllegalStateException {
			if (next == null)
				throw new IllegalStateException("Position no longer valid");
			return element;
		}
		

		public Node<E> getPrev() {
			return prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setElement(E e) {
			element = e;
		}
		

		public void setPrev(Node<E> p) {
			prev = p;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public LinkedPositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Invalid p");
		Node<E> node = (Node<E>) p;
		if (node.getNext() == null)
			throw new IllegalArgumentException("p is no longer in the list");
		return node;
	}

	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null;
		return node;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Position<E> first() {
		return position(header.getNext());
	}

	public Position<E> last() {
		return position(trailer.getPrev());
	}

	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}

	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}

	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}

	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setPrev(null);
		return answer;
	}

	private class PositionIterator implements Iterator<Position<E>> {
		private Position<E> cursor = first(); // position of the next element to report
		private Position<E> recent = null; // position of last reported element

		public boolean hasNext() {
			return (cursor != null);
		}

		public Position<E> next() throws NoSuchElementException {
			if (cursor == null)
				throw new NoSuchElementException("nothing left");
			recent = cursor; // element at this position might later be removed
			cursor = after(cursor);
			return recent;
		}

		public void remove() throws IllegalStateException {
			if (recent == null)
				throw new IllegalStateException("nothing to remove");
			LinkedPositionalList.this.remove(recent); // remove from outer list
			recent = null; // do not allow remove again until next is called
		}
	}

	// ------------ end of nested PositionIterator class ------------
	// ---------------- nested PositionIterable class ----------------
	private class PositionIterable implements Iterable<Position<E>> {
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}
	}
	// ------------ end of nested PositionIterable class ------------

	public Iterable<Position<E>> positions() {
		return new PositionIterable(); // create a new instance of the inner class
	}

	// ---------------- nested ElementIterator class ----------------

	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = new PositionIterator();

		public boolean hasNext() {
			return posIterator.hasNext();
		}

		public E next() {
			return posIterator.next().getElement();
		} // return element!

		public void remove() {
			posIterator.remove();
		}
	}

	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	/* Insertion-sort of a positional list of integers into nondecreasing order */
	public static void insertionSort(PositionalList<Integer> list) {
		Position<Integer> marker = list.first(); // last position known to be sorted
		while (marker != list.last()) {
			Position<Integer> pivot = list.after(marker);
			int value = pivot.getElement(); // number to be placed
			if (value > marker.getElement()) // pivot is already sorted
				marker = pivot;
			else { // must relocate pivot
				Position<Integer> walk = marker; // find leftmost item greater than value
				while (walk != list.first() && list.before(walk).getElement() > value)
					walk = list.before(walk);
				list.remove(pivot); // remove pivot entry and
				list.addBefore(walk, value); // reinsert value in front of walk
			}
		}
	}
}
