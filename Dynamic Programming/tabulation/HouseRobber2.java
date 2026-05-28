package tabulation;

public class HouseRobber2 {
  public static void main(String[] args) {
    int[] arr = { 1, 3, 2, 1 };
    System.out.println(rob(arr));
  }

  public static int rob(int[] nums) {
    int n = nums.length;
    if (n == 1)
      return nums[0];
    int case1 = helper(0, n - 2, nums);
    int case2 = helper(1, n - 1, nums);
    return Math.max(case1, case2);
  }

  public static int helper(int start, int end, int[] nums) {
    int[] dp = new int[nums.length];
    dp[start] = nums[start];
    for (int i = start + 1; i <= end; i++) {
      int rob = nums[i];
      if (i - 2 >= start) {
        rob += dp[i - 2];
      }
      int skip = dp[i - 1];
      dp[i] = Math.max(rob, skip);
    }
    return dp[end];
  }
}
