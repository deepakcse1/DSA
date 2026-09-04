package Combinotorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RubikCubeColoringEasy {
  private static long bin_pow(long base, long exp, long MOD) {
    long res = 1;
    while (exp > 0) {
      if ((exp & 1) == 1) res = (res * base) % MOD;
      base = (base * base) % MOD;
      exp >>= 1;
    }
    return res;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long MOD = 1_000_000_007L;
    int k = Integer.parseInt(br.readLine());
    long exponent = bin_pow(2, k, MOD - 1);
    exponent = exponent - 2;
    exponent = bin_pow(4, exponent, MOD);
    System.out.println((6 * exponent) % MOD);
  }
}
