public class MinimizeMaximumOfArray {
  public static void main(String[] args) {
    
  }

  // public int minimizeArrayValue(int[] nums) {
  //       int start = 0;
  //       int end = 0;
  //       for(int i : nums){
  //           if(end < i) end = i;
  //       }
  //       while(start <= end){
  //           int mid = start + (end - start)/2;
  //           if(helper(nums, mid)){
  //               end = mid - 1;
  //           }else{
  //               start = mid + 1;
  //           }
  //       }
  //       return start;
  //   }

  //   public boolean helper(int[] nums, int max){
  //       long sum = 0;
  //       for(int i = 0; i < nums.length; i++){
  //           sum += nums[i];
  //           long allowed =(long) max * (i + 1);
  //           if(sum > allowed) return false;
  //       }
  //       return true;
  //   }

  //-----------------  O(n) approach-----------------
  public int minimizeArrayValue(int[] nums) {
    long prefixSum = 0;
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];
      long max = (prefixSum + i) / (i + 1);
      ans = (int) Math.max(ans, max);
    }
    return ans;
  }
}
