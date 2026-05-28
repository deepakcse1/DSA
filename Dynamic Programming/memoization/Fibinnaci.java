//Memoization - Top Down Approach
package memoization;

import java.util.ArrayList;

public class Fibinnaci {
  static ArrayList<Integer> dp;
  public static void main(String[] args) {
    int n = 5;
    dp = new ArrayList<>();
    for(int i = 0; i <= n; i++){
      dp.add(-1);
    }
    int ans = fib(n);
    System.out.println(ans);
  }
  public static int fib(int n){
    if(n <= 1) return n;
    if(dp.get(n) != -1) return dp.get(n);
    int ans = fib(n-1) + fib(n-2);
    dp.set(n, ans);
    return ans;
  }
}
