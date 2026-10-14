package PrefixAndPartial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodNumbers {
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
    FastScanner fs = new FastScanner();
    final int MAX = 1_000_005;
    int n = fs.nextInt();
    int k = fs.nextInt();
    int q = fs.nextInt();
    long[] diff = new long[MAX];
    for (int i = 0; i < n; i++) {
      int l = fs.nextInt();
      int r = fs.nextInt();
      diff[l]++;
      diff[r + 1]--;
    }
    for (int i = 1; i < MAX; i++) {
      diff[i] += diff[i - 1];
    }
    for (int i = 1; i < MAX; i++) {
      if (diff[i] >= k) diff[i] = 1;
      else diff[i] = 0;
    }
    for (int i = 1; i < MAX; i++) {
      diff[i] += diff[i - 1];
    }
    StringBuilder sb = new StringBuilder();
    while (q-- > 0) {
      int l = fs.nextInt();
      int r = fs.nextInt();
      long ans = diff[r] - diff[l - 1];
      sb.append(ans).append("\n");
    }
    System.out.print(sb);
  }
}
