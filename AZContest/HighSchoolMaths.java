package AZContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HighSchoolMaths {
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

  static final long MOD = 1_000_000_009L;

  private static long[] binPowTransform(long a, long b, long n) {
    // long res = 1L;
    long resP = 1L;
    long resQ = 0L;

    long currP = a % MOD;
    long currQ = b % MOD;

    while (n > 0) {
      if ((n & 1L) == 1L) { // odd
        // res = res * base % MOD;
        long newP = currP * resP % MOD;
        long newQ = (currP * resQ % MOD + currQ) % MOD;
        resP = newP;
        resQ = newQ;
      }
      long newQ = (currP * currQ % MOD + currQ) % MOD;
      currP = currP * currP % MOD;
      currQ = newQ;
      n >>= 1;
    }
    return new long[] { resP, resQ };
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      long a = fs.nextLong();
      long b = fs.nextLong();
      long n = fs.nextLong();
      long[] result = binPowTransform(a, b, n);
      long ans = (result[0] + result[1]) % MOD;
      System.out.println(ans);
    }
  }
}
