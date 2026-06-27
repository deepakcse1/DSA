package recursion;

public class CombinationSumFour {
  public int combinationSum4(int[] nums, int target) {
    if (target == 0) return 1;
    int total = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= target) {
        total += combinationSum4(nums, target - nums[i]);
      }
    }
    return total;
  }
}
