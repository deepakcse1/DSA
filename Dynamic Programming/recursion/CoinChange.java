package recursion;

public class CoinChange {
  public static void main(String[] args) {

  }

  public int coinChange(int[] coins, int amount) {
    int ans = helper(coins, amount);
    return (ans == Integer.MAX_VALUE) ? -1 : ans;
  }

  public int helper(int[] coins, int amount) {
    if (amount == 0) return 0;
    if (amount < 0) return Integer.MAX_VALUE;
    int minCoin = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = helper(coins, amount - coin);
      if (res != Integer.MAX_VALUE) {
        minCoin = Math.min(minCoin, 1 + res);
      }
    }
    return minCoin;
  }
}
