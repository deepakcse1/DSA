package tabulation;

public class CoinChange2 {
  public static void main(String[] args) {

  }

  public int change_opt(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int am = coin; am <= amount; am++) {
        dp[am] += dp[am - coin];
      }
    }
    return dp[amount];
  }

  public int change_optimized(int amount, int[] coins) {
    int n = coins.length;
    int[] next = new int[amount + 1];
    next[0] = 1;
    for (int idx = n - 1; idx >= 0; idx--) {
      int[] curr = new int[amount + 1];
      curr[0] = 1;
      for (int am = 1; am <= amount; am++) {
        int take = 0;
        if (am >= coins[idx]) {
          take = curr[am - coins[idx]];
        }
        int notTake = next[am];
        curr[am] = take + notTake;
      }
      next = curr;
    }
    return next[amount];
  }

  public int change(int amount, int[] coins) {
    int[][] dp = new int[coins.length + 1][amount + 1];
    for (int i = 0; i <= coins.length; i++) {
      dp[i][0] = 1;
    }
    for (int idx = coins.length - 1; idx >= 0; idx--) {
      for (int am = 1; am <= amount; am++) {
        int take = 0;
        if (am - coins[idx] >= 0) {
          take = dp[idx][am - coins[idx]];
        }
        int notTake = dp[idx + 1][am];
        dp[idx][am] = take + notTake;
      }
    }
    return dp[0][amount];
  }
}
