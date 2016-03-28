package altext;

import javax.swing.JComboBox.KeySelectionManager;

public class BinarSearchST<Key extends Comparable<Key>,Value> {

	private int N=0;
	private Key[] key;
	private Value[] value;
	public BinarSearchST(int N){
		key=(Key[]) new Comparable[N];
		value=(Value[]) new Object[N];
	}
	public int size(){
		return N;
	}
	private boolean less(Key k1,Key k2){
		return k1.compareTo(k2)<0;
	}
	private int rank(Key k,int lo,int hi){
		if(hi<lo) return lo;
		int mid=lo+(hi-lo)/2;
		if(key[mid].compareTo(k)==0) return mid;
		else if(less(k,key[mid])) return rank(k,lo,mid-1);
		else return rank(k,mid+1,hi);
	}

	public Key select(int i){
		return key[i];
	}
	public void put(Key k,Value v){
		if(N==0){
			key[0]=k;
			value[0]=v;
			N++;
			return;
		}
		if(N==1){
			if(key[0].compareTo(k)<0) {key[1]=k;
			value[1]=v;N++;return;}
			else if(key[0].compareTo(k)>0){
				key[1]=key[0];
				value[1]=value[0];
				key[0]=k;
				value[1]=v;
				N++;
				return;
			}
		}
		int x=rank(k,0,N-1);
		
		if(x<N&&k.compareTo(key[x])==0) {value[x] =v;return;}
		for(int i=N-1;i>=x;i--){
			key[i+1]=key[i];
			value[i+1]=value[i];
		}
		key[x]=k;
		value[x]=v;
		N++;
	}
	public Iterable<Key> keys(){
		Queue<Key> q=new Queue<Key>();
		for(int i =rank(key[0],0,N-1);i<=rank(key[N-1],0,N-1);i++){
			q.enqueue(key[i]);
		}
		return q;
	}
	public Value get(Key k){
		if(isEmpty()) return null;
		int x=rank(k,0,N-1);
		return value[x];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public Value delete(Key k){
		int x=rank(k,0,N-1);
		if(x<N-1) {
			Value v = value[x];
			for(int i = x;i<N-1;i++){
				key[i]=key[i+1];
				value[i]=value[i+1];
			}
			value[N-1]=null;
			N--;
			return v;
		}else if(x==N-1){
			Value v = value[N-1];
			
			value[N-1]=null;
			N--;
			return v;
		}else return null;
	}

    public static void main(String[] args) {
        BinarSearchST<String, Integer> st = new BinarSearchST<String, Integer>(20);
        for (int i = 0; i<13; i++) {
            String key = StdIn.readString();
            st.put(key, i);

        }
//        st.delete("R");
//        for (String s:st.keys()) {
//        	
//        	StdOut.println(s+" "+st.get(s));
//        }
        for(int i=0;i<10;i++){
        StdOut.println(st.select(i)+" "+st.get(st.select(i)));
        }



    }
}
