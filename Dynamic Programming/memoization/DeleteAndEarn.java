package memoization;

public class DeleteAndEarn {
  public int deleteAndEarn(int[] nums) {
    int max = 0;
    for (int i : nums) {
      max = Math.max(i, max);
    }
    int[] points = new int[max + 1];
    for (int i : nums) {
      points[i] += i;
    }
    int n = points.length;
    Integer[] dp = new Integer[n];
    return helper(0, points, dp);
  }

  private int helper(int idx, int[] points, Integer[] dp) {
    if (idx >= points.length) return 0;
    if (dp[idx] != null) return dp[idx];
    int take = points[idx] + helper(idx + 2, points, dp);
    int notTake = helper(idx + 1, points, dp);
    return dp[idx] = Math.max(take, notTake);
  }
}
