package memoization;

public class CoinChange2 {
  public static void main(String[] args) {

  }

  public int change(int amount, int[] coins) {
    Integer[][] dp = new Integer[coins.length][amount + 1];
    return helper(0, amount, coins, dp);
  }

  public int helper(int index, int amount, int[] coins, Integer[][] dp) {
    if (amount == 0) return 1;
    if (index >= coins.length || amount < 0) return 0;
    if (dp[index][amount] != null) return dp[index][amount];
    int take = 0;
    if (amount - coins[index] >= 0) {
      take = helper(index, amount - coins[index], coins, dp);
    }
    int notTake = helper(index + 1, amount, coins, dp);
    return dp[index][amount] = take + notTake;
  }
}
