package recursion;

public class MinimumCostClimbingStairs {
  public static void main(String[] args) {

  }

  public int minCostClimbingStairs(int[] cost) {
    return helper(-1, cost);
  }

  public int helper(int index, int[] cost) {
    if (index >= cost.length) return 0;
    int step1 = helper(index + 1, cost);
    int step2 = helper(index + 2, cost);
    if (index == -1) return 0 + Math.min(step1, step2);
    return cost[index] + Math.min(step1, step2);
  }
}
