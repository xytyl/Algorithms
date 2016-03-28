package altext;

public class BST<Key extends Comparable<Key>,Value>{

	private class Node{
		Key key;
		Value value;
		Node lnext;
		Node rnext;
		int N;
		public Node(Key k,Value v,int N){
			key=k;
			value=v;
			this.N=N;
		}
	}
	private Node root;
	public int size(){
		return size(root);
	}
	private int size(Node n){
		if(n==null) return 0;
		else return n.N;
	}


	public void put(Key k,Value v){
		root=put(root,k,v);
	}
	private Node put(Node n,Key k,Value v){
		if(n==null){
			return new Node(k, v, 1);
		}
		
		if(n.key.compareTo(k)==0) {n.value=v;}
		else if(n.key.compareTo(k)>0) n.lnext=put(n.lnext,k,v);
		else n.rnext=put(n.rnext,k,v);
		n.N=size(n.rnext)+size(n.lnext)+1;
		return n;		
		
		
	}
	public Key min(){
		return min(root).key;
	}
	public Node min(Node x){
		if(x.lnext==null) return x;
		return min(x.lnext);
	}
	public Value get(Key k){
		return get(root,k);
	}
	private Value get(Node n,Key k){
		if(n==null) return null;
		if(n.key.compareTo(k)==0) return n.value;
		else if(n.key.compareTo(k)<0) return get(n.rnext,k);
		else return get(n.lnext,k);
	}
	public void deleteMin(){
		root=deleteMin(root);
	}
	private Node deleteMin(Node n){
		if(n.lnext==null) {n=n.rnext;return n;}
		n.lnext=deleteMin(n.lnext);
		n.N=size(n.lnext)+size(n.rnext)+1;
		return n;
	}
	public void delete(Key k){
		root=delete(root,k);
	}
	private Node delete(Node n,Key k){
		if(n==null) return null;
		if(n.key.compareTo(k)==0){
			if(n.rnext==null) return n.lnext;
			if(n.lnext==null) return n.rnext;
			Node t=n;
			n=min(n.rnext);
			n.rnext=deleteMin(t.rnext);
			n.lnext=t.lnext;
		}
		else if(n.key.compareTo(k)>0){
			n.lnext=delete(n.lnext,k);
		}
		else n.rnext=delete(n.rnext, k);
		n.N=size(n.rnext)+size(n.lnext)+1;
		return n;
	}
	public void print(Node n){
		if(n==null) return;
		print(n.lnext);
		StdOut.println(n.key);
		print(n.rnext);
	}
}
