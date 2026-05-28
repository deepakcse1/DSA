/*Problem statement
You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.
Since the number of ways can be very large, print it modulo 10 ^ 9 + 7 (1000000007)
Example:
Input: 'arr' = [1, 1, 4, 5], target = 5
Output: 3
Explanation: The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently. */
package tabulation;

public class FindWays {
  static int[] dp;
  static final int MOD = 1_000_000_007;
  public static void main(String[] args) {
    int[] num =  {0,1,3};
    int tar = 4;
    System.out.println(findWays(num, tar));
  }
  public static int findWays(int num[], int tar) {
    dp = new int[tar + 1];
    dp[0] = 1;
    for(int i : num){
      for(int j = tar; j >= i; j--){
        dp[j] = (dp[j] + dp[j - i]) % MOD;
      }
    }
    return dp[tar];
  }
  
}
