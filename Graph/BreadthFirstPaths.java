package Graph;

import java.util.Stack;

import altext.Queue;

public class BreadthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	public BreadthFirstPaths(Graph G,int s){
		this.s=s;
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		bfs(G,s);
	}
	private void bfs(Graph G,int s){
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(s);
		marked[s]=true;
		while(!queue.isEmpty()){
			int v=queue.dequeue();
			for(int j:G.adj(v)){
				queue.enqueue(j);
				marked[j]=true;
				edgeTo[j]=v;
			}
		}
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> stack =new Stack<Integer>();
		for(int i=v;i!=s;i=edgeTo[i]){
			stack.push(i);
		}
		stack.push(s);
		return stack;
	}
}
