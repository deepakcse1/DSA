import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationII {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    helper(nums, 0, result);
    return result;
  }

  public void helper(int[] nums, int index, List<List<Integer>> result) {
    if (index == nums.length) {
      List<Integer> curr = new ArrayList<>();
      for (int i : nums) {
        curr.add(i);
      }
      result.add(curr);
      return;
    }
    Set<Integer> set = new HashSet<>();
    for (int i = index; i < nums.length; i++) {
      if (set.contains(nums[i]))
        continue;
      set.add(nums[i]);
      swap(nums, index, i);
      helper(nums, index + 1, result);
      swap(nums, index, i);
    }
  }

  public void swap(int[] nums, int index, int i) {
    int temp = nums[i];
    nums[i] = nums[index];
    nums[index] = temp;
  }

}
