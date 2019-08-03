import java.util.*;
import java.io.Serializable; 

class Graph implements Serializable{
	private static final long serialVersionUID=1L;  
	
	Map<Integer, List<Integer>> graph; 
	List<List<Integer>> edges;
	int n;
	int[][] adjMatrix;
	
	public Graph(int n, List<List<Integer>> edges){
		this.n = n;
		this.edges = edges;
		adjMatrix = new int[n][n];
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
	
	public void createAdjMatrix(){
		for(List<Integer> edge : edges){
			adjMatrix[edge.get(0)][edge.get(1)] = edge.get(2);
		}
	}
	
	public void printMatrix(){
		System.out.println("Edges = " + edges);
		for(int i = 0; i < adjMatrix.length; i++){
			System.out.println();
			for(int j = 0; j < adjMatrix.length; j++){
				System.out.print(adjMatrix[i][j]+ " ");
			}
		}	
	}
	
	public List<Integer> neighbours(int v){
		List<Integer> nbours = new ArrayList<>();
		for(int i = 0; i < adjMatrix.length; i++){
			if(adjMatrix[v][i] > 0)
			nbours.add(i);
		}
		return nbours;
	}
	
	public void updateWeight(int v1, int v2, int w){
		adjMatrix[v1][v2] = w;
	}
	
	public int getWeight(int v1, int v2){
		return adjMatrix[v1][v2];
	}
	
}
