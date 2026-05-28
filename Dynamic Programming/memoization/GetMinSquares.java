/*
 * Problem statement
A number can always be represented as a sum of squares of other numbers. Note that 1 is a square and we can always break a number as [(1 * 1) + (1 * 1) + (1 * 1) + …]. Given a number n, find the minimum number of squares that sum to n.
100 = (5^2) + (5^2) + (5^2) + (5^2) => 4 || 10^2 => 1 so ans = 1
 */
package memoization;

import java.util.Arrays;

public class GetMinSquares {
  static int[] dp;
  public static void main(String[] args) {
    int n = 100;
    System.out.println(minSquares(n));
  }
  public static int minSquares(int n){
     dp = new int[n+1];
     Arrays.fill(dp, -1);
     return helper(n);
  }
  private static int helper(int n){
    if(n == 0) return 0;
    if(dp[n] != -1) return dp[n];
    int minCount = Integer.MAX_VALUE;
    for(int i = 1; i*i <= n; i++){
      int square = i * i;
      int iCount = 1 + helper(n - square);
      minCount = Math.min(minCount, iCount);
    }
    return dp[n] = minCount;
  }
}
