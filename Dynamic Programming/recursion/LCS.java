/*
 * Problem statement
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.

For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.

Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
 */
package recursion;

public class LCS {
  public static void main(String[] args) {
    String s = "adebc";
    String t = "dcadb";
    System.out.println(longestCommonSubsequence(s, t));
  }
  public static int longestCommonSubsequence(String text1, String text2) {
    return helper(0, 0, text1, text2);
  }

  public static int helper(int i1, int i2, String t1, String t2) {
    if (i1 == t1.length() || i2 == t2.length()) return 0;
    if (t1.charAt(i1) == t2.charAt(i2)) {
      return 1 + helper(i1 + 1, i2 + 1, t1, t2);
    }
    int first = helper(i1 + 1, i2, t1, t2);
    int second = helper(i1, i2 + 1, t1, t2);
    return Math.max(first, second);
  }
}
