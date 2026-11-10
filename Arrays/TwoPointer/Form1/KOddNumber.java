package TwoPointer.Form1;

import java.util.TreeMap;

import TwoPointer.Form1.MedianOfSubarraySum.FastScanner;

//find a subarray with at most K odd numbers and the total sum is maximum but not more than  D. If no such subarray exists print IMPOSSIBLE.
public class KOddNumber {
  private static long solve(int n, long[] arr, int k, long d, long[] prefix) {
    int head = -1;
    int tail = 0;
    long ans = Long.MIN_VALUE;
    int oddCount = 0;
    TreeMap<Long, Integer> prefixSet = new TreeMap<>();
    while (tail < n) {
      while ((head < n - 1) && (oddCount + (arr[head + 1] % 2 != 0 ? 1 : 0)) <= k) {
        head++;
        prefixSet.put(prefix[head + 1], prefixSet.getOrDefault(prefix[head + 1], 0) + 1);
        if (arr[head] % 2L != 0L) oddCount++;
      }
      //Query the Maximum Valid Sum: Once head is as far right as legally possible for the current tail, any index inside the multiset is a valid endpoint. We want to maximize  (pref[i] − pref[tail−1]) such that it is ≤ D.
      long limit = d + prefix[tail]; //because tail is constant, only head moves, so stored head and will find based on head
      Long bestPrefix = prefixSet.floorKey(limit);
      if (bestPrefix != null) {
        long currSum = bestPrefix - prefix[tail]; //curS = arr[r] - arr[l-1];
        ans = Math.max(ans, currSum);
      }

      if (tail <= head) {
        if (arr[tail] % 2L != 0L) oddCount--;
        int freq = prefixSet.get(prefix[tail + 1]);
        if (freq == 1) prefixSet.remove(prefix[tail + 1]);
        else prefixSet.put(prefix[tail + 1], freq - 1);
        tail++;
      } else {
        tail++;
        head = tail - 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      int n = fs.nextInt();
      int k = fs.nextInt();
      long d = fs.nextLong();
      long[] arr = new long[n];
      long[] prefix = new long[n + 1];
      for (int i = 0; i < n; i++) {
        arr[i] = fs.nextLong();
        prefix[i + 1] = arr[i] + prefix[i];
      }

      long ans = solve(n, arr, k, d, prefix);
      System.out.println((ans == Long.MIN_VALUE) ? "IMPOSSIBLE" : ans);
    }
  }
}
