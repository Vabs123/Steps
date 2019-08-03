import java.util.*;

class MaxFlow{
	
	public void maxFlow(Graph g){
		Map<Integer, Integer> parent;
		LinkedList<Integer> q;
		int totalFlow = 0;
		List<List<Integer>> paths = new ArrayList<>();
		while(true){
			parent = new HashMap<>();
			parent.put(0, -1);
			q = new LinkedList<>();
			q.add(0);
			List<Integer> flowPath = canFlow(g, parent, q, 6) ;
			if(flowPath == null) break;
			totalFlow += flowPath.get(0);
			paths.add(flowPath);
		}
		System.out.println("Total FLow = " + totalFlow + "\nPaths : \n" + paths);
	}
	
	private List<Integer> canFlow(Graph g, Map<Integer, Integer> parent, LinkedList<Integer> q, int target){
		while(!q.isEmpty()){
			int cur = q.poll();
			for(Integer i : g.neighbours(cur)){
				if(!parent.containsKey(i)){
					q.add(i);
					parent.put(i, cur);
					if(i == target)
						return getMinFlowAndPath(g, parent, target);
				}
			}
		}
		return null;
	}
	
	private List<Integer> getMinFlowAndPath(Graph g, Map<Integer, Integer> parent, int target){
		List<Integer> ans = new ArrayList<>();
		int minPath = Integer.MAX_VALUE;
		LinkedList<Integer> st = new LinkedList<>();
		st.push(target);
		int cur = target;
		while(parent.get(cur) != -1){
			int p = parent.get(cur);
			minPath = Math.min(minPath, g.getWeight(p, cur));
			st.push(p);
			cur = p;
		}
		ans.add(minPath);
		ans.addAll(st);
		cur = st.poll();
		while(!st.isEmpty()){
			int child = st.poll();
			g.updateWeight(cur, child, g.getWeight(cur, child) - minPath);
			g.updateWeight(child, cur, g.getWeight(child, cur) + minPath);
			cur = child;
		}
		return ans;
	}
	
}
