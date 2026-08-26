package String;

import java.util.Arrays;

public class LargestNumber {
  public String largestNumber(int[] nums) {
    int n = nums.length;
    String[] stArr = new String[n];
    for (int i = 0; i < n; i++) {
      stArr[i] = Integer.toString(nums[i]);
    }

    Arrays.sort(stArr, (a, b) -> (b + a).compareTo(a + b));

    if (stArr[0].equals("0")) return "0";

    StringBuilder sb = new StringBuilder();
    for (String el : stArr) {
      sb.append(el);
    }
    System.out.println(sb.toString());
    return sb.toString();
  }
}
