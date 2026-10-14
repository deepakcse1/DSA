package PrefixAndPartial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LRSumQuery {
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

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    int q = fs.nextInt();
    long[] pre = new long[n + 2];
    long MOD = 1_000_000_007;
    for (int i = 0; i < n; i++) {
      long x = fs.nextLong();
      pre[i + 1] = ((pre[i] + x) % MOD + MOD) % MOD;
    }
    StringBuilder sb = new StringBuilder();
    while (q-- > 0) {
      int l = fs.nextInt();
      int r = fs.nextInt();
      long ans = (pre[r] - pre[l - 1] + MOD) % MOD;
      sb.append(ans).append('\n');
    }
    System.out.print(sb);
  }
}
