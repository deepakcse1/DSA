package WeeklyContest;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarrayWithAtMostKDistinctPrimeFactors {
  public int longestSubarray(int[] nums, int k) {
    // create SPF
    int n = nums.length;
    int max = 0;
    for (int i : nums) {
      max = Math.max(max, i);
    }
    // building SPF
    int[] spf = new int[max + 1];
    for (int i = 0; i <= max; i++) {
      spf[i] = i;
    }
    // Using a sieve-like approach, store the smallest prime factor for every
    // composite number.
    for (int i = 2; i * i <= max; i++) {
      if (spf[i] == i) {
        for (int j = i * i; j <= max; j += i) {
          if (spf[j] == j) spf[j] = i;
        }
      }
    }

    List<Integer>[] factors = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      factors[i] = new ArrayList<>();
      int val = nums[i];
      while (val > 1) {
        int p = spf[val];
        factors[i].add(p);
        while (val % p == 0) {
          val /= p;
        }
      }
    }

    int[] freq = new int[max + 1];
    int left = 0;
    int count = 0;
    int resMax = 0;
    for (int right = 0; right < n; right++) {
      for (int p : factors[right]) {
        if (freq[p] == 0) count++;
        freq[p]++;
      }

      while (count > k) {
        for (int p : factors[left]) {
          if (freq[p] == 1) count--;
          freq[p]--;
        }
        left++;
      }
      resMax = Math.max(resMax, right - left + 1);
    }
    return resMax;
  }
}
