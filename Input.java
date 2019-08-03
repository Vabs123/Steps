import java.util.*;
import java.io.*;
class Input{

	private static void writeGraph(Graph g) {
		try{
			FileOutputStream fout=new FileOutputStream("WeightedGraph.txt");  
		  	ObjectOutputStream out=new ObjectOutputStream(fout);  
			out.writeObject(g);  
			out.flush();  
			out.close();  
			System.out.println("Write graph");
		}
		catch (Exception e) {}
	}
	
	private static Graph readGraph(){
		Graph g = null;
		try{
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("WeightedGraph.txt"));  
			g =(Graph)in.readObject();
			in.close();
			System.out.println("Read graph");
		}
		catch(Exception e){}
		return g;  
	}

	public static void main(String... s) throws Exception{
		Graph g = readGraph();
		if(g == null){
			Scanner in  = new Scanner(System.in);
			int n = in.nextInt();
			int m = in.nextInt();
			System.out.println("Is Weighted graph ? ");
			boolean isWeight = in.nextInt() > 0?true:false;
			List<List<Integer>> edges = new ArrayList<>();
			
			while(m-- > 0)		{
				if(isWeight)
					edges.add(Arrays.asList(in.nextInt(), in.nextInt(), in.nextInt()));
				else		
					edges.add(Arrays.asList(in.nextInt(), in.nextInt()));
				System.out.println("Remaining edges = " + m);
			}
			g = new Graph(n, edges);
			writeGraph(g);
		}
//		g.createGraph(false);
//		StronglyConnectedPoints scc = new StronglyConnectedPoints();
//		System.out.println(scc.getSccKR(g));
		//System.out.println(scc.getSccT(g));
		g.printMatrix();
		new MaxFlow().maxFlow(g);
	}
	
}
