import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PainterPartition {
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

  private static boolean isValid(long time, long k, long[] arr) {
    long timeLeft = time;
    int i = 0;
    while (k > 0) {
      while (i < arr.length && arr[i] <= timeLeft) {
        timeLeft -= arr[i++];
      }
      if (i == arr.length) return true;
      k--;
      timeLeft = time;
    }
    return false;
  }

  private static long binarySearch(long[] arr, long max, long sum, int k) {
    long lo = max;
    long hi = sum;
    long ans = hi + 1;
    while (lo <= hi) {
      long mid = lo + (hi - lo) / 2;
      if (isValid(mid, k, arr)) {
        ans = mid;
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      int n = fs.nextInt();
      int k = fs.nextInt();
      long[] arr = new long[n];
      long max = 0;
      long sum = 0;
      for (int i = 0; i < n; i++) {
        arr[i] = fs.nextLong();
        max = Math.max(max, arr[i]);
        sum += arr[i];
      }
      long ans = binarySearch(arr, max, sum, k);
      System.out.println(ans);
    }
  }
}
