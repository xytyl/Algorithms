package Graph;

import altext.Bag;
import altext.Queue;

public class EdgeWeightedGraph {  //加权无向图
	private final int V;
	private int E;
	private Bag<Edge>[] bag;
	public EdgeWeightedGraph(int V){
		this.V=V;
		this.E=0;
		bag =(Bag<Edge>[])new Bag[V];
		for(int i=0;i<V;i++){
			bag[i] = new Bag<Edge>();
		}
	}
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	public void addEdge(Edge e){
		bag[e.either()].add(e);
		bag[e.other(e.either())].add(e);
		E++;
	}
	public Iterable<Edge> adj(int v){
		return bag[v];
	}
	public Iterable<Edge> edges(){
		Bag<Edge> b = new Bag<Edge>();
		for(int v = 0;v<V;v++){
			for(Edge e:bag[v])
				if(e.other(v)>v) b.add(e);
		}
		return b;
	}
}
