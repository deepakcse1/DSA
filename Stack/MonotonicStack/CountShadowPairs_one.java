package Stack.MonotonicStack;

public class CountShadowPairs_one {
  public long shadowPairs(int[] nums) {
    int n = nums.length;
    long count = 0;
    int top = 0;
    int[] stack = new int[n];
    for (int i : nums) {
      int start = 0;
      int end = top;
      while (start < end) {
        int mid = start + (end - start) / 2;
        if (stack[mid] < i) start = mid + 1;
        else end = mid;
      }
      count += start;
      while (top > 0 && stack[top - 1] > i) top--;
      stack[top++] = i;
    }
    return count;
  }
  // public long shadowPairs(int[] nums) {
  // int n = nums.length;
  // int count = 0;
  // for(int i = 0; i < n-1; i++){
  // int min = nums[i];
  // for(int j = i+1; j < n; j++){
  // if(nums[i] < nums[j] && min == nums[i]) count++;
  // min = Math.min(min, nums[j]);
  // }
  // }
  // return count;
  // }
}
