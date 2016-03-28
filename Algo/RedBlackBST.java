package altext;

import java.sql.Blob;

public class RedBlackBST<Key extends Comparable<Key>,Value> {

	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private Node root;
	private class Node{
		Key key;
		Value value;
		int N;
		boolean color;
		Node lnext;
		Node rnext;
		public Node(Key k,Value v,int N,boolean color){
			key=k;
			value=v;
			this.N=N;
			this.color=color;
		}
	}
	public boolean contains(Key k){
		return get(k)!=null;
	}
	private boolean isRed(Node n){
		if(n==null) return false;
		return n.color==RED;
	}
	public int size(){
		return size(root);
	}
	private int size(Node n){
		if(n==null) return 0;
		return size(n.rnext)+size(n.lnext)+1;
	}
	private Node rotateLeft(Node h){
		Node x=h.rnext;
		h.rnext=x.lnext;
		x.lnext=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=size(h.lnext)+size(h.rnext)+1;
		return x;
	}
	private Node rotateRight(Node h){
		Node x=h.lnext;
		h.lnext=x.rnext;
		x.rnext=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=size(h.lnext)+size(h.rnext)+1;
		return x;
	}
	private void flipColors(Node n){
		n.color=RED;
		n.rnext.color=BLACK;
		n.lnext.color=BLACK;
	}
	public void put(Key k,Value v){
		root=put(root,k,v);
		root.color=BLACK;
	}
	private Node put(Node n,Key k,Value v){
		if(n==null) return new Node(k,v,1,RED);
		if(k.compareTo(n.key)>0)  n.rnext=put(n.rnext,k,v);
		else if(k.compareTo(n.key)<0)  n.lnext=put(n.lnext,k,v);
		else {
			n.value=v;
		}
		if(n.lnext.color==RED&&n.rnext.color==RED){
			flipColors(n);
		}
		if(n.lnext.color==RED&&n.lnext.lnext.color==RED){
			n=rotateRight(n);
		}
		if(n.rnext.color=RED&&n.lnext.color!=RED){
			n=rotateLeft(n);
		}
		n.N=size(n.lnext)+size(n.rnext)+1;
		return n;
	}
    public Value get(Key key) { return get(root, key); }

    // value associated with the given key in subtree rooted at x; null if no such key
    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.lnext;
            else if (cmp > 0) x = x.rnext;
            else              return x.value;
        }
        return null;
    }
	public Iterable<Key> keys(){
		Queue<Key> q= new Queue<Key>();
		return q;
		
	}
	public static void main(String args[]){
		RedBlackBST<String, Integer> rb= new RedBlackBST<String,Integer>();
		rb.put("s", 0);
		rb.put("e", 1);
		rb.put("a", 2);
		rb.put("r", 3);
		rb.put("c", 4);
		rb.put("h", 5);
		rb.put("x", 6);
		rb.put("m", 7);
		rb.put("p", 8);
		rb.put("l", 9);
		
	}
}
