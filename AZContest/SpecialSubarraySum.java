package AZContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//https://maang.in/contests/attempts/113340?problem_id=21711&returnUrl=[%22/contests/B16-Phase-1-Contest-1704?returnUrl=[%22/cohorts/AZ-Premium-Cohort-16-84?tab=contests%22]
public class SpecialSubarraySum {
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
  private static long helper(int[] arr, int n) {
    int[] leftMaxBoundary = new int[n];
    int[] rightMaxBoundary = new int[n];
    int[] leftMinBoundary = new int[n];
    int[] rightMinBoundary = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) { // Max
      while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
      leftMaxBoundary[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }
    stack = new ArrayDeque<>();
    for (int i = n - 1; i >= 0; i--) { // Max
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) stack.pop();
      rightMaxBoundary[i] = stack.isEmpty() ? n : stack.peek();
      stack.push(i);
    }

    stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) { // Min
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
      leftMinBoundary[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }
    stack = new ArrayDeque<>();
    for (int i = n - 1; i >= 0; i--) { // Min
      while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
      rightMinBoundary[i] = stack.isEmpty() ? n : stack.peek();
      stack.push(i);
    }

    long maxRes = 0L;
    for (int i = 0; i < n; i++) {
      maxRes += (long) arr[i] * (i - leftMaxBoundary[i]) * (rightMaxBoundary[i] - i);
    }

    long minRes = 0L;
    for (int i = 0; i < n; i++) {
      minRes += (long) arr[i] * (i - leftMinBoundary[i]) * (rightMinBoundary[i] - i);
    }
    return maxRes - minRes;
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      int n = fs.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = fs.nextInt();
      }
      long ans = helper(arr, n);
      System.out.println(ans);
    }
  }
}
