package AZContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InventoryOptimization {
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
  private static long helper(long total, long[] inv2) {
    Arrays.sort(inv2);
    long used = 0;
    long matched = 0;
    for (long target : inv2) {
      if (used + target > total) break;
      used += target;
      matched++;
    }
    return matched;
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      int n = fs.nextInt();
      long[] inv2 = new long[n];
      long total1 = 0L;
      for (int i = 0; i < n; i++) {
        total1 += fs.nextLong();
      }
      long total2 = 0L;
      for (int i = 0; i < n; i++) {
        inv2[i] = fs.nextLong();
        total2 += inv2[i];
      }
      if (total1 > total2) System.out.println(n - 1);
      else if (total1 == total2) System.out.println(n);
      else {
        long ans = helper(total1, inv2);
        System.out.println(ans);
      }
    }
  }
}
