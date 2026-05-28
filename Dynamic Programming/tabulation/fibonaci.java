package tabulation;

import java.util.ArrayList;

public class fibonaci {
  static ArrayList<Integer> dp = new ArrayList<>();
  public static void main(String[] args) {
    dp = new ArrayList<>();
    int n = 7;
    for(int i = 0; i <= n; i++){
      dp.add(0); 
    }
    int ans = fib(n);
    System.out.println(ans);
  }
  public static int fib(int n){
    dp.set(0,0);
    dp.set(1,1);
    for(int i = 2; i <= n; i++){
      dp.set(i, dp.get(i-1) + dp.get(i-2));
    }
    return dp.get(n);
  }
}
