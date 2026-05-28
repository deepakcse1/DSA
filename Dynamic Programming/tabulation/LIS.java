/*
Problem statement
For a given array with N elements, you need to find the length of the longest subsequence from the array such that all the elements of the subsequence are sorted in strictly increasing order.
Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.
*/
package tabulation;

import java.util.*;

public class LIS {
  static int[][] dp;
  public static void main(String[] args) {
    int[] arr = {5, 4, 11, 1, 16, 8};
    // System.out.println(longestIncreasingSubsequence(arr));
    // System.out.println(optimizedLIS(arr));
    System.out.println(advanceOptimizedLIS(arr));
  }
  public static int longestIncreasingSubsequence(int arr[]) {
    int n = arr.length;
    dp = new int[n+1][n+1];
    for(int i = n-1; i >= 0; i--){
      for(int j = i-1; j >= -1; j--){
        int take = 0;
        int notTake = dp[i+1][j+1];
        if(j == -1 || arr[i] > arr[j]) take = 1 + dp[i+1][i+1]; //second i+1 is for shifting the index by 1 to accomodate -1 case 
        dp[i][j+1] = Math.max(take, notTake);
      }
    }
    return dp[0][0];
  }

  public static int optimizedLIS(int[] arr){
    int n = arr.length;
    int[] curr = new int[n+1];
    int[] next = new int[n+1];
    for(int i = n-1; i >= 0; i--){
      for(int j = i-1; j >= -1; j--){
        int take = 0;
        int notTake = next[j+1];
        if(j == -1 || arr[i] > arr[j]) take = 1 + next[i+1];
        curr[j+1] = Math.max(take, notTake);
      }
      int[] temp = curr;
      curr = next;
      next = temp;
    }
    return next[0];
  }
  
  //using binary search O(nLogn)
  public static int advanceOptimizedLIS(int[] nums) {
    List<Integer> gulp = new ArrayList<>(); // gulp will store the increasing subsequence, but not necessarily the actual subsequence, just the length of it
    for (int num : nums) {
      int left = 0;
      int right = gulp.size();
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (gulp.get(mid) >= num) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      if (left == gulp.size())
        gulp.add(num);
      else
        gulp.set(left, num);
    }
    return gulp.size();
  }
}
