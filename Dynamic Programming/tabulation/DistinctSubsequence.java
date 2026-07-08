package tabulation;

public class DistinctSubsequence {
  public int numDistinct(String s, String t) {
    int[] dp = new int[t.length() + 1];
    dp[0] = 1;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = t.length(); j >= 1; j--) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[j] += dp[j - 1];
        }
      }
    }
    return dp[t.length()];
  }

  // public int numDistinct(String s, String t) {
  //   int m = s.length();
  //   int n = t.length();
  //   int[] next = new int[n + 1];
  //   next[n] = 1;
  //   for (int i = m - 1; i >= 0; i--) {
  //     int[] curr = new int[n + 1];
  //     curr[n] = 1;
  //     for (int j = n - 1; j >= 0; j--) {
  //       if (s.charAt(i) == t.charAt(j))
  //         curr[j] = next[j] + next[j + 1];
  //       else
  //         curr[j] = next[j];
  //     }
  //     next = curr;
  //   }
  //   return next[0];
  // }

  // public int numDistinct(String s, String t) {
  //   int[][] dp = new int[s.length() + 1][t.length() + 1];
  //   for (int i = 0; i <= s.length(); i++) {
  //     dp[i][t.length()] = 1;
  //   }
  //   for (int i = s.length() - 1; i >= 0; i--) {
  //     for (int j = t.length() - 1; j >= 0; j--) {
  //       int take = 0;
  //       if (s.charAt(i) == t.charAt(j)) {
  //         take = dp[i + 1][j + 1];
  //       }
  //       int notTake = dp[i + 1][j];
  //       dp[i][j] = take + notTake;
  //     }
  //   }
  //   return dp[0][0];
  // }
}
