
public class CountInversion {

  public long numberOfInversions(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }

  private long mergeSort(int[] nums, int left, int right) {
    if (left >= right) return 0;
    int mid = left + (right - left) / 2;
    long count = 0;
    count += mergeSort(nums, left, mid);
    count += mergeSort(nums, mid + 1, right);
    count += merge(nums, left, mid, right);
    return count;
  }

  private long merge(int[] nums, int left, int mid, int right) {
    int i = left;
    int j = mid + 1;
    long count = 0;
    int[] temp = new int[right - left + 1];
    int k = 0;
    while (i <= mid && j <= right) {
      if (nums[i] <= nums[j]) {
        temp[k++] = nums[i++];
      } else {
        temp[k++] = nums[j++];
        // All remaining elements in left half
        // are greater than nums[j - 1]
        count += mid - i + 1;
      }
    }
    while (i <= mid) {
      temp[k++] = nums[i++];
    }
    while (j <= right) {
      temp[k++] = nums[j++];
    }
    for (int x = 0; x < temp.length; x++) {
      nums[left + x] = temp[x];
    }
    return count;
  }
}
