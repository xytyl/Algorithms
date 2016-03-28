package altext;

public class UF {

	private int count;
	private int[] sz;
	public UF(int N){
		count=N;
		id = new int[count];
		for(int i=0;i<N;i++){
			id[i]=i;
		}
		sz = new int[count];
		for(int i=0;i<N;i++){
			sz[i]=i;
		}
	}
	private int[] id;
	public int find(int p){
		while(p!=id[p]){
			p=id[p];
		}
		return p;
	}
	public void union(int p,int q){
		int v1 = find(p);
		int v2 = find(q);
		if(v1==v2) return;
		else if(sz[v1]>=sz[v2]) {
			id[q]=v1;
			sz[v1]+=sz[v2];
		}
		else 
		{id[p]=v2;
		sz[v2]+=sz[v1];
		}
		
		count--;
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	public int count(){
		return count;
	}
}
