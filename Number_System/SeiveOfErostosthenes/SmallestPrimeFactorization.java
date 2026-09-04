package Number_System.SeiveOfErostosthenes;

import java.util.ArrayList;
import java.util.List;

public class SmallestPrimeFactorization {
  private static int[] spf;
  
  private static void build_spf(int n) {
    spf = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      spf[i] = i;
    }
    for (int i = 2; i <= n; i++) {
      if (spf[i] == i) {
        for (int j = i * i; j <= n; j += i) {
          if (spf[j] == j) {
            spf[j] = i;
          }
        }
      }
    }
  }

  private static List<Integer> prime_fact(int x){
    List<Integer> list = new ArrayList<>();
    while(x > 1){
      list.add(spf[x]);
      x /= spf[x];
    }
    return list;
  }
  public static void main(String[] args) {
    int n = 100;
    build_spf(n);
    for(int i : prime_fact(12)){
      System.out.print(i+" ");
    }
    System.out.println();
  }
}
