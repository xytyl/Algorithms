package altext;

public class duipaixu {

	
	private static boolean less(Comparable[] a,int i ,int j){
		return a[i].compareTo(a[j])<0;
	}
	private static void exch(Comparable[] a,int i,int j){
		Comparable t =a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void sink(Comparable[] a,int k,int N){
		while(2*k<=N){
			int j = 2*k;
			if(j<N&&less(a,j,j+1)){
				j++;
			}
			if(!less(a,k,j)) break;
			exch(a,k,j);
			k=j;
		}
	}
	public static void sort(Comparable[] a){
		int N=a.length-1;
		for(int k = N/2;k>=1;k--){
			sink(a,k,N);
		}
		while(N>1){
			exch(a,1, N--);
			sink(a,1,N);
		}
	}
	private static void show(Comparable[] a){
		for(int i=0;i<a.length;i++){
			StdOut.print(a[i]+" ");
		}
		StdOut.println();
	}
	public static void main(String[] args){

		Double[] pq	 = new Double[6];
		pq[1]=4409.74;
		pq[2]=4732.35;
		pq[3]=4381.21;
		pq[4]=4747.08;
		pq[5]=4121.85;

		sort(pq);
		show(pq);
	}
}
