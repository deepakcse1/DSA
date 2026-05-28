/*
 * Problem statement
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.

For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.

Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
 */
package tabulation;

public class LCS {
  static int[][] dp;
  public static void main(String[] args) {
    String s = "adebc";
    String t = "dcadb";
    // System.out.println(lcs(s, t));
    System.out.println(longestCommonSubsequence(s, t));
  }
  public static int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length(), n = text2.length();
    // int[][] dp = new int[m+1][n+1];
    int[] nextRow = new int[n + 1];
    for (int row = m - 1; row >= 0; row--) {
      int[] curRow = new int[n + 1];
      for (int col = n - 1; col >= 0; col--) {
        if (text1.charAt(row) == text2.charAt(col)) {
          curRow[col] = 1 + nextRow[col + 1]; // dp[row+1][col+1];
        } else {
          int first = nextRow[col];// dp[row+1][col];
          int second = curRow[col + 1];// dp[row][col+1];
          curRow[col] = Math.max(first, second);
        }
      }
      nextRow = curRow;
    }
    return nextRow[0];
  }
}
