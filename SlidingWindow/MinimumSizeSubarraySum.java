package SlidingWindow;

public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int target, int[] nums) {
    int minimumWindow = Integer.MAX_VALUE;
    int n = nums.length;
    int left = 0;
    int prefix = 0;
    for (int right = 0; right < n; right++) {
      prefix += nums[right];
      while (left < n && prefix >= target) {
        if (right - left + 1 < minimumWindow) {
          minimumWindow = right - left + 1;
        }
        prefix -= nums[left];
        left++;
      }
    }
    return (minimumWindow == Integer.MAX_VALUE) ? 0 : minimumWindow;
    }
  //      Brute force ----------------------------------
  // public int minSubArrayLen(int target, int[] nums) {
    //     for(int left = 0; left < n; left++){
    //         int right = left;
    //         int prefix = 0;
    //         while(right < n){
    //             prefix += nums[right];
    //             if(prefix >= target){
    //                 minimumWindow = Math.min(minimumWindow, right - left + 1);
    //                 break;
    //             }
    //             right++;
    //         }
    //     }
    //     return (minimumWindow == Integer.MAX_VALUE) ? 0 : minimumWindow;
    // }
}
