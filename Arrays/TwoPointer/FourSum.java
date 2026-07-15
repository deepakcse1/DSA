package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
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
