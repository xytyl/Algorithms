package Graph;

import altext.MinPQ;

public class PrimMST {  //��С��������Prim�㷨�ļ�ʱʵ��
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private MinPQ<Edge> pq;
}
