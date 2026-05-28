package tabulation;

public class DecodeWays {
  public static void main(String[] args) {

  }

  public int numDecodings(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[n] = 1;
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        dp[i] = 0;
        continue;
      }
      int op1 = dp[i + 1];
      int op2 = 0;
      if (i + 2 <= n) {
        int num = Integer.parseInt(s.substring(i, i + 2));
        if (num >= 10 && num <= 26) {
          op2 = dp[i + 2];
        }
      }
      dp[i] = op1 + op2;
    }
    return dp[0];
  }
}
