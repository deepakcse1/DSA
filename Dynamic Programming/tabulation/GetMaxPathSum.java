package tabulation;

public class GetMaxPathSum {
  static int[][] dp;
  public static void main(String[] args) {
    int[][] matrix = {
      {2,3,10},
      {3,7,2},
      {1,1,5}
      // {1, 2, 10, 4},
      // {100, 3, 2, 1},
      // {1, 1, 20, 2},
      // {1, 2, 2, 1}
    };
    System.out.println(getMaxPathSum(matrix));
  }
  public static int getMaxPathSum(int[][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;
    dp = new int[m][n];
    for(int j = 0; j < n; j++){
      dp[0][j] = matrix[0][j];
    }
    for(int i = 1; i < m; i++){
      for(int j = 0; j < n; j++){
        int op1 = Integer.MIN_VALUE;
        int op2 = Integer.MIN_VALUE;
        int op3 = Integer.MIN_VALUE;
        op1 = dp[i-1][j];
        if(j < n-1) op2 = dp[i-1][j+1];
        if(j > 0) op3 = dp[i-1][j-1];
        dp[i][j] = matrix[i][j] + Math.max(op1, Math.max(op2, op3));
      }
    }
    int max = Integer.MIN_VALUE;
    for(int j = 0; j < n; j++){
      max = Math.max(max, dp[m-1][j]);
    }
    return max;
  }

}
