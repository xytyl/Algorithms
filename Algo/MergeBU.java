package altext;

public class MergeBU {

	private static Comparable[] aux;
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
	}
	public static void merge(Comparable[] a,int lo,int mid ,int hi){
		int  i =lo,j=mid+1;
		for(int k=lo;k<=hi;k++){
			aux[k]=a[k];
		}
		for(int k=lo;k<=hi;k++){
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(less(aux[i], aux[j])) a[k]=aux[i++];
			else a[k]=aux[j++];
		}
	}
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		for(int sz=1;sz<a.length;sz=sz+sz){
			for(int lo=0;lo<a.length-sz;lo+=sz+sz){
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1, a.length-1));
			}
		}
	}
}
