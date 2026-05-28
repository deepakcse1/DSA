package tabulation;

import java.util.ArrayList;

public class MaxSum {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(1);
    list.add(3);
    list.add(5);
    list.add(8);
    list.add(1);
    list.add(9);
    System.out.println(maximumNonAdjacentSum(list));
  }
  public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
    int n = nums.size();
    if(n == 0) return 0;
    if(n ==1) return nums.get(1);
    int[] dp = new int[n];
    dp[0] = nums.get(0);
    dp[1] = Math.max(nums.get(0), nums.get(1));
    for(int i = 2; i < n; i++){
      int pick = nums.get(i) + dp[i-2];
      int notPick = dp[i-1];
      dp[i] = Math.max(pick, notPick);
    } 
    return dp[n-1];
	}
}
