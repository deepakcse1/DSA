package recursion;

public class CoinChange2 {
  public static void main(String[] args) {

  }

  public int change(int amount, int[] coins) {
    return helper(0, amount, coins);
  }

  public int helper(int index, int amount, int[] coins) {
    if (amount == 0) return 1;
    if (index >= coins.length || amount < 0) return 0;
    int take = 0;
    if (amount - coins[index] >= 0) {
      take = helper(index, amount - coins[index], coins);
    }
    int notTake = helper(index + 1, amount, coins);
    return take + notTake;
  }
}
