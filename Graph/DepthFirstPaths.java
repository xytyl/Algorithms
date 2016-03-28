package Graph;

import java.util.Stack;

public class DepthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	public DepthFirstPaths(Graph G,int s){
		this.s=s;
		marked=new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G,s);
	}
	private void dfs(Graph G,int v){
		marked[v]=true;
		for(int w:G.adj(v)){
			if(!marked[w]){
			edgeTo[w]=v;
			dfs(G, w);}
		}
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> stk = new Stack<>();
		for(int i=v;i!=s;i=edgeTo[i]){
			stk.push(i);
		}
		stk.push(s);
		return stk;
	}
}
