/*
 * Problem statement
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

For Example :
If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
 */
package memoization;

public class SubsetSumToK {
  static boolean[][] dp;
  public static void main(String[] args) {
    int[] arr = {1,1,1,1};
    int k = 4;
    int n = arr.length;
    System.out.println(subsetSumToK(n, k, arr));
  }
  public static boolean subsetSumToK(int n, int k, int arr[]){
    dp = new boolean[n+1][k+1];
    for(int i = 0; i <= n; i++){
      for(int j = 0; j <= k; j++){
        dp[i][j] = false;
      }
    }
    return helper(arr, n-1, k);
  }
  private static boolean helper(int[] arr, int n, int k){
    //base case
    if(k == 0) return true;
    if(n < 0) return false;

    if(dp[n][k] != false) return dp[n][k];

    //choices
    boolean take = false;
    boolean notTake = helper(arr, n-1, k);
    if(arr[n] <= k){
      take = helper(arr, n-1, k - arr[n]);
    }

    //optimal
    return dp[n][k] = take || notTake;
  }
}
