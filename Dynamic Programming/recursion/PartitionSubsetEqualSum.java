package recursion;

public class PartitionSubsetEqualSum {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if (sum % 2 != 0) return false;
    Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];
    return helper(0, sum / 2, nums, dp);
  }

  public boolean helper(int idx, int target, int[] nums, Boolean[][] dp) {
    if (target == 0) return true;
    if (idx >= nums.length || target < 0) return false;
    if (dp[idx][target] != null) return dp[idx][target];
    boolean take = helper(idx + 1, target - nums[idx], nums, dp);
    boolean notTake = helper(idx + 1, target, nums, dp);
    return dp[idx][target] = take || notTake;
  }
}
