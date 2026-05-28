public class SplitArrayLargestSum {
  public static void main(String[] args) {
    
  }

  public int splitArray(int[] nums, int k) {
    if (k > nums.length)return -1;
    int start = 0;
    int end = 0;
    for (int i : nums) {
      end += i;
      if (start < i) start = i;
    }

    //--------brute force O(n * (total - max + 1))-------------- (TLE)
    // for (int max = start; max <= end; max++) {
    //   int count = splitCount(nums, max);
    //   if (count <= k) return max;
    // }
    // return -1;
    //---------------------------------------------------------

    //-----------binary search O(n log(total - max))--------------
    while (start <= end) {
      int mid = start + (end - start) / 2;
      int count = splitCount(nums, mid);
      if (count <= k) end = mid - 1;
      else start = mid + 1;
    }
    return start;
    //---------------------------------------------------------
  }

  int splitCount(int[] nums, int max) {
    int count = 1;
    int sum = 0;
    for (int i : nums) {
      if (sum + i <= max) sum += i;
      else {
        count++;
        sum = i;
      }
    }
    return count;
  }
}
