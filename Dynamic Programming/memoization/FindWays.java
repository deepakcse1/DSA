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
package memoization;

public class FindWays {
  static int[][] dp;
  public static void main(String[] args) {
    int[] num =  {0,1,3};
    int tar = 4;
    System.out.println(findWays(num, tar));
  }
  public static int findWays(int num[], int tar) {
    dp = new int[num.length][tar + 1];
    for(int i = 0; i < num.length; i++){
      for(int j = 0; j <= tar; j++){
        dp[i][j] = -1;
      }
    }
    return helper(num,num.length -1, tar);
  }

  private static int helper(int[] num, int n, int tar){
    //base case
    if(tar == 0) return 1;
    if(n < 0 || tar < 0) return 0;
    if(dp[n][tar] != -1) return dp[n][tar];
    //choices
    int notTake = helper(num, n-1, tar);
    int take = 0;
    if(num[n] <= tar){
      take = helper(num, n-1, tar - num[n]);
    }
    //optimal
    return dp[n][tar] = (take + notTake) % 1000000007;
  } 
}


