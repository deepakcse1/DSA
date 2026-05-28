import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
  public static void main(String[] args) {
    
  }

  public List<List<Integer>> combinationSum2(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    helper(nums, 0, target, new ArrayList<>(), result);
    return result;
  }

  public void helper(int[] nums, int index, int target, List<Integer> curr, List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(curr));
      return;
    }
    if (target < 0 || index == nums.length) return;

    curr.add(nums[index]);
    // Note :
    // Each number in candidates may only be used once in the combination.
    // The solution set must not contain duplicate combinations.
    helper(nums, index + 1, target - nums[index], curr, result);
    curr.remove(curr.size() - 1);
    int in = index + 1;
    while (in < nums.length && nums[in] == nums[index])
      in++;
    helper(nums, in, target, curr, result);
  }
}
