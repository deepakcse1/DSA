import java.util.Arrays;

public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    int closest = Integer.MAX_VALUE;
    int sum = 0;
    for (int i = 0; i < n - 2; i++) {
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int currSum = nums[i] + nums[j] + nums[k];
        int currClosest = Math.abs(target - currSum);
        if (currClosest < closest) {
          closest = currClosest;
          sum = currSum;
        }
        if(currSum == target) return target;
        if(currSum > target)k--;
        else j++;
      }
    }
    // for (int i = 0; i < n - 2; i++) {
    //   for (int j = i + 1; j < n - 1; j++) {
    //     for (int k = j + 1; k < n; k++) {
    //       int currSum = nums[i] + nums[j] + nums[k];
    //       int currClosest = Math.abs(target - currSum);
    //       if (currClosest < closest) {
    //         closest = currClosest;
    //         sum = currSum;
    //       }
    //     }
    //   }
    // }
    return sum;
  }
}
