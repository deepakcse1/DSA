package tabulation;

public class IntegerBreak {
  public static void main(String[] args) {

  }

  public int integerBreak(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      int max = 0;
      for (int j = 1; j < i; j++) {
        int ans = j * Math.max(i - j, dp[i - j]);
        max = Math.max(max, ans);
      }
      dp[i] = max;
    }
    return dp[n];
  }
}
