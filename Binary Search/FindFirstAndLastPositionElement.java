public class FindFirstAndLastPositionElement {
  public int[] searchRange(int[] nums, int target) {
    int left = binarySearch(nums, target, true);
    int right = binarySearch(nums, target, false);
    return new int[] { left, right };
  }

  private int binarySearch(int[] nums, int target, boolean isLeft) {
    int index = -1;
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        index = mid;
        if (isLeft) end = mid - 1;
        else start = mid + 1;
      } else if (nums[mid] < target) start = mid + 1;
      else end = mid - 1;
    }
    return index;
  }
    // private int searcInRight(int[] nums, int target){
    //     int index = -1;
    //     int start = 0;
    //     int end = nums.length-1;
    //     while(start <= end){
    //         int mid = start + (end - start)/2;
    //         if(nums[mid] == target){
    //             index = mid;
    //             start = mid + 1;
    //         }else if(nums[mid] < target) start = mid + 1;
    //         else end = mid - 1;
    //     }
    //     return index;
    // }
}
