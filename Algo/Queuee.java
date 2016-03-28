package altext;

public class Queuee<Item> {

	private int N;
	private class Node{
		Item item;
		Node next;
	}

	private Node last;
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void enQueue(Item item){
		Node n = new Node();
		n.item=item;
		if(isEmpty()){
			n.next=n;
		}
		else {
			n.next=last.next;
			last.next=n;
		}
		last=n;
		N++;
	}
	public Item deQueue(){
		Item i = last.next.item;
		if(last.next==last) last=null;
		else last.next=last.next.next;
		N--;
		return i;
	}
}
