package WeeklyContest;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarrayWithAtMostKDistinctPrimeFactors {

  private int[] spf;
  private void build_spf(int MAX) {
    spf = new int[MAX + 1];
    for (int i = 2; i <= MAX; i++) {
      spf[i] = i;
    }
    for (int i = 2; i <= MAX / i; i++) {
      if (spf[i] == i) {
        for (long j = i * i; j <= MAX; j += i) {
          if (spf[(int) j] == (int) j) spf[(int) j] = i;
        }
      }
    }
  }

  List<Integer>[] list;

  private void buildFactorList(int max, int[] nums) {
    list = new ArrayList[max + 1];
    for (int num : nums) {
      list[num] = new ArrayList<>();
      int x = num;
      while (x > 1) {
        int p = spf[x];
        list[num].add(p);
        while (x % p == 0) {
          x /= p;
        }
      }
    }
  }

  private int slidingWindow(int max, int[] nums, int k) {
    int n = nums.length;
    int left = 0;
    int count = 0;
    int longestSub = 0;
    int[] freq = new int[max + 1];
    for (int right = 0; right < n; right++) {
      int digit = nums[right];
      for (int p : list[digit]) {
        if (freq[p] == 0) count++;
        freq[p]++;
      }
      while (count > k) {
        int currDigit = nums[left];
        for (int p : list[currDigit]) {
          freq[p]--;
          if (freq[p] == 0) count--;
        }
        left++;
      }
      longestSub = Math.max(longestSub, right - left + 1);
    }
    return longestSub;
  }

  public int longestSubarray(int[] nums, int k) {
    int max = 0;
    for (int i : nums) {
      max = Math.max(max, i);
    }
    build_spf(max);
    buildFactorList(max, nums);
    return slidingWindow(max, nums, k);
  }
}
