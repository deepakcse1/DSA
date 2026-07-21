import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
  public static void main(String[] args) {
    
  }

  //Most naive approach - Brute Force O(n*4)
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    int n = nums.length;
    for (int i = 0; i < n-3; i++) {
      for (int j = i + 1; j < n-2; j++) {
        for (int k = j + 1; k < n-1; k++) {
          for (int l = k + 1; l < n; l++) {
            if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
              int[] arr = { nums[i], nums[j], nums[k], nums[l] };
              Arrays.sort(arr);
              List<Integer> curr = Arrays.asList(arr[0], arr[1], arr[2], arr[3]);
              set.add(new ArrayList<>(curr)); //no need to check if set contains curr because set always store unique
            }
          }
        }
      }
    }
    for (List<Integer> l : set) list.add(l);
    return list;
  }

  public List<List<Integer>> fourSumOptimal(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        Set<Integer> tempSet = new HashSet<>();
        for (int k = j + 1; k < n; k++) {
          // int sum = nums[i] + nums[j] + nums[k]; -> integer overflow
          // nums[i] = 1,000,000,000 , nums[j] = 1,000,000,000 -> 1,000,000,000 + 1,000,000,000 = -294967296  (OVERFLOW)
          long sum = 0L;
          sum += nums[i];
          sum += nums[j];
          sum += nums[k];
          long neededLong = (long) target - sum;
          if (neededLong >= Integer.MIN_VALUE && neededLong <= Integer.MAX_VALUE) {
            int needed = (int) neededLong;
            if (tempSet.contains(needed)) {
              int[] arr = { nums[i], nums[j], nums[k], needed };
              Arrays.sort(arr);
              set.add(Arrays.asList(arr[0], arr[1], arr[2], arr[3]));
            }
          }
          tempSet.add(nums[k]);
        }
      }
    }
    list.addAll(set);
    return list;
  }

  //two pointer still O(n*3)

  public List<List<Integer>> fourSum_optimized(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
      if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;
      for (int j = i + 1; j < n - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;
        if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
        if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;
        int k = j + 1;
        int l = n - 1;
        while (k < l) {
          long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
          if (sum == target) {
            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
            k++;
            l--;
            while (k < l && nums[k] == nums[k - 1]) k++;
            while (k < l && nums[l] == nums[l + 1]) l--;
          } else if (sum > target) { 
            l--;
            while (k < l && nums[l] == nums[l + 1]) l--;
          } else { 
            k++;
            while (k < l && nums[k] == nums[k - 1]) k++;
          }
        }
      }
    }
    return result;
  }
}

