package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoodPairs {
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
      int n = fs.nextInt();
      long[] arr = new long[n];
      long[] brr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = fs.nextLong();
      }
      for (int i = 0; i < n; i++) {
        brr[i] = fs.nextLong();
      }
      // -------------------------------------
      long[] crr = new long[n];
      for (int i = 0; i < n; i++) {
        crr[i] = arr[i] - brr[i];
      }
      Arrays.sort(crr);
      int left = 0;
      int right = n - 1;
      long count = 0;
      while (left < right) {
        if (crr[left] + crr[right] > 0) {
          count += right - left;
          right--;
        } else left++;
      }
      System.out.println(count);
    }
  }
}
