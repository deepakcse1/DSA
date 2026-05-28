/*
 Problem statement
Given an array ‘ARR’, partition it into two subsets (possibly empty) such that their union is the original array. Let the sum of the elements of these two subsets be ‘S1’ and ‘S2’.

Given a difference ‘D’, count the number of partitions in which ‘S1’ is greater than or equal to ‘S2’ and the difference between ‘S1’ and ‘S2’ is equal to ‘D’. Since the answer may be too large, return it modulo ‘10^9 + 7’.

If ‘Pi_Sj’ denotes the Subset ‘j’ for Partition ‘i’. Then, two partitions P1 and P2 are considered different if:

1) P1_S1 != P2_S1 i.e, at least one of the elements of P1_S1 is different from P2_S2.
2) P1_S1 == P2_S2, but the indices set represented by P1_S1 is not equal to the indices set of P2_S2. Here, the indices set of P1_S1 is formed by taking the indices of the elements from which the subset is formed.
Refer to the example below for clarification.
Note that the sum of the elements of an empty subset is 0.

For example :
If N = 4, D = 3, ARR = {5, 2, 5, 1}
There are only two possible partitions of this array.
Partition 1: {5, 2, 1}, {5}. The subset difference between subset sum is: (5 + 2 + 1) - (5) = 3
Partition 2: {5, 2, 1}, {5}. The subset difference between subset sum is: (5 + 2 + 1) - (5) = 3
These two partitions are different because, in the 1st partition, S1 contains 5 from index 0, and in the 2nd partition, S1 contains 5 from index 2.
 */
package memoization;

public class CountPartitions {
  static int[][] dp;
  public static void main(String[] args) {
    int[] arr = {2,0,1};
    int d = 1;
    int n = arr.length;
    System.out.println(countPartitions(n, d, arr));
  }
  public static int countPartitions(int n, int d, int[] arr) {
    //s1 - s2 = d
    //s1 + s2 = totalSum
    //2s1 = d + totalSum
    int totalSum = 0;
    for(int num : arr) totalSum += num;
    if((d + totalSum) % 2 != 0) return 0;
    int sum = (d + totalSum) / 2;
    dp = new int[n][sum+1];
    for(int i = 0; i < n; i++){
      for(int j = 0; j <= sum; j++){
        dp[i][j] = -1;
      }
    }
    return countSubsets(n-1, sum, arr);
	}
  private static int countSubsets(int n, int sum, int[] arr){
    //------- this will not work for cases with zeroes in the array -------
    // //base case
    // if(sum == 0) return 1;
    // if(n < 0) return 0;
    // //choices
    // int take = 0;
    // int notTake = countSubsets(n-1, sum, arr);
    // if(arr[n] <= sum){
    //   take = countSubsets(n-1, sum - arr[n], arr);
    // }
    // //optimal
    // return (take + notTake) % 1000000007;
    //base case
    if(n == 0){
      if(sum == 0 && arr[0] == 0) return 2; //two options - take or not take
      if(sum == 0 || sum == arr[0]) return 1;
      return 0;
    }
    if(dp[n][sum] != -1) return dp[n][sum];
    //choices
    int notTake = countSubsets(n-1, sum, arr);
    int take = 0;
    if(arr[n] <= sum){
      take = countSubsets(n-1, sum - arr[n], arr);
    }
    //optimal
    return dp[n][sum] = (take + notTake) % 1000000007;
  } 
}

