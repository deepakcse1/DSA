/*
Problem statement
Given a chain of matrices A1, A2, A3,.....An. Your task is to find out the minimum cost to multiply these matrices. The cost of matrix multiplication is defined as the number of scalar multiplications. A Chain of matrices A1, A2, A3,.....An is represented by a sequence of numbers in an array ‘arr’ where the dimension of 1st matrix is equal to arr[0] * arr[1] , 2nd matrix is arr[1] * arr[2], and so on.

For example:
For arr[ ] = { 10, 20, 30, 40}, matrix A1 = [10 * 20], A2 = [20 * 30], A3 = [30 * 40]

Scalar multiplication of matrix with dimension 10 * 20 is equal to 200.

*/
package memoization;

public class MatrixChainMultiplication {
  static int[][] dp;
  public static void main(String[] args) {
    int[] arr = {4, 5, 3, 2};
    int n = arr.length;
    System.out.println(matrixMultiplication(arr,n));
  }
  public static int matrixMultiplication(int[] arr , int N) {
    dp = new int[N+1][N+1];
    for(int i = 0; i<= N; i++){
      for(int j = 0; j <= N; j++){
        dp[i][j] = -1;
      }
    }
		return helper(arr, 1, N-1);
	}
  private static int helper(int[] arr, int s, int e){
    //base case
    if(s == e) return 0;
    if(dp[s][e] != -1) return dp[s][e];
    //choices
    int min = Integer.MAX_VALUE;
    for(int k = s; k < e; k++){
       int temp = helper(arr, s, k) + helper(arr, k+1, e) + (arr[s-1] * arr[k] * arr[e]);
       min = Math.min(min, temp);
    }

    //optimal
    return dp[s][e] = min;
  }
}
