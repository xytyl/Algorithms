package Graph;

import java.util.Stack;

import altext.Queue;

public class DepthFirstOrder { // ������������Ķ�������

	private boolean[] marked;
	private Queue<Integer> pre;           //ǰ��
	private Queue<Integer> post;          //����
	private Stack<Integer> reversePost;   // �����
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
