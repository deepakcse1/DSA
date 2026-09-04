package Number_System;

import java.util.ArrayList;
import java.util.List;

public class FindAll_PrimeFactors {
  private static List<Long[]> getAllFactors(long n) {
    List<Long[]> list = new ArrayList<>();
    for (long i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        long count = 0;
        while (n % i == 0) {
          count++;
          n /= i;
        }
        list.add(new Long[] { i, count });
      }
    }
    if(n > 1) list.add(new Long[] {n,  (long) 1});
    return list;
  }

  public static void main(String[] args) {
    long n = 23*23;
    for(Long[] el : getAllFactors(n)){
      System.out.println(el[0] + " : "+el[1]);
    }
  }
}
