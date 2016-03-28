package Graph;

public class DirectedDFS {//            有向图的可达性,一个顶点可以到达哪些其他顶点。

	private boolean[] marked;
	public DirectedDFS(Digraph G,int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	public DirectedDFS(Digraph G,Iterable<Integer> sources){  //sources里所有顶点可以到达哪些其他顶点。
		marked = new boolean[G.V()];
		for(int i:sources){
			if(!marked[i]) dfs(G,i);
		}
	}
	public boolean marked(int v){
		return marked[v];
	}
	public void dfs(Digraph G,int s){
		marked[s]=true;
		for(int i:G.adj(s)){
			if(!marked[i]) dfs(G,i);
		}
	}
}
