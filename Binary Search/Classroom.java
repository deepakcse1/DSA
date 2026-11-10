import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Classroom {
  // https://maang.in/problems/ClassRoom-471?resourceUrl=pl3462-rs471&returnUrl=%5B%22%2Fcohorts%2FAZ-Premium-Cohort-16-84%3Ftab%3Dassignments%22%5D&tab=description
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
    int t = fs.nextInt();
    while (t-- > 0) {
      int n = fs.nextInt();
      long k = fs.nextLong();
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = fs.nextLong();
      }
      Arrays.sort(arr);
      long lo = 1;
      long hi = arr[n - 1] - arr[0]; // max;
      long ans = 0;
      while (lo <= hi) {
        long mid = lo + (hi - lo) / 2;
        if (isValid(mid, arr, k, n)) {
          ans = mid;
          lo = mid + 1;
        } else hi = mid - 1;
      }
      System.out.println(ans);
    }
  }

  private static boolean isValid(long mid, long[] arr, long k, int n) {
    long count = 1;
    int lastPos = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i] - arr[lastPos] >= mid) {
        count++;
        lastPos = i;
        if (count >= k) return true;
      }
    }
    return false;
  }
}
