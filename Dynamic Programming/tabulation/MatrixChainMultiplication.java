/*
Problem statement
Given a chain of matrices A1, A2, A3,.....An. Your task is to find out the minimum cost to multiply these matrices. The cost of matrix multiplication is defined as the number of scalar multiplications. A Chain of matrices A1, A2, A3,.....An is represented by a sequence of numbers in an array ‘arr’ where the dimension of 1st matrix is equal to arr[0] * arr[1] , 2nd matrix is arr[1] * arr[2], and so on.

For example:
For arr[ ] = { 10, 20, 30, 40}, matrix A1 = [10 * 20], A2 = [20 * 30], A3 = [30 * 40]

Scalar multiplication of matrix with dimension 10 * 20 is equal to 200.

*/
package tabulation;

public class MatrixChainMultiplication {
  public static void main(String[] args) {
    int[] arr = {4, 5, 3, 2};
    int n = arr.length;
    System.out.println(matrixMultiplication(arr,n));
  }
  public static int matrixMultiplication(int[] arr , int N) {
    int[][] dp = new int[N+1][N+1];
    for(int i = N-1; i >= 1; i--){
      for(int j = i+1; j < N; j++){
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
          int temp = dp[i][k] + dp[k+1][j] + (arr[i-1] * arr[k] * arr[j]);
          min = Math.min(min, temp);
        }
        dp[i][j] = min;
      }
    }
    return dp[1][N-1];
  }
}
