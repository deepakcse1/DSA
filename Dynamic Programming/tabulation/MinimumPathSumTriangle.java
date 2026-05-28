package tabulation;

public class MinimumPathSumTriangle {
  static int[][] dp;
  public static void main(String[] args) {
    int[][] triangle = {
      {1},
      {2,3},
      {4,5,6},
      {7,8,9,10}
      // {2},
      // {3,4},
      // {6,5,7},
      // {4,1,8,3}
      // {-10}
    };
    int n = triangle.length;
    System.out.println(minimumPathSum(triangle, n));
  }

  public static int minimumPathSum(int[][] triangle, int n) {
    dp = new int[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        dp[i][j] = -1;
      }
    }
    return helper(triangle, n);
  }

  public static int helper(int[][] triangle, int n){
    for(int j = 0; j < n; j++){
      dp[n-1][j] = triangle[n-1][j];
    }
    for(int i = n-2; i >=0; i--){
      int option1, option2;
      for(int j = i; j>=0; j--){
        option1 = triangle[i][j] + dp[i+1][j];
        option2 = triangle[i][j] + dp[i+1][j+1];
        dp[i][j] =  Math.min(option1, option2);
      }
    }
    return dp[0][0];
  }
}
