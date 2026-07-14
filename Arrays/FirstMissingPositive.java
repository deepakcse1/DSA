public class FirstMissingPositive {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    // 1 to size only allowed
    // clean the array
    for (int i = 0; i < n; i++) {
      if (nums[i] < 1 || nums[i] > n)
        nums[i] = n + 1;
    }
    // Mark the presence
    for (int i = 0; i < n; i++) {
      int num = Math.abs(nums[i]);
      if (num == n + 1)
        continue;
      if (nums[num - 1] >= 0) {
        nums[num - 1] = -nums[num - 1];
      }
    }
    // find the first missing positive
    for (int i = 0; i < n; i++) {
      if (nums[i] >= 0)
        return i + 1;
    }
    return n + 1;
  }
    // public int firstMissingPositive(int[] nums) {
    //     Set<Long> set = new HashSet<>();
    //     long max = 0;
    //     for(int i : nums){
    //         if(max < (int) i) max = (int) i;
    //         set.add((long) i);
    //     }        
    //     for(int i = 1; i <= max+1; i++){
    //         if(!set.contains((long) i)) return i;
    //     }
    //     return 0;
    // }
}
