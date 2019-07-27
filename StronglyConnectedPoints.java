
import java.util.*;

class StronglyConnectedPoints{
	
	//KosaRajuAlgo
	public List<List<Integer>> getSccKR(Graph g){
		LinkedList<Integer> st = new LinkedList<>();
		Set<Integer> vis = new HashSet<>();
		for(int i = 1; i <= g.n; i++){
			if(!vis.contains(i))
				dfsKR(i, g, vis, st);
		}
		vis = new HashSet<Integer>();
		List<List<Integer>> scc = new ArrayList<>();
		g.createGraph(true);
		LinkedList<Integer> sc = new LinkedList<>();
		while(!st.isEmpty()){
			int cur = st.poll();
			if(vis.contains(cur)) continue;
			dfsKR(cur, g, vis, sc);
			scc.add(sc);
			sc = new LinkedList<Integer>();
		}
		return scc;
	}
	
	private void dfsKR(int cur, Graph g, Set<Integer> vis, LinkedList<Integer> st){
		vis.add(cur);
		for(Integer nbr : g.graph.get(cur)){
			if(!vis.contains(nbr))
				dfsKR(nbr, g, vis, st);
		}
		st.push(cur);
	}
		
}
