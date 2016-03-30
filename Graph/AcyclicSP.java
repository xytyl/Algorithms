package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class AcyclicSP {   //无环加权有向图的最短路径算法（比Dijkstra算法快、简单）
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	public AcyclicSP(EdgeWeightedDigraph G,int s){
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		for(int v=0;v<G.V();v++){
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		Topological topo = new Topological(G);
		for(int v:topo.order()){
			relax(G,v);
		}
	}
	private void relax(EdgeWeightedDigraph G,int v){
		for(DirectedEdge e:G.adj(v)){
			int w= e.to();
			if(distTo[w]>distTo[v]+e.weight()){
				distTo[w]=distTo[v]+e.weight();
				edgeTo[w]=e;
			}
		}
	}
	public double distTo(int v){
		return distTo[v];
	}
	public boolean hasPathTo(int v){
		return distTo[v]<Double.POSITIVE_INFINITY;
	}
	public Iterable<DirectedEdge> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
		for(DirectedEdge e = edgeTo[v];e!=null;e=edgeTo[e.from()]){
			stack.push(e);
		}
		return stack;
	}
//	public static void main(String args[]){
//		File file = new File(args[0]);
//		Scanner scanner=null;
//		try {
//			scanner = new Scanner(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		EdgeWeightedDigraph ed = new EdgeWeightedDigraph(scanner);
//		AcyclicSP ac = new AcyclicSP(ed, 5);
//		for(int t =0;t<ed.V();t++){
//			System.out.print(5+" to "+t);
//			System.out.print(String.format("(%4.2f): ", ac.distTo(t)));
//			if(ac.hasPathTo(t))
//				for(DirectedEdge e:ac.pathTo(t))
//					System.out.print(e+" ");
//			System.out.println();
//		}
//	}
}
