package memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaximumProduct {
  public static void main(String[] args) {
    int[] arr = { 1, 0, -1, 2, 3, -5, -2 };
    int n = arr.length;
    ArrayList<Integer> list = new ArrayList<>();
    for (int x : arr) list.add(x);
    System.out.println(maximumProduct(list, n));
  }

  static class Pair {
    int max, min;
    Pair(int a, int b) {
      max = a;
      min = b;
    }
  }

  public static int maximumProduct(ArrayList<Integer> arr, int n) {
    Map<Integer, Pair> memo = new HashMap<>();
    int ans = arr.get(0);
    for (int i = 0; i < n; i++) {
      Pair res = helper(arr, i, memo);
      ans = Math.max(ans, res.max);
    }
    return ans;
  }

  private static Pair helper(ArrayList<Integer> arr, int i, Map<Integer, Pair> memo) {
    if (i == 0) return new Pair(arr.get(0), arr.get(0));
    if (memo.containsKey(i)) return memo.get(i);
    Pair prev = helper(arr, i - 1, memo);
    int curr = arr.get(i);
    int maxVal = Math.max(curr, Math.max(prev.max * curr, prev.min * curr));
    int minVal = Math.min(curr, Math.min(prev.max * curr, prev.min * curr));
    Pair result = new Pair(maxVal, minVal);
    memo.put(i, result);
    return result;
  }
}
