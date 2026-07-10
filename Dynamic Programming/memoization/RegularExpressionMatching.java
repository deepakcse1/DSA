package memoization;

public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
    return helper(0, 0, s, p, dp);
  }

  public boolean helper(int i, int j, String s, String p, Boolean[][] dp) {
    if (j == p.length()) return i == s.length();
    if (dp[i][j] != null) return dp[i][j];
    boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
      return dp[i][j] = helper(i, j + 2, s, p, dp) || (match && helper(i + 1, j, s, p, dp));
    } else {
      return dp[i][j] = match && helper(i + 1, j + 1, s, p, dp);
    }
  }
}
