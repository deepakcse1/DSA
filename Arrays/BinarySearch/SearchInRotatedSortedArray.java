package BinarySearch;

public class SearchInRotatedSortedArray {
  public static void main(String[] args) {

  }

  public int search(int[] nums, int target) {
    int n = nums.length;
    int lo = 0;
    int hi = n - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) return mid;
      if (isValid(nums, mid) == 1) {
        if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
        else hi = mid - 1;
      } else {
        if (target >= nums[0] && target < nums[mid]) hi = mid - 1;
        else lo = mid + 1;
      }
    }
    return -1;
  }

  private int isValid(int[] nums, int mid) {
    return (nums[mid] < nums[0]) ? 1 : 0;
  }
  // public int search(int[] nums, int target) {
  // int start = 0;
  // int end = nums.length - 1;
  // while (start <= end) {
  // int mid = start + (end - start) / 2;
  // if (nums[mid] == target) return mid;
  // else if (nums[start] <= nums[mid]) {
  // if (target >= nums[start] && target < nums[mid]) {
  // end = mid - 1;
  // } else {
  // start = mid + 1;
  // }
  // } else {
  // if (target > nums[mid] && target <= nums[end]) {
  // start = mid + 1;
  // } else {
  // end = mid - 1;
  // }
  // }
  // }
  // return -1;
  // }
}
