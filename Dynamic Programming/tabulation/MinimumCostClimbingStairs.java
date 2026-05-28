package tabulation;

public class MinimumCostClimbingStairs {
  public static void main(String[] args) {

  }

  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] dp = new int[n + 1];
    for (int index = n - 1; index >= 0; index--) {
      int step1 = dp[index + 1];
      int step2 = (index + 2 < n) ? dp[index + 2] : 0;
      dp[index] = cost[index] + Math.min(step1, step2);
    }
    return Math.min(dp[0], dp[1]);
  }
}
