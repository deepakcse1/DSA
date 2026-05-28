package tabulation;

public class UnboundKnapsack_CutRod {

  public static void main(String[] args) {
    int[] price = {3, 5, 6, 7, 10, 12};
    int n = price.length;
    System.out.println(cutRod2D(price, n));
    System.out.println(cutRod1D(price, n));
  }
  //approach 1 using 2D DP
  public static int cutRod2D(int[] price, int n){
    int[][] dp = new int[n][n+1];
    for(int i = 0; i <= n; i++){
      dp[0][i] = price[0]*i;
    }
    for(int i = 1; i < n; i++){
      int curLen = i+1;
      for(int ln = 0; ln <= n; ln++){
        int notTake = dp[i-1][ln];
        int take = Integer.MIN_VALUE;
        if(curLen <= ln){
          take = price[i] + dp[i][ln - curLen];
        }
        dp[i][ln] = Math.max(notTake, take);
      }
    }
    return dp[n-1][n];
  }
  //approach 2 using 1D DP
  public static int cutRod1D(int[] price, int n){
    int[] dp = new int[n+1];
    for(int i = 0; i <= n; i++){
      dp[i] = price[0]*i;
    }
    for(int i = 1; i<n; i++){
      int curLen = i+1;
      for(int ln = 0; ln <= n; ln++){
         if(curLen <= ln){
          dp[ln] = Math.max(dp[ln], price[i] + dp[ln-curLen]);
         }
      }
    }
    return dp[n];
  }

}
