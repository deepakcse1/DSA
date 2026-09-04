package Hashing;

import java.util.*;

public class IntegerAppearingInSingleBlock {
  public int countSpecialIntegers(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    int count = 0;
    for (int i = 0; i < n;) {
      int num = nums[i];
      int j = i;
      while (j < n && nums[j] == num) j++;
      int blockSize = j - i;

      if (map.get(num) == blockSize) count++;
      i = j;
    }
    return count;
  }
}
