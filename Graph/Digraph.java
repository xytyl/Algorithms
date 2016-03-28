package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import altext.Bag;

public class Digraph { // 有向图,用一个Bag装所有顶点指出的顶点。

	private final int V;
	private int E;
	private Bag<Integer>[] bag;
	public Digraph(int V){
		this.V=V;
		this.E=0;
		bag = (Bag<Integer>[]) new Bag[V];
		for(int i = 0;i<V;i++){
			bag[i] = new Bag<Integer>();
		}
	}
	public Digraph(Scanner s){
		this(s.nextInt());
		int E = s.nextInt();
		for(int i = 0;i<E;i++){
			int v=s.nextInt();
			int w=s.nextInt();
			addEdge(v, w);
		}
	}
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	public void addEdge(int v,int w){
		bag[v].add(w);
		E++;
	}
	public Iterable<Integer> adj(int V){
		return bag[V];
	}
	public Digraph reverse(){
		Digraph D = new Digraph(V);
		for(int i = 0;i<V;i++){
			for(int w:adj(i)){
				addEdge(w, i);
			}
		}
		return D;
	}
	public String toString(){
		String s =V+" ";
		s+=E;
		for(int i=0;i<V;i++){
			for(int w:bag[i])
				s=s+i+" "+w+" ";
		}
		return s;
	}
	public static void main(String args[]){
		File file = new File(args[0]);
		Scanner scanner =null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Digraph JJ =new Digraph(scanner);
		System.out.print(JJ.toString());
	}
}
