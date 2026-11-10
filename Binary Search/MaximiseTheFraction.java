import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MaximiseTheFraction {
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
    int t = fs.nextInt();
    while (t-- > 0) {
      int n = fs.nextInt();
      int k = fs.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = fs.nextInt();
      int[] brr = new int[n];
      for (int i = 0; i < n; i++) brr[i] = fs.nextInt();

      double lo = 0.0;
      double hi = 1e8;
      double ans = 0.0;
      while (Math.abs(lo - hi) > 1e-9) {
        double mid = (lo + hi) / 2.0;
        if (isValid(arr, brr, mid, k, n)) {
          ans = mid;
          lo = mid;
        } else hi = mid;
      }
      System.out.printf("%.6f\n", ans); // update ans -> "%.6f%n", ans
      // update println -> printf
    }
  }

  private static boolean isValid(int[] arr, int[] brr, double mid, int k, int n) {
    PriorityQueue<Double> pq = new PriorityQueue<>(); // issue 4, used generic "double"
    for (int i = 0; i < n; i++) {
      pq.offer(arr[i] - mid * brr[i]);
      if (pq.size() > k) pq.poll();
    }
    double sum = 0.0;
    while (!pq.isEmpty()) {
      sum += pq.poll();
    }
    return sum >= 0.0;
  }
}
