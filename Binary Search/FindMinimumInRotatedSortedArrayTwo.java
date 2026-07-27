public class FindMinimumInRotatedSortedArrayTwo {
  public int findMin(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    int resultIdx = 0;
    while (start <= end) {
      while (start < end && nums[start] == nums[start + 1]) start++;
      while (start < end && nums[end] == nums[end - 1]) end--;
      int mid = start + (end - start) / 2;
      if (nums[mid] < nums[resultIdx]) resultIdx = mid;
      if (nums[mid] < nums[end]) end = mid - 1;
      else start = mid + 1;
    }
    return nums[resultIdx];
  }
}
