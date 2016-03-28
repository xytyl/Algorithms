package altext;

public class Stackk<Item> {

	private int N;
	private Node first;
	private class Node {
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public static Stackk<String> copy(Stackk<String> s){
		Stackk<String> c = new Stackk<String>();
		c=s;
		return c;
	}
	public int size(){
		return N;
	}
	public void push(Item i){
		if(N==0){
			Node first = new Node();
			first.item=i;
			N++;
		}
		else {
			Node oldfirst = first;
			first = new Node();
			
			first.item=i;
			first.next=oldfirst;
			N++;
		}
		
	}
	public Item pop(){
		Item i=first.item;
		first=first.next;
		N--;
		return i;
	}
}
