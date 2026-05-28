package tabulation;

public class CoinChange2 {
  public static void main(String[] args) {

  }

  public int change(int amount, int[] coins) {
    int[][] dp = new int[coins.length + 1][amount + 1];
    for (int i = 0; i <= coins.length; i++) {
      dp[i][0] = 1;
    }
    for (int index = coins.length - 1; index >= 0; index--) {
      for (int target = 1; target <= amount; target++) {
        int take = 0;
        if (target - coins[index] >= 0) {
          take = dp[index][target - coins[index]];
        }
        int notTake = dp[index + 1][target];
        dp[index][target] = take + notTake;
      }
    }
    return dp[0][amount];
  }
}
