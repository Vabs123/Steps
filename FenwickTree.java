import java.util.*;
import java.util.stream.*;
class FenwickTree{
	int[] f;
	
	public FenwickTree(int n){
		f = new int[n];
	}
	
	public void updateIndex(int index, int val){
		while(index < f.length){
			f[index] += val;
			index += (index & (-index));
		}
	}
	
	public void createFenwickTree(int[] n){
		for(int i = 1; i <= n.length; i++){
			updateIndex(i, n[i - 1]);
		}
	}
	
	public int query(int index){
		int val = 0;
		while(index > 0){
			val += f[index];
			index &= (index - 1);
		}
		return val;
	}
	
	public int query(int index1, int index2){
		return query(index2) - query(index1);
	} 
	
	@Override 
	public String toString(){
		List<Integer> l = Arrays.stream(f).boxed().collect(Collectors.toList());
		return l.toString();
	}
	
	public static void main(String... s){
		Scanner in = new Scanner(System.in);
		int n  = in.nextInt();
		int[] input = new int[n];
		FenwickTree ft = new FenwickTree(n + 1);
		for(int i = 0; i < n; i++){
			input[i] = in.nextInt();
		}
		ft.createFenwickTree(input);
		int q = in.nextInt();
		while(q > 0){
			char query = in.next().charAt(0);
			switch(query){
				case 'u':
					int index = in.nextInt();
					int val = in.nextInt();
					ft.updateIndex(index, val);
					break;
				case 'r':
					int index1 = in.nextInt();
					int index2 = in.nextInt();
					System.out.println(ft.query(index1, index2));
					break;
				case 'q':
					index = in.nextInt();
					System.out.println(ft.query(index));
					break;
				case 'p':
					System.out.println(ft);
					break;
			}
			System.out.println("More Queries? 0/1 -> ");
			q = in.nextInt();
		}
	}		
}
