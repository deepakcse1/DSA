import java.util.*;
public class ThreeSum {
  public static void main(String[] args) {
    
  }

  //Brute Force
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            // List<Integer> ans = new ArrayList<>();
            // ans.add(nums[i]);
            // ans.add(nums[j]);
            // ans.add(nums[k]);
            List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[k]);
            Collections.sort(ans);
            if (!res.contains(ans)) res.add(ans);
          }
        }
      }
    }
    return res;
  }

  // It will not work - Time limit exceeds
  // O(n²) (loops) × O(n) (res.contains) = O(n³) -> 
  // res.contains(ans) is slow and take n in worst case
  public List<List<Integer>> threeSumNN(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int j = i + 1; j < nums.length; j++) {
        int pending = -(nums[i] + nums[j]);
        if (map.containsKey(pending)) {
          List<Integer> ans = Arrays.asList(nums[i], nums[j], pending);
          Collections.sort(ans);
          if (!res.contains(ans)) res.add(ans);
        } 
        else  map.put(nums[j], j);
      }
    }
    return res;
  }

  //using set - It will work - O(n²) + log(M) - better than Map
  public List<List<Integer>> three_Sum_Using_Set(int[] nums) {
    Set<List<Integer>> res = new HashSet<>(); //here we will add List of Integers
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      Set<Integer> set = new HashSet<>(); // here we will add only temporary integers
      for (int j = i + 1; j < n; j++) {
        int target = -(nums[i] + nums[j]);
        if (set.contains(target)) {
          List<Integer> ans = Arrays.asList(nums[i], nums[j], target);
          Collections.sort(ans);
          res.add(ans);
        }
        set.add(nums[j]);
      }
    }
    return new ArrayList<>(res);
  }

  public List<List<Integer>> threeSumBest(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        long total = (long) nums[i] + nums[left] + nums[right];
        if (total == 0) {
          res.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++; right--;
          while (left < right && nums[left] == nums[left-1]) left++;
          while (left < right && nums[right] == nums[right+1]) right--;
        } else if (total < 0) left++;
        else right--;
      }
    }
    return res;
  }
}
