import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
  public static void main(String[] args) {
    subsetsWithDup(new int[] {1,2,2});
  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    helper(nums, new ArrayList<>(), 0, result);
    return result;
  }
  
  public static void helper(int[] nums, List<Integer> curr, int index, List<List<Integer>> result) {
    if (index == nums.length) {
      result.add(new ArrayList<>(curr));
      return;
    }
    curr.add(nums[index]);
    helper(nums, curr, index + 1, result);
    curr.remove(curr.size() - 1);
    int idx = index+1;
    while(idx < nums.length && nums[index] == nums[idx]) idx++;
    helper(nums, curr, idx, result);
  }
}
