package memoization;

import java.util.List;

public class WordBreak {
  public static void main(String[] args) {

  }

  public boolean wordBreak(String s, List<String> wordDict) {
    Boolean[] dp = new Boolean[s.length()];
    return helper(0, s, wordDict, dp);
  }

  public boolean helper(int index, String s, List<String> wordDict, Boolean[] dp) {
    if (index == s.length()) return true;
    if (dp[index] != null) return dp[index];
    for (String word : wordDict) {
      if (index + word.length() <= s.length() && s.substring(index, index + word.length()).equals(word)) {
        if (helper(index + word.length(), s, wordDict, dp)) return dp[index] = true;
      }
    }
    return dp[index] = false;
  }
}