package CTDL;

import java.util.Iterator;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		LinkedPositionalList<Integer> ds=new LinkedPositionalList<>();
		int n = sc.nextInt();
		Position<Integer> p=ds.addFirst(sc.nextInt());
		for(int i=0;i<n-1;i++)
			p=ds.addAfter(p, sc.nextInt());
		Iterator<Position<Integer>> iterable = ds.positions().iterator();
		while (iterable.hasNext()) {
			Position<Integer> pos = iterable.next();
			System.out.print(pos.getElement()+" ");
		}
		System.out.println();
		LinkedPositionalList.insertionSort(ds);
		iterable = ds.positions().iterator();
		while (iterable.hasNext()) {
			Position<Integer> pos = iterable.next();
			System.out.print(pos.getElement()+" ");
		}
	}

}
