package recursion;

public class DeleteAndEarn {
  public int deleteAndEarn(int[] nums) {
    int max = 0;
    for (int i : nums) {
      max = Math.max(i, max);
    }
    int[] points = new int[max + 1];
    for (int i : nums) {
      points[i] += i;
    }
    //solve house robber
    return helper(0, points);
  }

  private int helper(int idx, int[] points) {
    if (idx >= points.length) return 0;
    int take = points[idx] + helper(idx + 2, points);
    int notTake = helper(idx + 1, points);
    return Math.max(take, notTake);
  }
}
