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

package tabulation;

public class CountPartitions {
  public static void main(String[] args) {
    int[] arr = {2,0,1};
    int d = 1;
    int n = arr.length;
    System.out.println(countPartitions(n, d, arr));
  }
  public static int countPartitions(int n, int d, int[] arr) {
    int sum = 0;
    for(int i : arr) sum += i;
    sum += d;
    if(sum % 2 != 0) return 0;
    int target = sum / 2;
    int[] dp = new int[target + 1];
    dp[0] = 1; // empty subset
    if(arr[0] <= target && arr[0] != 0) dp[arr[0]] = 1;
    else if(arr[0] == 0) dp[0] = 2;

    for(int i = 1; i < n; i++){
        for(int t = target; t >= arr[i]; t--){
          dp[t] = (dp[t] + dp[t - arr[i]]) % 1000000007;
        }
    }
    return dp[target];
  }
}
