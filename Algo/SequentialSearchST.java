package altext;



public class SequentialSearchST<Key,Value> {

	private class Node{
		Key key;
		Value val;
		Node next;
		public Node(Key key,Value val,Node next){
			this.key=key;
			this.val=val;
			this.next=next;
		}
	}

	private int N;
	private Node first;

	public void put(Key key,Value val){
		for(Node x=first;x!=null;x=x.next){
			if(key.equals(x.key)){
				x.val=val;
				return;
			}
		}
		first=new Node(key, val, first);
		N++;

	}
	public Value get(Key key){

		for(Node x = first;x!=null;x=x.next){
			if(key.equals(x.key)){
				return x.val;
			}
		}
		return null;
	}
	public void delete(Key key) {

		first = delete(first,key);
	}
	public Node delete(Node X,Key key){
		if(X==null) return null;
		if(key.equals(X.key)) {
			N--;
			return X.next;
		}
		X.next=delete(X.next,key);
		return X;
	}
	public boolean contains(Key key){
		return get(key)!=null;
	}
	public boolean isEmpty(){
		return size()==0;
	}
	public int size(){
		return N;
	}
	public Iterable<Key> keys(){
		Queue<Key> queue = new Queue<Key>();
		for(Node x = first;x!=null;x=x.next){
			queue.enqueue(x.key);
		}
		return queue;
	}
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
