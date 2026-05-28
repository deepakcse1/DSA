public class LongestSubarrayOfOneAfterDeletingOneElement {
  public static void main(String[] args) {
    
  }

  //brute force
  public int longestSubarray(int[] nums) {
    int n = nums.length;
    int maxLen = 0;
    boolean isOne = false;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 1) {
        isOne = true;
        break;
      }
    }
    if (!isOne)
      return 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        int count = 0;
        for (int j = 0; j < n; j++) {
          if (nums[j] == 1) {
            count++;
            if (count > maxLen) maxLen = count;
          } 
          else if (j == i) continue;
          if (nums[j] == 0) count = 0;
        }
      }
    }
    return (maxLen == 0) ? n - 1 : maxLen;
  }

  public int longestSubarray_optimized(int[] nums) {
    int maxLen = 0;
    int start = 0;
    int zeroCount = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) zeroCount++;

      while (zeroCount > 1) {
        if (nums[start] == 0) zeroCount--;
        start++;
      }
      
      if ((i - start) > maxLen) maxLen = (i - start);
    }
    return maxLen;
  }
}
