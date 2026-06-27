package tabulation;

public class CombinationSumFour {
  public int combinationSum4(int[] nums, int target) {
    // Arrays.sort(nums); -- further optimazation
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int t = 1; t <= target; t++) {
      int total = 0;
      for (int i = 0; i < nums.length; i++) {
        // if(nums[i] > t) break; -- further optimazation
        if (nums[i] <= t) {
          total += dp[t - nums[i]];
        }
      }
      dp[t] = total;
    }
    return dp[target];
  }
}
