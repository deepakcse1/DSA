package memoization;

import java.util.ArrayList;

public class Stairs {
  static ArrayList<Long> dp;
  public static void main(String[] args) {
    long ans = countDistinctWayToClimbStair(20);
    System.out.println(ans);
  }

  public static long countDistinctWayToClimbStair(int n) {
    dp = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      dp.add(-1L);
    }
    return helper(n, dp);
  }

  public static long helper(int n, ArrayList<Long> dp) {
    //base case
    if(n == 0) return 1;
    if (n <= 2) return n;
    if (dp.get(n) != -1) return dp.get(n);

    //choices
    long ans = helper(n - 1, dp) + helper(n - 2, dp);

    //optimal substructure
    ans %= 1000000007;
    dp.set(n, ans);
    return ans;
  }
}
