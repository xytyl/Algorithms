package altext;

import java.util.Stack;

public class MaxPQ<Key extends Comparable<Key>> {

	private int N=0;
	private Key[] pq;
	public MaxPQ(int maxN){
		pq= (Key[]) new Comparable[maxN+1];
	}
	private boolean less(int i ,int j){
		return pq[i].compareTo(pq[j])<0;
	}
	private void exch(int i,int j){
		Key y = pq[i];
		pq[i]=pq[j];
		pq[j]=y;
	}
	private void swim(int k){
		while(k>1&&less(k/2, k)){
			exch(k/2, k);
			k=k/2;
		}
	}
	private void sink(Comparable[] a,int k,int N){
		while(2*k<N){
			int j = 2*k;
			if(j<N&&less(j,j+1)){
				j++;
			}
			if(!less(k,j)) break;
			exch(k, j);
			k=j;
		}
	}
	public void sort(Comparable[] a){
		int N=a.length;
		for(int k = N/2;k>=1;k--){
			sink(a,k,N);
		}
		while(N>1){
			exch(1, N--);
			sink(a,1,N);
		}
	}
	public void insert(Key k){
		pq[++N]=k;
		swim(N);
	}
	public Key delMax(){
		Key k = pq[1];
		exch(1, N--);
		pq[N+1]=null;
		sink(pq,1,N);
		return k;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public static void main(String[] args){
		Stopwatch sw = new Stopwatch();
		int M=5;
		Double[] pq	 = new Double[6];
		pq[1]=4409.74;
		pq[2]=4732.35;
		pq[3]=4381.21;
		pq[4]=4747.08;
		pq[5]=4121.85;
	
	}
}
