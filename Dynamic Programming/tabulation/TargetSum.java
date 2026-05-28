/* 
Problem statement
You are given an array ‘ARR’ of ‘N’ integers and a target number, ‘TARGET’. Your task is to build an expression out of an array by adding one of the symbols '+' and '-' before each integer in an array, and then by concatenating all the integers, you want to achieve a target. You have to return the number of ways the target can be achieved.

For Example :
You are given the array ‘ARR’ = [1, 1, 1, 1, 1], ‘TARGET’ = 3. The number of ways this target can be achieved is:
1. -1 + 1 + 1 + 1 + 1 = 3
2. +1 - 1 + 1 + 1 + 1 = 3
3. +1 + 1 - 1 + 1 + 1 = 3
4. +1 + 1 + 1 - 1 + 1 = 3
5. +1 + 1 + 1 + 1 - 1 = 3
These are the 5 ways to make. Hence the answer is 5.
*/
package tabulation;

public class TargetSum {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 1};
    int n = arr.length;
    int target = 3;
    // System.out.println(targetSum(n, target, arr));
    System.out.println(targetSumOptimized(n, target, arr));
  }

  public static int targetSum(int n, int target, int[] arr){
    // s1 - s2 = target
    // s1 + s2 = totalSum
    // s1 - (totalSum - s1) = target
    // 2s1 = target + totalSum
    int totalSum = 0;
    for(int i = 0; i < n; i++) totalSum += arr[i];
    if(totalSum < target || (target + totalSum) % 2 == 1) return 0;
    int sum = (target + totalSum)/2;
    int[][] dp = new int[n][sum+1];
    
    if(arr[0] == 0) dp[0][0] = 2;
    else dp[0][0] = 1;
    if(arr[0] != 0 && arr[0] <= sum) dp[0][arr[0]] = 1;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= sum; j++) {
        int notTake = dp[i - 1][j];
        int take = 0;
        if (arr[i] <= j) take = dp[i - 1][j - arr[i]];
        dp[i][j] = take+notTake;
      }
    }
    return dp[n-1][sum];
  }

  // 1D space Optimized 
  public static int targetSumOptimized(int n, int target, int[] arr){
    int totalSum = 0;
    for(int i = 0; i < n; i++) totalSum += arr[i];
    if(totalSum < target || (target + totalSum) % 2 == 1) return 0;
    int sum = (target + totalSum)/2;
    int[] dp = new int[sum+1];

    if(arr[0] == 0) dp[0] = 2;
    else dp[0] = 1;
    if(arr[0] != 0 && dp[0] <= sum) dp[arr[0]] = 1;

    for(int i = 1; i < n; i++){
      for(int j = sum; j >= arr[i]; j--){
        dp[j] = dp[j] + dp[j - arr[i]];
      }
    }
    return dp[sum];
  }
  
}
