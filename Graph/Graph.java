package Graph;

import altext.Bag;

public class Graph {
	public Graph(int V){
		this.V=V;
		this.E=0;
		bag = (Bag<Integer>[]) new Bag[V];
		for(int v=0;v<V;v++){
			bag[v]= new Bag<Integer>();
		}
	}

	private  final int V;
	private  int E;
	private Bag<Integer>[] bag;
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	public void addEdge(int v,int w){
		bag[v].add(w);
		bag[w].add(v);
		E++;
	}
	public  Iterable<Integer> adj(int v){
		return bag[v];
	}
	public String toString(){
		String s = V+" vertices,"+E+" edges\n";
		for(int v=0;v<V;v++){
			s+=v+": ";
			for(int w:this.adj(v))
				s+=w+" ";
			s+="\n";
		}
		return s;
	}
	public static int degree(Graph G,int v){
		int degree=0;
		for(int w:G.adj(v)) degree++;
		return degree;
	}
	public static int maxDegree(Graph G){
		int max=degree(G,0);
		for(int i=1;i<G.V();i++){
			if(degree(G,i)>max)
				max=degree(G,i);
		}
		return max;
	}
	public static double avgDegree(Graph G){
		return 2.0*G.E()/G.V();
	}
}
