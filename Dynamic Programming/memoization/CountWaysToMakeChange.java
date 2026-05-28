package memoization;

public class CountWaysToMakeChange {
  static long dp[][];
  public static void main(String[] args) {
    int[] arr = {1,2,3};
    int target = 4;
    System.out.println(countWaysToMakeChange(arr,target));
  }
  public static long countWaysToMakeChange(int arr[], int value){
    int n = arr.length;
    dp = new long[n][value+1];
    for(int i = 0 ; i < n; i++){
      for(int j = 0; j <= value; j++){
        dp[i][j] = -1L;
      }
    }
    return helper(arr, n-1, value);
	}
  private static long helper(int[] arr, int n, int target){
    if(target == 0) return 1L;
    if(n < 0) return 0;
    if(dp[n][target] != -1) return dp[n][target];
    long notTake = helper(arr, n-1, target);
    long take = 0;
    if(arr[n] <= target){
      take = helper(arr, n, target - arr[n]);
    }
    return dp[n][target] = take + notTake;
  }
}
