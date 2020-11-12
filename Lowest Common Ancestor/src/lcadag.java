import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class lcadag {
	private int vertnum;
	private int edgnum;
	private ArrayList<Integer>[] nodes;
	private int[] adjnum;
	private boolean done[];
	private boolean isAcylic;
	private boolean order[];
	private int[] path;
	private int[] route;

	public lcadag(int vertnum) {
		if (vertnum < 0)
			throw new IllegalArgumentException("There can not be a graph with less than 0 verticies.");

		this.vertnum = vertnum;
		this.edgnum = 0;
		this.nodes = (ArrayList<Integer>[]) new ArrayList[vertnum];
		this.adjnum = new int[vertnum];
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
	public boolean addEdge(int from, int to){
        if (doesvertfit(from) && doesvertfit(to)){
            nodes[from].add(to);  
            adjnum[to]++;    
            edgnum++;
            return true;
        }else{
            System.out.println("Must enter vertices which exist");
            return false;
        }
    }


    
    public int edgin(int v){
        if (!doesvertfit(v)){
            return -1;
        } else {
            return this.adjnum[v];
        }
    }
    
    public int edgout(int v){
        if (!doesvertfit(v)){
            return -1;
        } else {
            return this.nodes[v].size();
        }
    }

   
    public Iterable<Integer> adj(int v){
        return nodes[v];
    }

    
    public boolean isAcyclic(){ 
    	return this.isAcylic;
    	}
    
    public boolean findCycle(int v){
        done[v] = true;
        order[v] = true;

        for (int i : adj(v)){
            if (!done[i]){
                findCycle(i);
            } 
            else if (order[i]){
                
                isAcylic = true;
                return true;    
            }
        }

        order[v] = false;
        return false;
    }

  
    public ArrayList<Integer> Search(int source){
        boolean visited[] = new boolean[this.vertnum];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> order = new ArrayList<Integer>();

        visited[source] = true;
        queue.add(source);

        while (queue.size()!=0){
            source = queue.poll();
            order.add(source); 
            
            
            Iterator<Integer> iter = adj(source).iterator();
            while (iter.hasNext()){
                int node = iter.next();
                if (!visited[node]){
                    visited[node] = true;
                    queue.add(node);
                }
            }

        }

        
        return order;
    }

    
  
    public lcadag reverse(){
        lcadag reversedDAG = new lcadag(this.vertnum);
        for (int i = 0; i < this.vertnum; i++){
            for (int j: adj(i)) {
                reversedDAG.addEdge(j, i); 
            }
        }
        return reversedDAG;
    }

}