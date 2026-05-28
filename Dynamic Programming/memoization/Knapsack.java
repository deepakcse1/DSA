package memoization;

public class Knapsack {
  static int[][] dp;
  public static void main(String[] args) {
    int[] weight = {1,2,3,4};
    int[] value = {5,4,8,6};
    int maxWeight = 5;
    int n = weight.length;
    System.out.println(knapsack(weight, value, n, maxWeight));
  }

  public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    dp = new int[n][maxWeight + 1];
    for(int i = 0; i < n; i++){
      for(int j = 0; j <= maxWeight; j++){
        dp[i][j] = -1;
      }
    }
    return helper(weight, value, maxWeight, n-1);
  }

  private static int helper(int[] weight, int[] value, int maxWeight, int index){
    //base case
    if(index < 0 || maxWeight <= 0) return 0;
    if(dp[index][maxWeight] != -1) return dp[index][maxWeight];
    //choices
    int take = 0, notTake = 0;
    notTake = helper(weight, value, maxWeight, index-1);
    if(weight[index] <= maxWeight){
      take = value[index] + helper(weight, value, maxWeight - weight[index], index-1);
    }

    //optimal
    return dp[index][maxWeight] = Math.max(take, notTake);
  }
}
