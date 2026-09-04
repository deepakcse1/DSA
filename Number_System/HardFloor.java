package Number_System;

import Number_System.PairedCube.FastScanner;

public class HardFloor {
  private static long MOD = 1_000_000_007L;

  private static long bin_pow(long base, long exp) {
    long ans = 1;
    base %= MOD;
    while (exp > 0) {
      if ((exp & 1) == 1) ans = (ans * base) % MOD;
      base = (base * base) % MOD;
      exp >>= 1;
    }
    return ans;
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    long n = fs.nextLong();
    long m = fs.nextLong();
    long ans = 0L;
    for (long i = 1, la; i <= n; i = la + 1) {
      long div = n / i;
      la = n / div;
      ans = (ans + (la - i + 1) % MOD * bin_pow(div, m) % MOD) % MOD;
    }
    System.out.println(ans);
  }
}
