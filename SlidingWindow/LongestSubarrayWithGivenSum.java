package SlidingWindow;

public class LongestSubarrayWithGivenSum {
  private static int solve(int[] nums, int k){
    int n = nums.length;
    int left = 0;
    int longestSubarray = 0;
    int currSum = 0;
    for(int right = 0; right < n; right++){
      currSum += nums[right];
      while(currSum > k){
        currSum -= nums[left];
        left++;
      }
      if(currSum == k){
        longestSubarray = Math.max(longestSubarray, right - left + 1);
      }
    }
    return longestSubarray;
  }
  public static void main(String[] args) {
    int[] nums = {-3, 2, 1};
    int k = 6;
    System.out.println(solve(nums, k));
  }
}
