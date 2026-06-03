package tabulation;

import java.util.Arrays;

public class PerfectSquares {
  public static void main(String[] args) {

  }

  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        min = Math.min(min, dp[i - (j * j)]);
      }
      dp[i] = 1 + min;
    }
    return dp[n];
  }
}
