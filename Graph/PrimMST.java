package Graph;

import altext.MinPQ;

public class PrimMST {  //最小生成树的Prim算法的即时实现
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private MinPQ<Edge> pq;
}
