import java.util.HashMap;

public class TwoSum {
  public static void main(String[] args) {
    int[] nums = {2,7,11,14};
    int[] res = twoSum1(nums, 9);
    for(int i : res) System.out.print(i+" ");
  }
  
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[] {};
  }
  
  //Hashing O(nLogN)
  public static int[] twoSum1(int[] nums, int target) { 
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) { //n times
      int remaining = target - nums[i]; 
      if (map.containsKey(remaining)) {
        return new int[] {map.get(remaining), i};
      }
      map.put(nums[i], i); //logN time
    }
    return new int[] {};
  }
  
}
