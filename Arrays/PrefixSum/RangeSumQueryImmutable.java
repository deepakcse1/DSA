package PrefixSum;

class NumArray {
  int[] prefixSum;
  public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefixSum[i] = sum;
        }
    }

  public int sumRange(int left, int right) {
    if (left == 0)
      return prefixSum[right];
    return prefixSum[right] - prefixSum[left - 1];
  }
}
