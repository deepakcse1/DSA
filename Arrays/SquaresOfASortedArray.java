import java.util.Arrays;

public class SquaresOfASortedArray {
  public static void main(String[] args) {

  }

  public int[] sortedSquares_optimized(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    int left = 0;
    int right = n - 1;
    for (int i = n - 1; i >= 0; i--) {
      if (Math.abs(nums[left]) > Math.abs(nums[right])) {
        res[i] = nums[left] * nums[left];
        left++;
      } else {
        res[i] = nums[right] * nums[right];
        right--;
      }
    }
    return res;
  }

  public int[] sortedSquares(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums[i] * nums[i];
    }
    Arrays.sort(nums);
    return nums;
  }
}
