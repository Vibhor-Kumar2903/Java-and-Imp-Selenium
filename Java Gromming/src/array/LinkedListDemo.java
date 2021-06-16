package array;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		System.out.println("Linked List demo..");
		LinkedList ll = new LinkedList();
		ll.add("A");
		ll.add(10);
		ll.add(11.15);
		ll.addFirst(12);
		ll.addLast("BB");
		ll.removeFirst();
		ll.removeLast();
		
		System.out.println(ll);
	}
}
