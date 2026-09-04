package Number_System;

import java.util.ArrayList;
import java.util.List;

import Number_System.PairedCube.FastScanner;

public class Euler_phi_function {
  private static List<Long> prime_fact(long n) {
    List<Long> list = new ArrayList<>();
    for (long i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        list.add(i);
        while (n % i == 0) {
          n /= i;
        }
      }
    }
    if (n > 1) list.add(n);
    return list;
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    long n = fs.nextLong();
    long res = n;
    List<Long> list = prime_fact(n);
    for (long i : list) {
      res = (res * (i - 1)) / i;
    }
    System.out.println(res);
  }
}
