package PrefixSum;

public class FindPivotIndex {
  public int pivotIndex(int[] nums) {
    int n = nums.length;
    int total = 0;
    for (int i : nums) {
      total += i;
    }
    int left = 0;
    for (int i = 0; i < n; i++) {
      int right = total - left - nums[i];
      if (left == right) return i;
      left += nums[i];
    }
    return -1;
  }
    // public int pivotIndex(int[] nums) {
    //     int n = nums.length;
    //     int[] suffix = new int[n];
    //     int sum = 0;
    //     for(int i = n-1; i >= 0; i--){
    //         sum += nums[i];
    //         suffix[i] = sum;
    //     }
    //     int prefix = 0;
    //     for(int i = 0; i < n; i++){
    //         prefix += nums[i];
    //         if(prefix == suffix[i]) return i;
    //     }
    //     return -1;
    // }
}
