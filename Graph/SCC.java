package Graph;

import altext.Queue;

public class SCC {  //强连通分量

	private boolean[] marked;
	private int[] id;
	private int count;
	public SCC(Digraph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder dfo = new DepthFirstOrder(G.reverse());   //反向图的逆后序排列
		for(int i :dfo.reversePost()){
			if(!marked[i]){
				dfs(G,i);
				count++;
			}
		}
	}
	public int count(){
		return count;
	}
	private void dfs(Digraph G,int v){
		marked[v]=true;
		id[v]=count;
		for(int w:G.adj(v)){
			if(!marked[w])
				dfs(G,w);
		}
	}
	public boolean stronglyConnected(int v ,int w){
		return id[v]==id[w];
	}
	public int id(int v){
		return id[v];
	}
	
}
