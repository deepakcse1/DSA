/*
 * Problem statement
You are given an array 'ARR' of 'N' positive integers. Your task is to find if we can partition the given array into two subsets such that the sum of elements in both subsets is equal.

For example, let’s say the given array is [2, 3, 3, 3, 4, 5], then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.

Follow Up:

Can you solve this using not more than O(S) extra space, where S is the sum of all elements of the given array?
 */
package memoization;

public class CanPartition {
  static boolean[][] dp;
  public static void main(String[] args) {
    int[] arr = {2, 3, 3, 3, 4, 5};
    System.out.println(canPartition(arr, arr.length));
  }
  public static boolean canPartition(int[] arr, int n) {
    int sum = 0;
    for(int num : arr) sum += num;
    if(sum % 2 != 0) return false;
    int halfSum = sum / 2;
    dp = new boolean[n+1][halfSum + 1];
    return helper(arr, n-1, halfSum);
	}
  private static boolean helper(int[] arr, int n, int k){
    //base case
    if(k == 0) return true;
    if(n < 0) return false;
    if(dp[n][k] != false) return dp[n][k];
    //choices
    boolean take = false;
    boolean notTake = helper(arr, n-1, k);
    if(arr[n] <= k) take = helper(arr, n-1, k - arr[n]);
    //optimal
    return dp[n][k] = take || notTake;
  }
}

