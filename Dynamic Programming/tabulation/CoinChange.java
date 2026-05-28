package tabulation;

public class CoinChange {
  public static void main(String[] args) {

  }

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    for (int am = 1; am <= amount; am++) {
      int min = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (am - coin >= 0 && dp[am - coin] != Integer.MAX_VALUE) {
          min = Math.min(min, 1 + dp[am - coin]);
        }
      }
      dp[am] = min;
    }
    return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
  }
}
