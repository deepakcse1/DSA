/*
 * Problem statement
You are given an array of ‘N’ distinct integers and an integer ‘X’ representing the target sum. You have to tell the minimum number of elements you have to take to reach the target sum ‘X’.

Note:
You have an infinite number of elements of each type.
For example
If N=3 and X=7 and array elements are [1,2,3]. 
Way 1 - You can take 4 elements  [2, 2, 2, 1] as 2 + 2 + 2 + 1 = 7.
Way 2 - You can take 3 elements  [3, 3, 1] as 3 + 3 + 1 = 7.
Here, you can see in Way 2 we have used 3 coins to reach the target sum of 7.
Hence the output is 3.
 */
package tabulation;

public class MinimumElementsCoinProblem {
  // static int[] dp;
  public static void main(String[] args) {
    int[] num = {1,2,3};
    int x = 3;
    System.out.println(minimumElements(num, x));
  }
  public static int minimumElements(int[] num, int x) {
    int[] dp = new int[x+1];
    dp[0] = 0;
    for(int target = 1; target <= x; target++){
      dp[target] = Integer.MAX_VALUE;
    }
    for(int i : num){
      for(int target = i; target <= x; target++){
        if(dp[target - i] != Integer.MAX_VALUE){
          dp[target] = Math.min(dp[target], 1 + dp[target - i]);
        }
      }
    }
    return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
  }
}
