package memoization;

public class CombinationSumFour {
    public int combinationSum4(int[] nums, int target) {
      Integer[] dp = new Integer[target+1];
      return helper(target, nums, dp);
    }
    public int helper(int target, int[] nums, Integer[] dp){
      if(target == 0) return 1;
      if(dp[target] != null) return dp[target];
      int total = 0;
      for(int i = 0; i < nums.length; i++){
          if(nums[i] <= target){
            total += helper(target - nums[i], nums, dp);
          }
      }
      return dp[target] = total;
    }
}
