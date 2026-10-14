package Advance;

public class RangeSumQueryMutable {

}

class NumArray {
  int[] segmentTree;
  int n;
  public NumArray(int[] nums) {
    n = nums.length;
    segmentTree = new int[4 * n];
    buildTree(0, 0, n - 1, nums);
  }

  public void update(int index, int val) {
    updateTree(index, val, 0, 0, n - 1);
  }

  public int sumRange(int left, int right) {
    return rangeQuerySum(left, right, 0, 0, n - 1);
  }

  private int rangeQuerySum(int start, int end, int idx, int left, int right) {
    if (end < left || right < start) return 0;
    else if (start <= left && right <= end) return segmentTree[idx];
    int mid = left + (right - left) / 2;
    int leftSum = rangeQuerySum(start, end, 2 * idx + 1, left, mid);
    int rightSum = rangeQuerySum(start, end, 2 * idx + 2, mid + 1, right);
    return leftSum + rightSum;
  }

  private void updateTree(int index, int value, int i, int left, int right) {
    if (left == right) {
      segmentTree[i] = value;
      return;
    }
    int mid = left + (right - left) / 2;
    if (index <= mid) updateTree(index, value, 2 * i + 1, left, mid);
    else updateTree(index, value, 2 * i + 2, mid + 1, right);
    segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
  }

  private void buildTree(int idx, int left, int right, int[] nums) {
    if (left == right) {
      segmentTree[idx] = nums[left];
      return;
    }
    int mid = left + (right - left) / 2;
    buildTree(2 * idx + 1, left, mid, nums);
    buildTree(2 * idx + 2, mid + 1, right, nums);
    segmentTree[idx] = segmentTree[2 * idx + 1] + segmentTree[2 * idx + 2];
  }
}
