import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ColorBalls {
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

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      long n = fs.nextLong();
      long k = fs.nextLong();
      Map<Long, Long> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        long val = fs.nextLong();
        map.put(val, map.getOrDefault(val, 0L) + 1);
      }
      long lo = 1L;
      long hi = n / k;
      long ans = 0L;
      while (lo <= hi) {
        long mid = lo + (hi - lo) / 2L;
        if (isValid(map, mid, k)) {
          ans = mid;
          lo = mid + 1L;
        } else hi = mid - 1L;
      }
      System.out.println(ans);
    }
  }

  private static boolean isValid(Map<Long, Long> map, long mid, long k) {
    long count = 0;
    for (Long el : map.values()) {
      count += Math.min(el, mid);
    }
    return count >= mid * k;
  }
}
