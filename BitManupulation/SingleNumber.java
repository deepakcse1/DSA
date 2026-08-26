package BitManupulation;

import java.util.HashMap;

public class SingleNumber {
  public int singleNumber(int[] nums) {
    int xor = 0;
    for (int i : nums) {
      xor = xor ^ i;
    }
    return xor;
  }

  // Brute force approach
  // public int singleNumber(int[] nums) {
  //   Map<Integer, Integer> map = new HashMap<>();
  //   for (int i : nums) {
  //     map.put(i, map.getOrDefault(i, 0) + 1);
  //   }
  //   for (int key : map.keySet()) {
  //     if (map.get(key) == 1) return key;
  //   }
  //   return -1;
  // }
}
