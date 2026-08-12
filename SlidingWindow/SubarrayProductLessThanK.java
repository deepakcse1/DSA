package SlidingWindow;

public class SubarrayProductLessThanK {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) return 0;
    int n = nums.length;
    int count = 0;
    int product = 1;
    int left = 0;
    for (int right = 0; right < n; right++) {
      product *= nums[right];
      while (left < n && product >= k) {
        product /= nums[left];
        left++;
      }
      count += right - left + 1;
    }
    return count;
  }
    // public int numSubarrayProductLessThanK(int[] nums, int k) {
    //     int n = nums.length;
    //     int count = 0;
    //     for(int i = 0; i < n; i++){
    //         int product = 1;
    //         for(int j = i; j < n; j++){
    //             product *= nums[j];
    //             if(product >= k) break;
    //             if(product < k) count++;
    //         }
    //     }
    //     return count;
    // }
}
