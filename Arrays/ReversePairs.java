public class ReversePairs {
  private long merge(int left, int mid, int right, int[] nums) {
    int j = mid + 1;
    long count = 0L;
    for (int i = left; i <= mid; i++) {
      while (j <= right && (long) nums[i] > (long) 2 * nums[j]) {
        j++;
      }
      count += j - (mid + 1);
    }
    int i = left;
    j = mid + 1;
    int[] tempArr = new int[right - left + 1];
    int k = 0;
    while (i <= mid && j <= right) {
      if (nums[i] <= nums[j]) {
        tempArr[k++] = nums[i++];
      } else {
        tempArr[k++] = nums[j++];
      }
    }
    while (i <= mid) {
      tempArr[k++] = nums[i++];
    }
    while (j <= right) {
      tempArr[k++] = nums[j++];
    }
    for (int x = 0; x < tempArr.length; x++) {
      nums[left + x] = tempArr[x];
    }
    return count;
  }

  private long mergeSort(int left, int right, int[] nums) {
    if (left >= right)
      return 0;
    long count = 0L;
    int mid = left + (right - left) / 2;
    count += mergeSort(left, mid, nums);
    count += mergeSort(mid + 1, right, nums);
    count += merge(left, mid, right, nums);
    return count;
  }

  public int reversePairs(int[] nums) {
    return (int) mergeSort(0, nums.length - 1, nums);
  }
  // public int reversePairs(int[] nums) {
  // int n = nums.length;
  // long count = 0;
  // for(int i = 0; i < n-1; i++){
  // for(int j = i+1; j < n; j++){
  // if((long) nums[i] > (long) 2 * nums[j]) count++;
  // }
  // }
  // return (int) count;
  // }
}
