package altext;




public class LinearProbingHashST<Key,Value>{

	private int N;
	private int M=16;
	private Key[] keys;
	private Value[] vals;
	public LinearProbingHashST(){
		keys=(Key[]) new Object[M];
		vals=(Value[])new Object[M];
	}
	public LinearProbingHashST(int cap){
		keys=(Key[]) new Object[cap];
		vals=(Value[]) new Object[cap];
		M=cap;
	}
	private void resize(int cap){
		LinearProbingHashST<Key, Value> lp = new LinearProbingHashST<Key,Value>(cap);
		for(int i=0;i<M;i++){
			if(keys[i]!=null)
				lp.put(keys[i], vals[i]);
		}
		keys=lp.keys;
		vals=lp.vals;
		this.M=lp.M;
	}
	private int hash(Key k){
		return (k.hashCode()&0x7fffffff)%M;
	}
	public Value get(Key k){
		for(int i=hash(k);keys[i]!=null;i=(i+1)%M)
			if(keys[i].equals(k))
				return vals[i];
		return null;
	}
	public void put(Key k,Value v){
		if(N>=M/2) resize(2*M);
		int i;
		for(i=hash(k);keys[i]!=null;i=(i+1)%M){
			if(keys[i].equals(k)) {
				vals[i]=v;
				return;
			}
		}
		keys[i]=k;
		vals[i]=v;
		N++;
		
	}
	public Iterable<Key> keys(){
		Queue<Key> key = new Queue<Key>();
		for(int i=0;i<keys.length;i++){
			if(keys[i]!=null)
				key.enqueue(keys[i]);
		}
		return key;
	}
	public void delete(Key k){
		int i =hash(k);
		while(!keys[i].equals(k)){
			i=(i+1)%M;
		}
		keys[i]=null;
		vals[i]=null;
		i=(i+1)%M;
		while(keys[i]!=null){
			Key tempk=keys[i];
			Value tempv=vals[i];
			keys[i]=null;
			vals[i]=null;
			N--;
			put(tempk, tempv);
			i=(i+1)%M;
		}
		N--;
		if(N>0&&N==M/8){
			resize(M/2);
		}
	}
}