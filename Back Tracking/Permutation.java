import java.util.ArrayList;
import java.util.List;

public class Permutation {
  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    List<List<Integer>> result = permutation(nums);
    // System.out.println("-----------------");
    int i = 0;
    for(List<Integer> ele : result){
      // System.out.println("Permutation "+ ++i);
      System.out.println(ele+"--"+ ++i);
    }
  }

  public static List<List<Integer>> permutation(int[] nums){
      List<List<Integer>> result = new ArrayList<>();
      helper(nums, 0, result);
      return result;
  }

  public static void helper(int[] nums, int index, List<List<Integer>> result){
     if(index == nums.length - 1){
        List<Integer> curr = new ArrayList<>();
        for(int i : nums){
          curr.add(i);
        }
        result.add(new ArrayList<>(curr));
        return;
     }
     for(int i = index; i < nums.length; i++){
        swap(nums, index, i);
        helper(nums, index+1, result);
        swap(nums, index, i);
     }
  }

  public static void swap(int[] nums, int index, int i){
    int temp = nums[index];
    nums[index] = nums[i];
    nums[i] = temp;
  }
}
