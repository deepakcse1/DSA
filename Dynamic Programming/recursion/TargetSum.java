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
package recursion;

public class TargetSum {
  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 1, 1};
    int n = arr.length;
    int target = 3;
    // System.out.println(targetSum(n, target, arr));
    System.out.println(targetSumBetter(n, target, arr));
  }

  //better way
  public static int targetSumBetter(int n, int target, int[] arr) {
    int totalSum = 0;
    for(int i = 0; i < n; i++) totalSum += arr[i];
    if(totalSum < Math.abs(target) || (totalSum + target) % 2 ==1) return 0;
    int sum = (totalSum + target)/2;
    return helperBetter(arr, n-1, sum);
  }
  private static int helperBetter(int[] arr, int n, int target){
    if(n == 0){
      if(target == 0 && arr[0] == 0) return 2;
      if(target == 0 || arr[0] == target) return 1;
      return 0;
    }
    int notTake = helperBetter(arr, n-1, target);
    int take = 0;
    if(arr[n] <= target){
      take = helperBetter(arr, n-1, target - arr[n]);
    }
    return take + notTake;
  }

  //naive way
  // public static int targetSum(int n, int target, int[] arr) {
  //   	return helper(arr, n-1, target);
  // }
  // private static int helper(int[] arr, int n, int target){
  //   if(target == 0 && n < 0) return 1;
  //   if( n < 0) return 0;
  //   return helper(arr, n-1, target - arr[n]) + helper(arr, n-1, target + arr[n]);
  // }
}
