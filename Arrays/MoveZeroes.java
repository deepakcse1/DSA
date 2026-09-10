public class MoveZeroes {
  public static void main(String[] args) {
    
  }
  
  public void moveZeroes(int[] nums) {
    int n = nums.length;
    int left = 0;
    for (int right = 0; right < n; right++) {
      if (nums[right] != 0) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
        left++;
      }
    }
  }
  // public void moveZeroes(int[] nums) {
  //   if (nums.length == 1) return;
  //   int i = 0;
  //   for (int j = 0; j < nums.length; j++) {
  //     if (nums[j] == 0) {
  //       i = j;
  //       break;
  //     }
  //   }

  //   for (int j = i + 1; j < nums.length; j++) {
  //     if (nums[i] == 0 && nums[j] != 0) {
  //       nums[i] = nums[j];
  //       nums[j] = 0;
  //       i++;
  //     }
  //   }
  // }
}
