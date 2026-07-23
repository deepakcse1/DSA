package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
  public int subarraysDivByK(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int count = 0;
    map.put(0, 1);
    for (int i : nums) {
      sum += i;
      int rem = ((sum % k) + k) % k;
      if (map.containsKey(rem)) {
        count += map.get(rem);
      }
      map.put(rem, map.getOrDefault(rem, 0) + 1);
    }
    return count;
  }

  // // brute force
  // public int subarraysDivByK(int[] nums, int k) {
  //   int n = nums.length;
  //   int count = 0;
  //   for (int i = 0; i < n; i++) {
  //     int sum = 0;
  //     for (int j = i; j < n; j++) {
  //       sum += nums[j];
  //       if (sum % k == 0) count++;
  //     }
  //   }
  //   return count;
  // }
}
