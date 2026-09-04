package Number_System;

import java.util.*;

import Number_System.PairedCube.FastScanner;

public class HowManySolutions {
  static final long MOD = 1_000_007L;

  private static void solve(long n, long d) {
    Map<Long, Long> map = new HashMap<>();
    long tempN = n;
    for (long i = 2; i * i <= tempN; i++) {
      long cnt = 0;
      while (tempN % i == 0) {
        tempN /= i;
        cnt++;
      }
      if (cnt > 0) {
        map.put(i, map.getOrDefault(i, 0L) + 2 * cnt);
      }
    }
    if (tempN > 1) {
      map.put(tempN, map.getOrDefault(tempN, 0L) + 2);
    }
    map.put(2L, map.getOrDefault(2L, 0L) + 2 * d);
    map.put(5L, map.getOrDefault(5L, 0L) + 2 * d);
    long ans = 1;
    boolean sqr = true;
    for (long exp : map.values()) {
      ans = (ans * (exp + 1)) % MOD;
      if (exp % 2 != 0) sqr = false;
    }
    ans = (ans * 2) % MOD;
    if (sqr) ans = (ans - 1 + MOD) % MOD;
    System.out.println(ans);
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    while (true) {
      long n = fs.nextLong();
      long d = fs.nextLong();
      if (n == 0 && d == 0) break;
      solve(n, d);
    }
  }
}
