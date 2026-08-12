package memoization;

public class MinimumCostClimbingStairs {
  public static void main(String[] args) {

  }

  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    Integer[] dp = new Integer[n];
    int step1 = helper(0, cost, dp);
    int step2 = helper(1, cost, dp);
    return Math.min(step1, step2);
  }

  private int helper(int idx, int[] cost, Integer[] dp) {
    if (idx >= cost.length) return 0;
    if (dp[idx] != null) return dp[idx];
    int step1 = helper(idx + 1, cost, dp);
    int step2 = helper(idx + 2, cost, dp);
    return dp[idx] = cost[idx] + Math.min(step1, step2);
  }

  // public int minCostClimbingStairs(int[] cost) {
  //   int n = cost.length;
  //   Integer[] dp = new Integer[n + 1];
  //   return helper(-1, cost, dp);
  // }

  // public int helper(int index, int[] cost, Integer[] dp) {
  //   if (index >= cost.length) return 0;
  //   if (dp[index + 1] != null) return dp[index + 1];
  //   int step1 = helper(index + 1, cost, dp);
  //   int step2 = helper(index + 2, cost, dp);
  //   if (index == -1) return dp[index + 1] = Math.min(step1, step2);
  //   return dp[index + 1] = cost[index] + Math.min(step1, step2);
  // }
}
