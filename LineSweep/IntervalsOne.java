package LineSweep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntervalsOne {
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

  static class Interval {
    long l;
    long r;
    Interval(long l, long r) {
      this.l = l;
      this.r = r;
    }
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    long L = fs.nextLong();
    Interval[] intervals = new Interval[n];
    for (int i = 0; i < n; i++) {
      long l = fs.nextLong();
      long r = fs.nextLong();
      intervals[i] = new Interval(l, r);
    }
    Arrays.sort(intervals, (a, b) -> {
      if (a.l != b.l) return Long.compare(a.l, b.l);
      return Long.compare(a.r, b.r);
    });
    long covered = 0;
    long farthest = 0;
    int ans = 0;
    int i = 0;
    while (covered < L) {
      farthest = covered;
      while (i < n && intervals[i].l <= covered) {
        farthest = Math.max(farthest, intervals[i].r);
        i++;
      }
      // if(farthest == covered){
      //    System.out.println(-1);
      //    return;
      // }

      covered = farthest;
      ans++;
    }
    System.out.println(ans);
  }
}
