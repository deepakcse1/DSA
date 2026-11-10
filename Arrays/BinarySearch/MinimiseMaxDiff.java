package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimiseMaxDiff {
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

  private static boolean isValid(long[] arr, long mid, long k) {
    // Im getting max seperation, I need to found <= k
    long needed = 0;
    int i = 1;
    while (i < arr.length) {
      needed += (arr[i] - arr[i - 1] + mid - 1) / mid - 1;
      i++;
    }
    return needed <= k;
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      int n = fs.nextInt();
      long k = fs.nextLong();
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = fs.nextLong();
      }

      // Question asking min seperation by passing K but I will check maximum possible
      // k within range by passing seperation - Binary Search
      long lo = 1;
      long hi = arr[n - 1] - arr[0];
      long ans = hi + 1;
      while (lo <= hi) {
        long mid = lo + (hi - lo) / 2;
        if (isValid(arr, mid, k)) {
          ans = mid;
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      }
      System.out.println(ans);
    }
  }
}
