package Combinotorics.nCR;
// we do a bit faster than O(log(mod))

// Inverse calculation is a little costly, so we will precompute Inverses of Factorial
// 1 / (i−1)!​ = i × 1/i! ⟹ ((i−1)!)^−1 = i×(i!)^−1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NcR_mathodSix {
  static final long MOD = 1_000_000_007;
  static final int MAX = 1000_000;

  private static long bin_pow(long base, long exp) {
    long res = 1;
    while (exp > 0) {
      if ((exp & 1) == 1) res = (res * base) % MOD;
      base = (base * base) % MOD;
      exp >>= 1;
    }
    return res;
  }

  private static long inverse(long x) {
    return bin_pow(x, MOD - 2);
  }

  static long[] fact;
  static long[] invFact;

  private static void factorial() {
    fact = new long[MAX + 1];
    invFact = new long[MAX + 1];

    fact[0] = 1;
    for (int i = 1; i <= MAX; i++) {
      fact[i] = (fact[i - 1] * i) % MOD;
    }

    invFact[MAX] = inverse(fact[MAX]);
    for (int i = MAX; i >= 1; i--) {
      invFact[i - 1] = (invFact[i] * i) % MOD;
    }
  }

  private static long nCr_faster(int n, int r) {
    long num = fact[n];
    long den = (invFact[n - r] * invFact[r]) % MOD;
    return (num * den) % MOD;
  }

  public static void main(String[] args) throws Exception {
    factorial();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      long res = nCr_faster(n, r);
      out.append(res).append('\n');
    }
    System.out.print(out);
  }
}
