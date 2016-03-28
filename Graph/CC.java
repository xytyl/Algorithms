package Graph;

public class CC {
	private int count;
	private int[] id;
	private boolean[] marked;
	public CC(Graph G){
		id = new int[G.V()];
		marked = new boolean[G.V()];
		for(int s=0;s<G.V();s++){
			if(!marked[s]){
			dfs(G,s);
			count++;
			}
		}
	}
	private void dfs(Graph G,int v){
		marked[v]=true;
		id[v]=count;
		for(int s:G.adj(v)){
			if(!marked[s])
				dfs(G,s);
		}
	}
	public boolean connected(int v,int w){
		return id[v]==id[w];
	}
	public int count(){
		return count;
	}
	public int id(int v){
		return id[v];
	}
}
