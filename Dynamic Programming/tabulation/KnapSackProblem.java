package tabulation;

public class KnapSackProblem {
  public int knapsack(int W, int val[], int wt[]) {
    int n = val.length;
    int[][] dp = new int[n + 1][W + 1];
    for (int idx = n - 1; idx >= 0; idx--) {
      for (int w = 1; w <= W; w++) {
        int take = 0;
        if (wt[idx] <= w) {
          take = val[idx] + dp[idx + 1][w - wt[idx]];
        }
        int notTake = dp[idx + 1][w];
        dp[idx][w] = Math.max(take, notTake);
      }
    }
    return dp[0][W];
  }
}
