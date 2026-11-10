package TwoPointer.Form1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MedianOfSubarraySum {
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
  private static boolean isValid(long[] arr, long k, int n, long mid) {
    int head = -1;
    int tail = 0;
    long count = 0L;
    long prefixSum = 0L;
    while (tail < n) {
      while (head < n - 1 && (prefixSum + arr[head + 1]) <= mid) {
        head++;
        prefixSum += arr[head];
      }
      count += head - tail + 1;
      if (tail <= head) {
        prefixSum -= arr[tail];
        tail++;
      } else {
        tail++;
        head = tail - 1;
      }
    }
    return count >= k;
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      int n = fs.nextInt();
      long[] arr = new long[n];
      long sum = 0;
      long min = Long.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        arr[i] = fs.nextLong();
        min = Math.min(min, arr[i]);
        sum += arr[i];
      }
      // Arrays.sort(arr);
      long noOfSubarrays = (long) n * (n + 1) / 2;
      long k = (noOfSubarrays + 1) / 2;
      long lo = min;
      long hi = sum;
      long ans = -1L;
      while (lo <= hi) {
        long mid = lo + (hi - lo) / 2;
        if (isValid(arr, k, n, mid)) {
          ans = mid;
          hi = mid - 1;
        } else lo = mid + 1;
      }
      System.out.println(ans);
    }
  }
}
