import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  public static void main(String[] args) {
    int[] ARR = {2,3};
    int B = 6;
    List<List<Integer>> combinations =  combSum(ARR, B);
    for (List<Integer> combo : combinations) {
      System.out.println(combo);
    }
  }

  public static List<List<Integer>> combSum(int[] ARR, int target){
    List<List<Integer>> result = new ArrayList<>();
    findCombination(ARR, target, result, new ArrayList<>(), 0);
    return result;
  }
  private static void findCombination(int[] nums, int target, List<List<Integer>> result, ArrayList<Integer> current, int index) {
    if(target == 0){
      result.add(new ArrayList<>(current));
      return;
    }
    if(target < 0 || index == nums.length) return;
    
    current.add(nums[index]);
    findCombination(nums, target - nums[index], result, current, index);
    current.remove(current.size()-1);
    findCombination(nums, target , result, current, index+1);
  }
  
}
