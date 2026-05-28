/*
 * Problem statement
Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost associated with it. Determine the maximum cost obtained by cutting the rod and selling its pieces.
Note:
1. The sizes will range from 1 to ‘N’ and will be integers.
2. The sum of the pieces cut should be equal to ‘N’.
3. Consider 1-based indexing.
 */

package memoization;
public class UnboundKnapsack_CutRod {
  static int[][] dp;

  public static void main(String[] args) {
    int[] price = {3, 5, 6, 7, 10, 12};
    int n = price.length;
    System.out.println(cutRod(price, n));
  }
  public static int cutRod(int price[], int n) {
     dp = new int[n][n+1];
     for(int i = 0; i < n; i++){
      for(int j = 0; j <= n; j++){
        dp[i][j] = -1;
      }
     }
     return helper(price,n-1, n);
	}
  private static int helper(int[] price, int index, int length){
    //base case
    if(index == 0) return length * price[0];
    if(dp[index][length] != -1) return dp[index][length];
    //choices
    int take = Integer.MIN_VALUE;
    int notTake = helper(price, index-1, length);
    int currentLength = index + 1;
    if(currentLength <= length){
      take = price[index] + helper(price, index, length - currentLength);
    }

    //optimal
    return dp[index][length] = Math.max(take,notTake);
  }
}

