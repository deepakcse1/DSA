package TwoPointer.Form0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumInversionCountOfSubarrays {
  class Fenwick {
    int n;
    int[] bit;

    Fenwick(int n) {
      this.n = n;
      bit = new int[n + 1];
    }

    public void update(int i, int delta) {
      while (i <= n) {
        bit[i] += delta;
        i += i & -i;
      }
    }

    public int query(int i) {
      int sum = 0;
      while (i > 0) {
        sum += bit[i];
        i -= i & -i;
      }
      return sum;
    }
  }

  public long minInversionCount(int[] nums, int k) {
    int n = nums.length;
    int[] sorted = nums.clone();
    Arrays.sort(sorted);
    Map<Integer, Integer> rank = new HashMap<>();
    int compressed = 1;
    for (int x : sorted) {
      if (!rank.containsKey(x)) {
        rank.put(x, compressed++);
      }
    }
    Fenwick fenwick = new Fenwick(rank.size());

    long inversionCount = 0L;
    long ans = Long.MAX_VALUE;
    for (int i = 0; i < k; i++) {
      int r = rank.get(nums[i]);
      long q = fenwick.query(r);
      long greater = i - q;
      inversionCount += greater;
      fenwick.update(r, 1);
    }
    ans = inversionCount;
    for (int head = k; head < n; head++) {
      int outGoing = rank.get(nums[head - k]);
      fenwick.update(outGoing, -1);
      long smaller = fenwick.query(outGoing - 1);
      inversionCount -= smaller;

      int r = rank.get(nums[head]);
      long q = fenwick.query(r);
      long greater = (k - 1) - q;
      inversionCount += greater;
      fenwick.update(r, 1);

      ans = Math.min(ans, inversionCount);
    }
    return ans;
  }
  public static void main(String[] args) {
    int[] arr = {5,3,2,1};//{5,3,2,1};//{3,1,2,5,4};
    int k = 4;//4;//3;
    MinimumInversionCountOfSubarrays mm = new MinimumInversionCountOfSubarrays();
    long ans = mm.minInversionCount(arr, k);
    System.out.println(ans);
  }
}
