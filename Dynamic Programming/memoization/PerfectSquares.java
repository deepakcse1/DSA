package memoization;

public class PerfectSquares {
  public static void main(String[] args) {

  }

  public int numSquares(int n) {
    Integer[] dp = new Integer[n + 1];
    return helper(n, dp);
  }

  public int helper(int n, Integer[] dp) {
    if (n == 0)
      return 0;
    if (dp[n] != null)
      return dp[n];
    int min = Integer.MAX_VALUE;
    for (int i = 1; i * i <= n; i++) {
      min = Math.min(min, helper(n - (i * i), dp));
    }
    return dp[n] = 1 + min;
  }
}
