/*
Problem statement
You have been given a string ‘A’ consisting of lower case English letters. Your task is to find the length of the longest palindromic subsequence in ‘A’.

A subsequence is a sequence generated from a string after deleting some or no characters of the string without changing the order of the remaining string characters. (i.e. “ace” is a subsequence of “abcde” while “aec” is not).

A string is said to be palindrome if the reverse of the string is the same as the actual string. For example, “abba” is a palindrome, but “abbc” is not a palindrome.
*/
package recursion;

public class LongestPalindromeSubsequence {
  public static void main(String[] args) {
    String str = "abcd";
    System.out.println(longestPalindromeSubsequence(str));
  }
  public static int longestPalindromeSubsequence(String s) {
		// Write your code here.
    return helper(s, 0, s.length()-1);
	}
  private static int helper(String str, int s, int e){
    if(s == e) return 1;
    if(s > e) return 0;
    if(str.charAt(s) == str.charAt(e)){
       return 2 + helper(str, s+1, e-1);
    }else{
      int op1 = helper(str, s+1, e);
      int op2 = helper(str, s, e-1);
      return Math.max(op1, op2);
    } 
  }
}
