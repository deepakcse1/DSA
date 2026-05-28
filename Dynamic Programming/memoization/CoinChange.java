package memoization;

public class CoinChange {
  public static void main(String[] args) {
    
  }

  public int coinChange(int[] coins, int amount) {
    Integer[] dp = new Integer[amount + 1];
    int ans = helper(coins, amount, dp);
    return (ans == Integer.MAX_VALUE) ? -1 : ans;
  }

  public int helper(int[] coins, int amount, Integer[] dp) {
    if (amount == 0) return 0;
    if (amount < 0) return Integer.MAX_VALUE;
    if (dp[amount] != null) return dp[amount];
    int minCoin = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = helper(coins, amount - coin, dp);
      if (res != Integer.MAX_VALUE) {
        minCoin = Math.min(minCoin, 1 + res);
      }
    }
    return dp[amount] = minCoin;
  }
}
