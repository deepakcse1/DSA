package memoization;

public class DecodeWays {
  public static void main(String[] args) {

  }

  public int numDecodings(String s) {
    Integer[] dp = new Integer[s.length()];
    return helper(0, s, dp);
  }

  public int helper(int index, String s, Integer[] dp) {
    if (index == s.length()) return 1;
    if (s.charAt(index) == '0') return 0;
    if (dp[index] != null) return dp[index];
    int op1 = helper(index + 1, s, dp);
    int op2 = 0;
    if (index + 2 <= s.length()) {
      int num = Integer.parseInt(s.substring(index, index + 2));
      if (num >= 10 && num <= 26) {
        op2 = helper(index + 2, s, dp);
      }
    }
    return dp[index] = op1 + op2;
  }
}
