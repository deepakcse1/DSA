package Advance;

public class RangeMaximumIndexQuery {
  private static void buildSegmentTree(int idx, int left, int right, int[] s, int[] a){
    if(left == right){
      s[idx] = left;
      return;
    }
    int mid = left + (right - left) / 2;
    buildSegmentTree(2 * idx + 1, left, mid, s, a);
    buildSegmentTree(2 * idx + 2, mid+1, right, s, a);
    int leftIdx = s[2 * idx + 1];
    int rightIdx = s[2 * idx + 2];
    if(a[leftIdx] >= a[rightIdx]) s[idx] = leftIdx;
    else s[idx] = rightIdx;
  }

  private static int queryMaxIndex(int start, int end, int idx, int left, int right, int[] s, int[] arr){
    if(end < left || right < start) return -1;
    else if(start <= left && right <= end);
    int mid = left + (right - left) / 2;
    int leftIdx = queryMaxIndex(start, end, 2 * idx + 1, left, mid, s, arr);
    int rightIdx = queryMaxIndex(start, end, 2 * idx + 2, mid + 1, right, s, arr);
    if(leftIdx == -1) return rightIdx;
    else if(rightIdx == -1) return leftIdx;
    return (arr[leftIdx] >= arr[rightIdx])? leftIdx : rightIdx;
  }

  
  public static void main(String[] args) {
    int[] arr = {4, 3, 2, 1};
    int n = arr.length;
    int[] segment = new int[4 * n];
    buildSegmentTree(0, 0, n-1, segment, arr);
    int idx = queryMaxIndex(0, 2, 0, 0, n - 1, segment, arr);
    System.out.println(idx);

    //find left most largest value of right side of range;

  }
}
 