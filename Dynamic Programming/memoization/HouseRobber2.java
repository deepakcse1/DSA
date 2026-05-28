package memoization;

import java.util.Arrays;

public class HouseRobber2 {
  public static void main(String[] args) {
        int[] arr1 = {2, 3, 2};
        // int[] arr2 = {1, 2, 3, 1};
        // int[] arr3 = {0};

        System.out.println(rob(arr1)); // 3
        // System.out.println(rob(arr2)); // 4
        // System.out.println(rob(arr3)); // 0
    }
    
    public static int rob(int[] nums) {
      int n = nums.length;
      if (n == 1) return nums[0];
      int[] dp1 = new int[n];
      int[] dp2 = new int[n];
      Arrays.fill(dp1, -1);
      Arrays.fill(dp2, -1);
      int case1 = helper(nums, 0, n - 2, dp1);
      int case2 = helper(nums, 1, n - 1, dp2);
      return Math.max(case1, case2);
    }
    
    private static int helper(int[] nums, int start, int end, int[] dp) {
      //base case
      if (start > end) return 0;
      if (dp[start] != -1) return dp[start];
      //choices
      int pick = nums[start] + helper(nums, start + 2, end, dp);
      int notPick = helper(nums, start + 1, end, dp);
      //optimal
      return dp[start] = Math.max(pick, notPick);
    }
}
