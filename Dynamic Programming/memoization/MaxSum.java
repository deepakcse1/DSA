package memoization;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSum {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(4);
    // list.add(3);
    // list.add(1);
    // list.add(3);
    // list.add(5);
    // list.add(8);
    // list.add(1);
    // list.add(9);
    int n = list.size();
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    System.out.println(maximumNonAdjacentSum(list, n-1, dp));
  }
  public static int maximumNonAdjacentSum(ArrayList<Integer> list, int n , int[] dp) {
    if(n == 0) return list.get(0);
    if(n < 0) return 0;
    if(dp[n] != -1) return dp[n];
    int pick = list.get(n) + maximumNonAdjacentSum(list, n-2,dp);
    int notPick = maximumNonAdjacentSum(list, n-1, dp);
    return dp[n] = Math.max(pick, notPick);
	}
  
}
