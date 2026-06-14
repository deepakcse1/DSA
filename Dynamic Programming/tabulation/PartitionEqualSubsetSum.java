package tabulation;

public class PartitionEqualSubsetSum {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if (sum % 2 != 0) return false;
    int target = sum / 2;
    int n = nums.length;
    boolean[][] dp = new boolean[n + 1][target + 1];
    for (int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }
    for (int idx = n - 1; idx >= 0; idx--) {
      for (int t = 1; t <= target; t++) {
        boolean take = false;
        if (nums[idx] <= t) {
          take = dp[idx + 1][t - nums[idx]];
        }
        boolean notTake = dp[idx + 1][t];
        dp[idx][t] = take || notTake;
      }
    }
    return dp[0][target];
  }
}
