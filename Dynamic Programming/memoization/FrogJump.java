package memoization;

import java.util.Arrays;

public class FrogJump {
  public static void main(String[] args) {
    int[] heights = {10, 20, 30, 10};
    int n = heights.length;
    System.out.println(frogJump(n, heights));
  }

  public static int frogJump(int n, int heights[]) {
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return helper(n-1, heights, dp);
  }

  public static int helper(int n, int[] heights, int[] dp){
    if(n == 0) return 0;
    if(dp[n] != -1) return dp[n]; 
    int left = helper(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
    int right = Integer.MAX_VALUE;
    if(n > 1){
      right = helper(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]);
    }
    return dp[n] = Math.min(left, right);
  }

  
}
