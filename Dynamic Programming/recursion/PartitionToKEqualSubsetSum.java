package recursion;

public class PartitionToKEqualSubsetSum {
  boolean[] visited;
  int target = 0;

  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for (int i : nums) sum += i;
    target = sum / k;
    if (sum % k != 0) return false;
    visited = new boolean[nums.length];
    return helper(0, 0, k, nums);
  }

  public boolean helper(int start, int currSum, int k, int[] nums) {
    if (k == 1) return true;
    if (target == currSum)
      return helper(0, 0, k - 1, nums);
    for (int i = start; i < nums.length; i++) {
      if (visited[i] || currSum + nums[i] > target) continue;
      visited[i] = true;
      if (helper(i + 1, currSum + nums[i], k, nums)) return true;
      visited[i] = false;
    }
    return false;
    // helper(i+1, currSum, k, nums);
  }
}
