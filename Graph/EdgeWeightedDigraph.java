package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import altext.Bag;

public class EdgeWeightedDigraph {         //加权有向图
	private final int V;
	private int E;
	private Bag<DirectedEdge>[] bag;
	public EdgeWeightedDigraph(int V){
		this.V=V;
		this.E=0;
		bag = (Bag<DirectedEdge>[])new Bag[V];
		for(int i =0;i<V;i++){
			bag[i] = new Bag<DirectedEdge>();
		}
	}
	public EdgeWeightedDigraph(Scanner scanner){
		this(scanner.nextInt());
		int E = scanner.nextInt();
		for(int i =0;i<E;i++){
			addEdge(new DirectedEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble()));
		}
	}
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	public void addEdge(DirectedEdge e){
		bag[e.from()].add(e);
		E++;
	}
	public Iterable<DirectedEdge> adj(int v){
		return bag[v];
	}
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> bg=new Bag<DirectedEdge>();
		for(int i = 0;i<V;i++){
			for(DirectedEdge e:bag[i])
				bg.add(e);
		}
		return bg;
	}
	public String toString(){
		String NEWLINE = System.getProperty("line.separator");
		StringBuilder s = new StringBuilder();
		s.append(V+" "+E+NEWLINE);
		for(int v =0;v<V;v++){
			s.append(v+": ");
			for(DirectedEdge e:bag[v]){
				s.append(e+" ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
	public static void main(String args[]){
		File file = new File(args[0]);
		Scanner scanner=null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EdgeWeightedDigraph ed = new EdgeWeightedDigraph(scanner);
		System.out.print(ed.toString());

	}
}
