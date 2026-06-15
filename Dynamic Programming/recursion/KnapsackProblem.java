package recursion;

public class KnapsackProblem {
  public int knapsack(int W, int val[], int wt[]) {
    // code here
    return helper(0, W, val, wt);
  }

  public int helper(int idx, int W, int val[], int wt[]) {
    if (W == 0 || idx == val.length) return 0;

    int take = 0;
    if (wt[idx] <= W) {
      take = val[idx] + helper(idx + 1, W - wt[idx], val, wt);
    }
    int notTake = helper(idx + 1, W, val, wt);
    return Math.max(take, notTake);
  }
}
