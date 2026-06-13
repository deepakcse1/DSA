package tabulation;

public class HouseRobber2 {
  public static void main(String[] args) {
    int[] arr = { 1, 3, 2, 1 };
    System.out.println(rob(arr));
  }

  public static int rob(int[] nums) {
    int n = nums.length;
    if(n == 1) return nums[0];
    int case1 = helper(0, n-2, nums);
    int case2 = helper(1, n-1, nums);
    return Math.max(case1, case2);
  }

  public static int helper(int start, int end, int[] nums) {
    int[] dp = new int[nums.length];
    dp[end] = nums[end];
    for(int i = end-1; i >= start; i--){
        int take = nums[i];
        if(i + 2 < nums.length){
            take += dp[i + 2];
        }
        int notTake = 0 + dp[i + 1];
        dp[i] = Math.max(take, notTake);
    }
    return dp[start];
  }
}
