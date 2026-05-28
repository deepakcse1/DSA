package recursion;


public class JumpGame2 {

  public static void main(String[] args) {

  }

  public int jump(int[] nums) {
    return helper(0, nums);
  }

  public int helper(int index, int[] nums) {
    if (index >= nums.length - 1) return 0;

    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= nums[index]; i++) {
      int ans = helper(index + i, nums);
      if (ans != Integer.MAX_VALUE) {
        min = Math.min(min, 1 + ans);
      }
    }
    return min;
  }
  
}
