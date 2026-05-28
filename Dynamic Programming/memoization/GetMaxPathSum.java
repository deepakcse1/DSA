package memoization;

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
  public static int getMaxPathSum(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    dp = new int[m][n];
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        dp[i][j] = -1;
      }
    }
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < matrix.length; i++){
      int ans = helper(matrix, 0, i,m ,n);
      if(ans > max) max = ans;
    }
    return max;
	}
  
    public static int helper(int[][] matrix, int row, int col, int m, int n) {
      // base case
      if (col < 0 || col >= n) return 0;
      if (row == m - 1) return matrix[row][col];
      if (dp[row][col] != -1) return dp[row][col];
      // choices
      // int opt1, opt2, opt3;
      // opt1 = matrix[row][col] + helper(matrix, row+1, col, m, n);
      // opt2 = matrix[row][col] + helper(matrix, row+1, col+1, m, n);
      // opt3 = matrix[row][col] + helper(matrix, row+1, col-1, m, n);

      // //optimal
      // return dp[row][col] = Math.max(opt1, Math.max(opt2,opt3));
      int down = helper(matrix, row + 1, col, m, n);
      int downLeft = helper(matrix, row + 1, col - 1, m, n);
      int downRight = helper(matrix, row + 1, col + 1, m, n);

      return dp[row][col] = matrix[row][col] + Math.max(down, Math.max(downLeft, downRight));
    }
}

// import java.util.*;

// public class Solution {
//     static int[][] dp;

//     public static int getMaxPathSum(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         dp = new int[m][n];
//         for (int[] row : dp)
//             Arrays.fill(row, -1);

//         int max = Integer.MIN_VALUE;
//         for (int col = 0; col < n; col++) {
//             max = Math.max(max, helper(matrix, 0, col, m, n));
//         }
//         return max;
//     }

//     private static int helper(int[][] matrix, int row, int col, int m, int n) {
//         // invalid column
//         if (col < 0 || col >= n) return Integer.MIN_VALUE;

//         // base case: last row
//         if (row == m - 1) return matrix[row][col];

//         // already computed
//         if (dp[row][col] != -1) return dp[row][col];

        // int down = helper(matrix, row + 1, col, m, n);
        // int downLeft = helper(matrix, row + 1, col - 1, m, n);
        // int downRight = helper(matrix, row + 1, col + 1, m, n);

        // return dp[row][col] = matrix[row][col] + Math.max(down, Math.max(downLeft, downRight));
//     }
// }
