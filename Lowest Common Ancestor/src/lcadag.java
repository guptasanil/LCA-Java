import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class lcadag {
	private int vertnum;
	private int edgnum;
	private ArrayList<Integer>[] nodes;
	private int[] indegree;
	private boolean done[];
	private boolean isAcylic;
	private boolean order[];
	private int[] path;
	private int[] route;

	public lcadag(int vertnum) {
		if (vertnum < 0)
			throw new IllegalArgumentException("The number of vertices in the graph must be greater than 0");

		this.vertnum = vertnum;
		this.edgnum = 0;
		this.nodes = (ArrayList<Integer>[]) new ArrayList[vertnum];
		this.indegree = new int[vertnum];
		this.done = new boolean[vertnum];
		this.order = new boolean[vertnum];


		for (int i = 0; i < vertnum; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
	}

	public int getnumofedg() {
		return edgnum;
	}

	public int getnumofvert() {
		return vertnum;
	}

	public boolean doesvertfit(int v) {
		if (v > 0 && v <= vertnum) {
			return true;
		} else {
			return false;
		}

	}
}