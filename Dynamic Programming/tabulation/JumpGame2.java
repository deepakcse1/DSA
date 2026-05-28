package tabulation;

import java.util.Arrays;

public class JumpGame2 {
  public static void main(String[] args) {

  }

  // Greedy solution
  public int jump_Greedy_best_solution(int[] nums) {
    int jumps = 0;
    int farthest = 0;
    int currentEnd = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      farthest = Math.max(farthest, i + nums[i]);
      if (i == currentEnd) {
        jumps++;
        currentEnd = farthest;
      }
    }
    return jumps;
  }

  // Tabulation solution
  public int jump(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--) {
      for (int j = 1; j <= nums[i] && i + j < n; j++) {
        if (dp[i + j] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], 1 + dp[i + j]);
        }
      }
    }
    return dp[0];
  }
}
