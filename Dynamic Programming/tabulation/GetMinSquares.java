package tabulation;

import java.util.Arrays;

public class GetMinSquares {
  static int[] dp;
  public static void main(String[] args) {
    int n = 13;
    System.out.println(getMinSquares(n));
  }
  public static int getMinSquares(int n) { 
     dp = new int[n+1];
     Arrays.fill(dp, Integer.MAX_VALUE);
     dp[0] = 0;
     for(int num = 1; num <= n; num++){
      for(int i = 1; i*i <= num; i++){
        int square = i*i;
        dp[num] = Math.min(dp[num], 1 + dp[num-square]);
      }
     }
     return dp[n];
  } 
}
