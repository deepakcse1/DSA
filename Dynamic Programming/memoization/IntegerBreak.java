package memoization;

public class IntegerBreak {
  public static void main(String[] args) {

  }

  public int integerBreak(int n) {
    Integer[] dp = new Integer[n + 1];
    return helper(n, dp);
  }

  public int helper(int n, Integer[] dp) {
    if (n == 1) return 1;
    if (dp[n] != null) return dp[n];
    int max = 0;
    for (int i = 1; i < n; i++) {
      int ans = i * Math.max(n - i, helper(n - i, dp));
      max = Math.max(max, ans);
    }
    return dp[n] = max;
  }
}
