package Graph;

public class Topological {

	private Iterable<Integer> order;
	public Topological(Digraph G){
		DirectedCycle cyclefinder = new DirectedCycle(G);
		if(!cyclefinder.hasCycle()){
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}
	public boolean isDAG(){
		return order!=null;
	}
	public Iterable<Integer> order(){
		return order;
	}
}
