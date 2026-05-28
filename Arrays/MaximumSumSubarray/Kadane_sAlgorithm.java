//Given an array (with positive, negative, or zero values), find the maximum sum of any contiguous subarray.
package MaximumSumSubarray;

public class Kadane_sAlgorithm {
  public static void main(String[] args) {
    int[] nums = {100, -1, -2, 5};
    System.out.println(maxSubArray(nums));
    printMaxSubArray(nums);
  }
  //kadane's algorithm
  public static int maxSubArray(int[] nums){
    int maximumSum = Integer.MIN_VALUE; //best subarray seen so far
    int sum = 0; //best subarray ending at the current index
    for(int i = 0; i < nums.length; i++){
      sum += nums[i];
      if(maximumSum < sum) maximumSum = sum;
      if(sum < 0) sum = 0; //A negative prefix can never help future subarrays,so we discard it and start fresh.
    }
    return maximumSum;
  }

  public static void printMaxSubArray(int[] nums){
    int maximumSum = Integer.MIN_VALUE; //best subarray seen so far
    int sum = 0; //best subarray ending at the current index
    int startIndex = -1;
    int endIndex = -1;
    for(int i = 0; i < nums.length; i++){
      int start = 0;
      if(sum == 0) start = i; //reset starting point
      sum += nums[i];
      if(maximumSum < sum){
        startIndex = start;
        endIndex = i;
        maximumSum = sum;
      }
      if(sum < 0) sum = 0;
    }
    for(int i = startIndex; i <= endIndex; i++) System.out.print(nums[i]+" ");
  }
  
}
