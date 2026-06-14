package memoization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteAndEarn {
  public int deleteAndEarn(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Arrays.sort(nums);
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
      if (list.size() == 0 || list.get(list.size() - 1) != i) {
        list.add(i);
      }
    }
    Integer[] dp = new Integer[list.size()];
    return helper(0, list, map, dp);
  }

  public int helper(int in, List<Integer> list, Map<Integer, Integer> map, Integer[] dp) {
    if (in >= list.size()) return 0;
    if (dp[in] != null) return dp[in];
    int next = in + 1;
    if (in + 1 < list.size() && list.get(in + 1) == list.get(in) + 1) next = in + 2;
    int take = list.get(in) * map.get(list.get(in)) + helper(next, list, map, dp);
    int notTake = helper(in + 1, list, map, dp);
    return dp[in] = Math.max(take, notTake);
  }
}
