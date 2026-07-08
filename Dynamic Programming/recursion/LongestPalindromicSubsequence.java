package recursion;

public class LongestPalindromicSubsequence {
  public int longestPalindromeSubseq(String s) {
    return helper(0, s.length() - 1, s);
  }

  public int helper(int i, int j, String s) {
    if (i == j) return 1;
    if (i > j) return 0;
    if (s.charAt(i) == s.charAt(j)) {
      return 2 + helper(i + 1, j - 1, s);
    } else {
      return Math.max(helper(i + 1, j, s),helper(i, j - 1, s));
    }
  }
}
