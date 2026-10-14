package LineSweep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IntervalsTwo {
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

  static class Event {
    long x;
    int delta;
    Event(long x, int delta) {
      this.x = x;
      this.delta = delta;
    }
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    long L = fs.nextLong();
    List<Event> events = new ArrayList<>(2 * n);
    for (int i = 0; i < n; i++) {
      long l = fs.nextLong();
      long r = fs.nextLong();
      events.add(new Event(l, 1));
      events.add(new Event(r, -1));
    }
    events.sort((a, b) -> Long.compare(a.x, b.x));
    long coverage = 0;
    long minCoverage = Long.MAX_VALUE;
    int i = 0;
    while (i < events.size()) {
      long x = events.get(i).x;
      while (i < events.size() && events.get(i).x == x) {
        coverage += events.get(i).delta;
        i++;
      }
      if (x < L) {
        minCoverage = Math.min(minCoverage, coverage);
      }
    }
    long ans = n - minCoverage + 1;
    System.out.println(ans);
  }
}
