package tabulation;

public class MinimumCostClimbingStairs {
  public static void main(String[] args) {

  }
  
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length; // 3
    // int[] dp = new int[n+2];
    int nextOfNext = 0;
    int next = 0;
    for (int idx = n - 1; idx >= 0; idx--) {
      int curr = cost[idx] + Math.min(nextOfNext, next);
      nextOfNext = next;
      next = curr;
    }
    return Math.min(nextOfNext, next);
  }

  // public int minCostClimbingStairs(int[] cost) {
  //   int n = cost.length;
  //   int[] dp = new int[n + 1];
  //   for (int index = n - 1; index >= 0; index--) {
  //     int step1 = dp[index + 1];
  //     int step2 = (index + 2 < n) ? dp[index + 2] : 0;
  //     dp[index] = cost[index] + Math.min(step1, step2);
  //   }
  //   return Math.min(dp[0], dp[1]);
  // }
}
