package altext;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{


	private Node first;
	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty(){
		return first==null;
	}

	public void add(Item i){
		Node oldfirst=first;
		first=new Node();
		first.item=i;
		first.next=oldfirst;
		
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	public class ListIterator implements Iterator<Item>{


		private Node current =first;
		@Override
		public boolean hasNext() {
			
			return current!=null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current=current.next;
			return item;
		}
		
	}
	

}