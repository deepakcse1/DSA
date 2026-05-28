package MaximumSumSubarray;

public class DivideAndConquer {
  public static void main(String[] args) {
    int[] nums = {100, -1, -2, 5};
    System.out.println(maxSubArray(nums));
  }

  public static int maxSubArray(int[] nums){
    return divideAndConquer(nums, 0, nums.length-1);
  }
  
  public static int divideAndConquer(int[] nums,int start, int end){
     // base case
     if(start == end) return nums[start]; 

     int mid = start + (end - start)/2;

     //choices
     int leftSum = divideAndConquer(nums, start, mid);
     int rightSum = divideAndConquer(nums, mid+1, end);
     int crossMaxSum = maximumCrossingSum(nums, start, mid, end);

     //optimal
     return Math.max(Math.max(leftSum, rightSum), crossMaxSum);
  }

  public static int maximumCrossingSum(int[] nums, int start, int mid, int end){
    int sum = 0;
    int leftSum = Integer.MIN_VALUE;
    for(int i = mid; i >= start; i--){
      sum += nums[i];
      leftSum = Math.max(leftSum, sum);
    }
    sum = 0;
    int rightSum = Integer.MIN_VALUE;
    for(int i = mid+1; i <= end; i++){
      sum += nums[i];
      rightSum = Math.max(rightSum, sum);
    }
    return leftSum + rightSum;
  }
}
