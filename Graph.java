import java.util.*;
class Graph{
	Map<Integer, List<Integer>> graph; 
	List<List<Integer>> edges;
	int n;
	
	public Graph(int n, List<List<Integer>> edges){
		this.n = n;
		this.edges = edges;
	}
	
	private void initGraph(){
		graph = new HashMap<Integer, List<Integer>>();
		for(int i = 1; i <= n; i++)
			graph.put(i, new ArrayList<Integer>());
	}
	
	public void createGraph(boolean reverse){
		initGraph();
		for(List<Integer> edge : edges){
			if(reverse)
				Collections.reverse(edge);
			graph.get(edge.get(0)).add(edge.get(1));
		}
	}
}
