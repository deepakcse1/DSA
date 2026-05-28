package tabulation;

import java.util.ArrayList;

public class Stairs {
  static ArrayList<Long> dp;
  public static void main(String[] args) {
    int n = 3;
    System.out.println(countDistinctWayToClimbStair(n));
  }

  public static long countDistinctWayToClimbStair(int n) {
    dp = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      dp.add(-1L);
    }
    return helper(n, dp);
  }

  public static long helper(int n, ArrayList<Long> dp) {
    if(n >=0) dp.set(0, 1L);
    if(n >=1) dp.set(1, 1L);
    if(n >=2) dp.set(2, 2L);
    for(int i = 3; i <= n; i++){
      long ans = dp.get(i-1) + dp.get(i-2);
      ans %= 1000000007;
      dp.set(i, ans);
    }
    return dp.get(n);
  }
}
