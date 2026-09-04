package Combinotorics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
//https://maang.in/problems/Number-of-Ways-to-Reach-B-71?resourceUrl=pl4807-rs71&returnUrl=%5B%22%2Fcohorts%2FAZ-Premium-Cohort-16-84%3Ftab%3Dassignments%22%5D

public class NumberOfWaysToReachB {
  static final long MOD = 1_000_000_007;
  static final int MAX = 1_000_000;

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

  static long[] fact = new long[MAX + 1];
  static long[] invFact = new long[MAX + 1];

  private static void factorial() {
    fact[0] = 1;
    for (int i = 1; i <= MAX; i++) {
      fact[i] = (i * fact[i - 1]) % MOD;
    }
    invFact[MAX] = inverse(fact[MAX]);
    for (int i = MAX; i >= 1; i--) {
      invFact[i - 1] = (invFact[i] * i) % MOD;
    }
  }

  private static long nCr_faster(int n, int m) {
    long num = fact[n + m];
    long den = (invFact[m] * invFact[n]) % MOD;
    return (num * den) % MOD;
  }

  public static void main(String[] args) throws IOException {
    factorial();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      out.println(nCr_faster(n, m));
    }
    out.flush();
    out.close();
  }
}
