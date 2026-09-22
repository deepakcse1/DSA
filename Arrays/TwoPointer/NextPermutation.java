package TwoPointer;

public class NextPermutation {
  public void nextPermutation(int[] nums) {
    int n = nums.length;
    int pivot = n - 2;
    while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--;
    if (pivot >= 0) {
      int j = n - 1;
      while (nums[pivot] >= nums[j]) j--;
      swap(pivot, j, nums);
    }
    reverse(pivot + 1, n - 1, nums);
  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int st, int end, int[] nums) {
    while (st < end) {
      swap(st, end, nums);
      st++;
      end--;
    }
  }
}
