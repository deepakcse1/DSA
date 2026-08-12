package SlidingWindow;

public class MaximumConsecutiveOnesThree {
  public int longestOnes(int[] nums, int k) {
    int n = nums.length;
    int left = 0;
    int matched = 0;
    int maxCount = 0;
    for (int right = 0; right < n; right++) {
      if (nums[right] == 0) matched++;
      while (left < n && matched > k) {
        if (nums[left] == 0) matched--;
        left++;
      }
      if (maxCount < (right - left + 1)) {
        maxCount = right - left + 1;
      }
    }
    return maxCount;
  }
}
