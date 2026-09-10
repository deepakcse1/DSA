public class IfArrayIsSorted {
  public boolean check(int[] nums) {
    int n = nums.length;
    if (n <= 1) return true;

    int inversionCount = 0;
    for (int i = 1; i < n; i++) {
      if (nums[i] < nums[i - 1]) {
        inversionCount++;
        if (inversionCount > 1) return false;
      }
    }
    if (nums[0] < nums[n - 1]) inversionCount++;
    return inversionCount <= 1;
  }
  // public boolean check(int[] nums) {
  //   int pivotIdx = -1;
  //   int n = nums.length;
  //   for (int i = 0; i < n - 1; i++) {
  //     if (nums[i] > nums[i + 1]) {
  //       pivotIdx = i;
  //       break;
  //     }
  //   }
  //   if (pivotIdx == -1) return true;
  //   reverse(0, pivotIdx, nums);
  //   reverse(pivotIdx + 1, n - 1, nums);
  //   reverse(0, n - 1, nums);
  //   for (int i = 0; i < n - 1; i++) {
  //     if (nums[i] > nums[i + 1]) return false;
  //   }
  //   return true;
  // }

  // private static void reverse(int st, int end, int[] nums) {
  //   while (st < end) {
  //     int temp = nums[st];
  //     nums[st] = nums[end];
  //     nums[end] = temp;
  //     st++;
  //     end--;
  //   }
  // }
}
