package Advance;

import java.util.Arrays;

public class SegmentTree {
  static int[] segmentTree;
  static int[] lazy;

  //Build Segment Tree -> Range Sum
  public static void buildTree(int idx, int left, int right, int[] arr){
    if(left == right){
      segmentTree[idx] = arr[left];
      return;
    }
    int mid = left + (right - left) / 2;
    buildTree((2 * idx) + 1, left, mid, arr);
    buildTree((2 * idx) + 2, mid+1, right, arr);
    segmentTree[idx] = segmentTree[(2 * idx) + 1] + segmentTree[(2 * idx) + 2];
  }

  // Update Segment Tree -> Point Update
  private static void updateTree(int idx, int value, int i, int left, int right){
    if(left == right){
      segmentTree[i] = value;
      return;
    }
    int mid = left + (right - left) / 2;
    if(idx <= mid) updateTree(idx, value, 2 * i + 1, left, mid);
    else updateTree(idx, value, 2 * i + 2, mid + 1, right);
    segmentTree[i] = segmentTree[(2 * i) + 1] + segmentTree[(2 * i) + 2];
  }

  private static void updateRange(int start, int end, int value, int i, int left, int right){
    if(lazy[i] != 0){
      segmentTree[i] += lazy[i] * (right - left + 1);
      if(left != right){ // not a leaf node 
          lazy[2 * i + 1] = lazy[i];
          lazy[2 * i + 2] = lazy[i]; 
      }
      lazy[i] = 0;
      return;
    }
    if(end < left || right < start || left > right) return;
    if(start <= left && right <= end)  {
      segmentTree[i] = value * (right - left + 1);
      if(left != right){
          lazy[2 * i + 1] += value;
          lazy[2 * i + 2] += value; 
      }
      return;
    }
    int mid = left + (right - left) / 2;
    updateRange(start, end, value, 2 * i + 1, left, mid);
    updateRange(start, end, value, 2 * i + 2, mid +1 , right);
    segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
  }

  static int[] minSegmentTree;
  private static void buildMinTree(int i, int left, int right, int[] arr){
    if(left == right){
      minSegmentTree[i] = arr[left];
      return;
    }
    int mid = left + (right - left) / 2;
    buildMinTree((2 * i) + 1, left, mid, arr);
    buildMinTree((2 * i) + 2, mid+1, right, arr);
    minSegmentTree[i] = Math.min(minSegmentTree[(2 * i) + 1], minSegmentTree[(2 * i) + 2]);
  }


  //O(Q * 2LogN)
  private static int rangeQueryMin(int start, int end, int idx, int left, int right){
    if(right < start || end < left) return Integer.MAX_VALUE;
    else if(left >= start && right <= end) return minSegmentTree[idx];

    int mid = left + (right - left) / 2;
    int leftMin = rangeQueryMin(start, end, 2 * idx + 1, left, mid);
    int rightMin = rangeQueryMin(start, end, 2 * idx + 2, mid + 1, right);
    return Math.min(leftMin, rightMin);
  }
  
  //O(Q * 2LogN)
  private static int rangeQuerySum(int start, int end, int idx, int left, int right){
    if(right < start || end < left) return 0;
    else if(left >= start && right <= end) return segmentTree[idx];

    int mid = left + (right - left) / 2;
    int leftSum = rangeQuerySum(start, end, 2 * idx + 1, left, mid);
    int rightSum = rangeQuerySum(start, end, 2 * idx + 2, mid + 1, right);
    return leftSum + rightSum;
  }
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
    int n = arr.length;

    //-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
    segmentTree = new int[4 * n];
    buildTree(0, 0, n-1, arr); //Build Segment Tree
    updateTree(0, 3, 0, 0, n-1); // Update Segment Tree -> Index of root is 0
    rangeQuerySum(2, 4, 0, 0, n-1); // Range Query Sum
    //-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

    //-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
    minSegmentTree = new int[4 * n];
    buildMinTree(0, 0, n-1, arr);
    System.out.println(Arrays.toString(minSegmentTree));
    int ans = rangeQueryMin(3, 2, 0, 0, n-1);
    System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    //-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

    lazy = new int[4 * n];
    // T : O(logN) since we are updating at one go and maximum we go till tree height; 
    // S : O(n)
    updateRange(2, 4,2, 0, 0, n-1); 
  }
}
