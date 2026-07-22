package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContigousArray {
  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    int sum = 0;
    int length = 0;
    map.put(0, -1);
    for (int i = 0; i < n; i++) {
      sum += (nums[i] == 0) ? -1 : 1;
      if (map.containsKey(sum)) {
        int curLen = i - map.get(sum);
        length = Math.max(length, curLen);
      } else {
        map.put(sum, i);
      }

    }
    return length;
  }
}
