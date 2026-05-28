/*
Problem statement
You have been given a string ‘A’ consisting of lower case English letters. Your task is to find the length of the longest palindromic subsequence in ‘A’.

A subsequence is a sequence generated from a string after deleting some or no characters of the string without changing the order of the remaining string characters. (i.e. “ace” is a subsequence of “abcde” while “aec” is not).

A string is said to be palindrome if the reverse of the string is the same as the actual string. For example, “abba” is a palindrome, but “abbc” is not a palindrome.
*/
package tabulation;
class LongestPalindromeSubsequence{
   public static void main(String[] args) {
    String str = "bbabcbcab";
    // System.out.println(longestPalindromeSubsequence2D(str));
    System.out.println(longestPalindromeSubsequence1D(str));
   }

   //Method 1 - 2D DP
   public static int longestPalindromeSubsequence2D(String s) {
    int n = s.length();
    String sRev = reverse(s);
    int[][] dp =  new int[n+1][n+1];
    for(int i = 1; i <= n; i++){
      for(int j = 1; j <= n; j++){
        if(s.charAt(i-1) == sRev.charAt(j-1)){
          dp[i][j] = 1 + dp[i-1][j-1];
        }else{
          int op1 = dp[i-1][j];
          int op2 = dp[i][j-1];
          dp[i][j] = Math.max(op1, op2);
        }
      }
    }
    return dp[n][n];
   }

   //Method 2 - 1D DP
    public static int longestPalindromeSubsequence1D(String s) {
      int n = s.length();
      String sRev = reverse(s);
      int[] prev = new int[n+1];
      int[] curr = new int[n+1];
      for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
          if(s.charAt(i-1) == sRev.charAt(j-1)){
            curr[j] = 1 + prev[j-1];
          }else{
            curr[j] = Math.max(prev[j], curr[j-1]);
          }
        }
        int[] temp = prev;
        prev = curr;
        curr = temp;
      }
      return prev[n];
    }

   private static String reverse(String str){
    String revStr = "";
    for(int i = str.length() - 1; i >= 0; i--) revStr += str.charAt(i);
    return revStr;
   }
}