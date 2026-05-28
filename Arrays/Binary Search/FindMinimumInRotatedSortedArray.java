public class FindMinimumInRotatedSortedArray {
  public static void main(String[] args) {
    
  }

  // brute force
  public int findMin(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) return nums[i];
    }
    return nums[0];
  }
  
  //binary search
  public int findMin_Optimized(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] > nums[end]) start = mid + 1;
      else end = mid;
    }
    return nums[start];
  }
}
