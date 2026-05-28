public class FindPeakElement {
  public static void main(String[] args) {
    
  }
  //brute force O(n)
  public int findPeakElement(int[] nums) {
    int index = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (max < nums[i]) {
        max = nums[i];
        index = i;
      }
    }
    return index;
  }

  public int findPeakElement_optimized(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] > nums[mid + 1]) end = mid;
      else start = mid + 1;
    }
    return start;
  }
}
