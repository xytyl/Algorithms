package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import altext.SequentialSearchST;

public class SymbolGraph {

	private Scanner scanner;
	private String[] keys;
	private Graph G;
	private SequentialSearchST<String, Integer> st;
	public SymbolGraph(String filename,String delim){
		st = new SequentialSearchST<String,Integer>();
		File file = new File(filename);
		if(file.exists()){
			try {
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(scanner.hasNextLine()){
			String[] a = scanner.nextLine().split(delim);
			for(int i=0;i<a.length;i++){
				if(!st.contains(a[i]))
					st.put(a[i], st.size());
			}
		}
		keys = new String[st.size()];
		for(String name:st.keys()){
			keys[st.get(name)]=name;
		}
		G = new Graph(st.size());
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(scanner.hasNextLine()){
			String[] a = scanner.nextLine().split(delim);
			int v=st.get(a[0]);
			for(int i = 1;i<a.length;i++){
				G.addEdge(v, st.get(a[i]));
			}
		}
		}
	public int index(String s){
		return st.get(s);
	
	}
	public String name(int v){
		return keys[v];
	}
	public static void main(String[] args){
//		String filename=args[0];
//		String delim =args[1];
//		SymbolGraph sg=new SymbolGraph(filename, delim);
//		Graph G=sg.G;
//		while(StdIn.hasNextLine()){
//			String source = StdIn.readLine();
//			for(int w:G.adj(sg.index(source)))
//				StdOut.println("  "+sg.name(w));
//		}
//		
//
//		
		File file = new File(args[0]);
		Scanner scanner=null;
		if(file.exists()){
			try {
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(scanner.hasNextLine()){
			String[] a = scanner.nextLine().split(args[1]);
			for(int i=0;i<a.length;i++){
				System.out.print(a[i]+" ");
			}
		}
	}
}
