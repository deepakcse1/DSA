public class RemoveDuplicatesFromSortedArray {
  public static void main(String[] args) {
    
  }

  public int removeDuplicates(int[] nums) {
    // int count = 1;
    // if(nums.length == 1) return count;
    // int left = 0;
    // int right = 1;
    // while(left < right && right < nums.length){
    //   if(nums[left] != nums[right]){
    //     count++;
    //     nums[left+1] = nums[right];
    //     left++; right++;
    //   }else{
    //     right++;
    //   }
    // }
    // return count;
    int k = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[k] = nums[i];
        k++;
      }
    }
    return k;
  }
}
