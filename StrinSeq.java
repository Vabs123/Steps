import java.util.*;

class StrinSeq{
	
	private static void findLongestSeq(String s1, String s2){
		int[][] dp = new int[s2.length() + 1][s1.length + 1];
		for(int i = 0; i < s2.length(); i++){
			dp = new int[s1.length()];
			for(int j = 0; j < s1.length(); j++){
				dp[i + 1][j + 1] = s2.charAt(i) == s1.charAt(j)? 
				dp[i][j] + 1:Math.max(dp[i][j + 1], dp[i + 1][j]);
			}
		}
		LinkedList<Integer> st1 = new LinkedList<>();
		LinkedList<Integer> st2 = new LinkedList<>();
		
		int i = s2.length();
		int j = s1.length();
		while(i > 0 && j > 0){
			if(dp[i][j] > dp[i - 1][j] && dp[i][j] > dp[i][j - 1]){
				st1.push(--j);
				st2.push(--i);
			}
		}
	}
	
	public static void main(String... s){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		String s1 = in.next();
		String s2 = in.next();
	}
}
