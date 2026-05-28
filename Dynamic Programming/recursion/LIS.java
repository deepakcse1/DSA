/*
Problem statement
For a given array with N elements, you need to find the length of the longest subsequence from the array such that all the elements of the subsequence are sorted in strictly increasing order.
Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.
*/
package recursion;

public class LIS {
  public static void main(String[] args) {
    int[] arr = {5, 4, 11, 1, 16, 8};
    System.out.println(longestIncreasingSubsequence(arr));
  }
  public static int longestIncreasingSubsequence(int arr[]) {
		return helper(arr, arr.length, 0 , -1);
	}
  private static int helper(int arr[], int n, int idx, int pI) {
    //base case
    if(idx == n) return 0;

    //choices
    int take = 0;
    int notTake = helper(arr, n, idx+1,pI);
    if(pI == -1 || arr[idx] > arr[pI]){
      take = 1 + helper(arr, n, idx+1, idx);
    }

    //optimal
    return Math.max(take, notTake);
  }
}
