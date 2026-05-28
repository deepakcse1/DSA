package memoization;

import java.util.Arrays;

public class JumpGame2 {
  public static void main(String[] args) {

  }

  public int jump(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return helper(0, nums, dp);
  }

  public int helper(int index, int[] nums, int[] dp) {
    if (index >= nums.length - 1)
      return 0;
    if (dp[index] != -1)
      return dp[index];
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= nums[index]; i++) {
      int ans = helper(index + i, nums, dp);
      if (ans != Integer.MAX_VALUE) {
        min = Math.min(min, 1 + ans);
      }
    }
    return dp[index] = min;
  }

}
