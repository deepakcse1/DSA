import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArray {
  public static void main(String[] args) {

  }

  // Brute force with extra space
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    List<Integer> list = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) list.add(nums1[i++]);
      else list.add(nums2[j++]);
    }
    while (i < nums1.length) list.add(nums1[i++]);
    while (j < nums2.length) list.add(nums2[j++]);
    int n = nums1.length + nums2.length;
    if (n % 2 == 1) return (double) list.get(n / 2);
    return (double) (list.get((n / 2) - 1) + list.get(n / 2)) / 2.0;
  }

  // Optimal approach without extra space
  public double findMedianSortedArrays_Optimal(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;
    int n = nums1.length + nums2.length;
    int idx2 = n / 2;
    int idx1 = idx2 - 1;
    int count = 0;
    int idx1El = -1;
    int idx2El = -1;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        if (count == idx1) idx1El = nums1[i];
        if (count == idx2) idx2El = nums1[i];
        count++;
        i++;
      } else {
        if (count == idx1) idx1El = nums2[j];
        if (count == idx2) idx2El = nums2[j];
        count++;
        j++;
      }
    }
    while (i < nums1.length) {
      if (count == idx1) idx1El = nums1[i];
      if (count == idx2) idx2El = nums1[i];
      count++;
      i++;
    }
    while (j < nums2.length) {
      if (count == idx1) idx1El = nums2[j];
      if (count == idx2) idx2El = nums2[j];
      count++;
      j++;
    }

    if (n % 2 == 1) {
      return (double) idx2El;
    }
    return (double) (idx1El + idx2El) / 2.0;
  }

  public double findMedianSortedArrays_optimized(int[] A, int[] B) {
    if (A.length > B.length) return findMedianSortedArrays(B, A);

    int m = A.length;
    int n = B.length;
    //Find a partition in both arrays such that Left side ≤ Right side
    int left = (m + n + 1) / 2;

    int start = 0;
    int end = m;

    while (start <= end) {
      int midA = (start + end) / 2; //Take midA elements from A into the left half
      int midB = left - midA;

      int l1 = (midA == 0) ? Integer.MIN_VALUE : A[midA - 1]; //last element of left part
      int r1 = (midA == m) ? Integer.MAX_VALUE : A[midA]; //first element of right part

      int l2 = (midB == 0) ? Integer.MIN_VALUE : B[midB - 1];
      int r2 = (midB == n) ? Integer.MAX_VALUE : B[midB];

      if (l1 <= r2 && l2 <= r1) { //All elements in left half ≤ all elements in right half
        if ((m + n) % 2 == 1) return Math.max(l1, l2);
        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
      } 
      else if (l1 > r2) end = midA - 1;
      else start = midA + 1;
    }

    return 0;
  }
}
