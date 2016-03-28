package altext;

import java.util.Stack;

public class PQdiy<Key extends Comparable<Key>> {

	private int N=0;
	private Key[] aux;
	public PQdiy(int maxN){
		aux = (Key[]) new Comparable[maxN];
	}
	private boolean less(int i,int j){
		return aux[i].compareTo(aux[j])<0;
	}
	private void exch(int i,int j){
		Key k =aux[i];
		aux[i]=aux[j];
		aux[j]=k;
	}
	public void insert(Key k){
		aux[N++]=k;
	}
	public Key delMax(){
		Key max = aux[0];
		int k =0;
		for(int i = 0;i<N;i++){
			if(aux[i].compareTo(max)>0){
				max=aux[i];
				k=i;
			}
		}
		if(aux[k].equals(aux[N-1])){
			aux[--N]=null;
			
		}
		else {
			exch(k, N-1);
			aux[--N]=null;
			
		}
		return max;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public static void main(String[] args){
		Stopwatch sw = new Stopwatch();
		
		int M=5;
		PQdiy<Double> pq=new PQdiy<Double>(6);
		pq.insert(4409.74);
		pq.insert(4732.35);
		pq.insert(4381.21);
		pq.insert(4747.08);
		pq.insert(4121.85);
		Stack<Double> stack = new Stack<Double>();
		while(!pq.isEmpty()) stack.push(pq.delMax());
		for(Double m:stack) StdOut.println(m);
		StdOut.println(sw.elapsedTime());
	}
}
