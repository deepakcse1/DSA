/*
Problem statement
For a given array with N elements, you need to find the length of the longest subsequence from the array such that all the elements of the subsequence are sorted in strictly increasing order.
Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.
*/
package memoization;

public class LIS {
  static int[][] dp;
  public static void main(String[] args) {
    int[] arr = {5, 4, 11, 1, 16, 8};
    System.out.println(longestIncreasingSubsequence(arr));
  }
  public static int longestIncreasingSubsequence(int arr[]) {
    int n = arr.length;
    dp = new int[n][n+1];
    for(int i = 0; i < n; i++){
      for(int j = 0; j <= n; j++){
        dp[i][j] = -1;
      }
    }
		return helper(arr, n, 0 , -1);
	}
  private static int helper(int arr[], int n, int idx, int prevIdx) {
    //base case
    if(idx == n) return 0;
    if(dp[idx][prevIdx+1] != -1) return dp[idx][prevIdx+1];
    //choices
    int take = 0;
    int notTake = helper(arr, n, idx+1,prevIdx);
    if(prevIdx == -1 || arr[idx] > arr[prevIdx]){
      take = 1 + helper(arr, n, idx+1, idx);
    }

    //optimal
    return dp[idx][prevIdx+1] =  Math.max(take, notTake);
  }
}
