package memoization;

public class KnapsackProblem {
  public int knapsack(int W, int val[], int wt[]) {
    Integer[][] dp = new Integer[val.length + 1][W + 1];
    return helper(0, W, val, wt, dp);
  }

  public int helper(int idx, int W, int val[], int wt[], Integer[][] dp) {
    if (W == 0 || idx == val.length) return 0;
    if (dp[idx][W] != null) return dp[idx][W];
    int take = 0;
    if (wt[idx] <= W) {
      take = val[idx] + helper(idx + 1, W - wt[idx], val, wt, dp);
    }
    int notTake = helper(idx + 1, W, val, wt, dp);
    return dp[idx][W] = Math.max(take, notTake);
  }
}
