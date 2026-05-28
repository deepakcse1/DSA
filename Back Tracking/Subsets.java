import java.util.ArrayList;
import java.util.List;

public class Subsets {
  public static void main(String[] args) {
    int[] nums = {1,2,3};
    List<List<Integer>> result = subsets(nums);
    // if want to print
    for(List<Integer> ans : result){
      System.out.println(ans);
    }
  }

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
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
    helper(nums, curr, index + 1, result);
  }
}
