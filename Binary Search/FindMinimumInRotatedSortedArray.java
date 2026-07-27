public class FindMinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    int resultIndex = 0;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] < nums[resultIndex]) resultIndex = mid;
      if (nums[mid] <= nums[end]) { end = mid - 1;
      } else { start = mid + 1;
      }
    }
    return nums[resultIndex];
  }
}
