package memoization;

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
    return helper(triangle, n , 0, 0);
  }
  public static int helper(int[][] triange, int n, int row, int col){
    //base case
    if(row == n-1) return triange[row][col];
    if(dp[row][col] != -1) return dp[row][col];

    //choices
    int option1, option2;
    option1 = triange[row][col] + helper(triange, n, row+1, col);
    option2 = triange[row][col] + helper(triange, n, row+1, col+1);

    //optimal substructure
    int ans = Math.min(option1, option2);
    dp[row][col] = ans;
    return ans;
  }
}
