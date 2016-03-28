package altext;

import java.util.Iterator;

public class FixedCapacityStack<item> implements Iterable<item>{

	private int N;
	private item[] val;
	public FixedCapacityStack (int a){
		val= (item[])new Object[a];
	}
	public Iterator<item> iterator(){
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<item>{
		private int i =N;
		public boolean hasNext(){
			return i>0;
		}
		public item next(){
			return val[--i];
		}
		public void remove(){
			
		}
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size (){
		return N;
	}
	public void push(item x){
		if(N==val.length) resize(2*val.length);
		val[N++]=x;
	}
	public item pop(){
		item i = val[--N];
		val[N]= null;
		if(N>0&&N==val.length/4) resize(val.length/2);
		return i;
		
	}
	private void resize (int max){
		item[] temp = (item[])new Object[max];
		for(int i =0;i<N;i++){
			temp[i]=val[i];
		}
		val=temp;
	}

}
