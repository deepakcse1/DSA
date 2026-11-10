package AZContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolveMathsExpression {
  static class FastScanner {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String[] tokens;
    private int index = 0;

    String next() throws IOException {
      while (tokens == null || index >= tokens.length) {
        tokens = br.readLine().trim().split("\\s+");
        index = 0;
      }
      return tokens[index++];
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    String nextLine() throws IOException {
      return br.readLine();
    }
  }

  // try{ }
  // catch(Exception e) System.out.println(e)
  // static long INV2 = 5 * 100_000_004;
  static long MOD = 1000_000_007;

  private static long bin_pow(long base, long exp) {
    long res = 1;
    while (exp > 0) {
      if ((exp & 1) == 1) res = res * base % MOD;
      base = base * base % MOD;
      exp >>= 1;
    }
    return res;
  }

  private static long norm(long x) {
    return ((x % MOD) + MOD) % MOD;
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();

    while (t-- > 0) {
      long a = fs.nextLong();
      long b = fs.nextLong();
      long c = fs.nextLong();
      long d = fs.nextLong();
      long e = fs.nextLong();
      long f = fs.nextLong();
      long g = fs.nextLong();
      long h = fs.nextLong();
      // long ans = ((bin_pow(a, b) - c) * e - d + bin_pow(f, (g*h)) * e) * inv(e);
      long x = bin_pow(f, g);
      long ans = (norm(norm(bin_pow(a, b) - c) * e % MOD - d % MOD) + bin_pow(x, h) * e % MOD) * bin_pow(e, MOD - 2)
          % MOD;
      System.out.println(ans);
    }
  }
}
