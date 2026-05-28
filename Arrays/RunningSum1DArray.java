public class RunningSum1DArray {
  public static void main(String[] args) {
    
  }
  public int[] runningSum(int[] nums) {
        // int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            // sum += nums[i];
            // nums[i] = sum;
            nums[i] += nums[i-1];
        }
        return nums;
  }
}
