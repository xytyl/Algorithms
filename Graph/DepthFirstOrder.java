package Graph;

import java.util.Stack;

import altext.Queue;

public class DepthFirstOrder { // 深度优先搜索的顶点排序

	private boolean[] marked;
	private Queue<Integer> pre;           //前序
	private Queue<Integer> post;          //后序
	private Stack<Integer> reversePost;   // 逆后序
	public DepthFirstOrder(Digraph G){
		marked = new boolean[G.V()];
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		for(int i = 0;i<G.V();i++){
			if(!marked[i])
				dfs(G,i);
		}
	}
	private void dfs(Digraph G,int v){
		pre.enqueue(v);
		marked[v]=true;
		for(int w:G.adj(v)){
			if(!marked[w])
				dfs(G,w);
		}
		post.enqueue(v);
		reversePost.push(v);
	}
	public Iterable<Integer> pre(){
		return pre;
	}
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
}
