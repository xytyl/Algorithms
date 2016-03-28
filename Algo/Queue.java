package altext;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>{

	private int N;
	private Node first;
	private Node last;
	private class Node{
		Item item;
		Node next;
	}
    public Queue() {
        first = null;
        last  = null;
    }
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void enqueue(Item i){
		if(N==0){
			Node n = new Node();
			n.item=i;
			first=n;
			last=n;
			N++;
		}
		else {
			Node oldlast = last;
			last = new Node();
			last.item=i;
			oldlast.next=last;
			N++;
		}
	}
	public Item dequeue(){
		Item i = first.item;
		first=first.next;
		if(isEmpty()){
			last = null;
		}
		N--;
		return i;
	}
	@Override
	public Iterator<Item> iterator() {
		
		return new ListIterator();
		
	}
	private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
