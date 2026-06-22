package memoization;

public class EditDistance {
  public int minDistance(String word1, String word2) {
    Integer[][] dp = new Integer[word1.length() + 1][word2.length() + 1];
    return helper(0, 0, word1, word2, dp);
  }

  public int helper(int idx1, int idx2, String word1, String word2, Integer[][] dp) {
    if (idx1 == word1.length()) return word2.length() - idx2;
    if (idx2 == word2.length()) return word1.length() - idx1;
    if (dp[idx1][idx2] != null) return dp[idx1][idx2];
    if (word1.charAt(idx1) == word2.charAt(idx2)) {
      return dp[idx1][idx2] = helper(idx1 + 1, idx2 + 1, word1, word2, dp);
    } else {
      int insert = 1 + helper(idx1, idx2 + 1, word1, word2, dp);
      int delete = 1 + helper(idx1 + 1, idx2, word1, word2, dp);
      int replace = 1 + helper(idx1 + 1, idx2 + 1, word1, word2, dp);
      return dp[idx1][idx2] = Math.min(insert, Math.min(delete, replace));
    }
  }
}
