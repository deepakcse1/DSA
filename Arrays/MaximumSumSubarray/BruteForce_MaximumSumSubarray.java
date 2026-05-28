package MaximumSumSubarray;
public class BruteForce_MaximumSumSubarray {
  public static void main(String[] args) {
     int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
     System.out.println(maxSubArray(nums));
  }

  public static int maxSubArray(int[] nums) { //O(n^3)
     int maxSum = Integer.MIN_VALUE;
     for(int i = 0; i < nums.length; i++){
       for(int j = i; j < nums.length; j++){
          int sum = 0;
          for(int k = i; k <= j; k++){
            sum += nums[k];
          }
          maxSum = Math.max(maxSum, sum);
       }
     }
     return maxSum;
  }

  public static int maxSubArrayBetter(int[] nums) { // O(n^2)
     int maxSum = Integer.MIN_VALUE;
     for(int i = 0; i < nums.length; i++){
       int sum = 0;
       for(int j = i; j < nums.length; j++){
          sum += nums[j];
          maxSum = Math.max(maxSum, sum);
       }
     }
     return maxSum;
  }
}
