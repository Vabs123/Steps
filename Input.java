import java.util.*;
class Input{

	public static void main(String... s){
		Scanner in  = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		List<List<Integer>> edges = new ArrayList<>();
		while(m-- > 0)		{		
			edges.add(Arrays.asList(in.nextInt(), in.nextInt()));
		}
		Graph g = new Graph(n, edges);
		g.createGraph(false);
		StronglyConnectedPoints scc = new StronglyConnectedPoints();
		System.out.println(scc.getSccKR(g));
		//System.out.println(scc.getSccT(g));
	}
}
