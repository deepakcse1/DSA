package memoization;

public class DistinctSubsequences {
  public int numDistinct(String s, String t) {
    Integer[][] dp = new Integer[s.length() + 1][t.length() + 1];
    return helper(0, 0, s, t, dp);
  }

  public int helper(int idx1, int idx2, String s, String t, Integer[][] dp) {
    if (s.length() - idx1 < t.length() - idx2)
      return 0;
    if (idx2 == t.length())
      return 1;
    if (idx1 == s.length())
      return 0;
    if (dp[idx1][idx2] != null)
      return dp[idx1][idx2];
    int take = 0;
    if (s.charAt(idx1) == t.charAt(idx2)) {
      take = helper(idx1 + 1, idx2 + 1, s, t, dp);
    }
    int notTake = helper(idx1 + 1, idx2, s, t, dp);
    return dp[idx1][idx2] = take + notTake;
  }
}
