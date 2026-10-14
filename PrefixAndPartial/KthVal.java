package PrefixAndPartial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KthVal {
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

  static class Pair {
    int value;
    long frequency;

    Pair(int value, long frequency) {
      this.value = value;
      this.frequency = frequency;
    }
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      int n = fs.nextInt();
      int m = fs.nextInt();
      int q = fs.nextInt();
      int[] arr = new int[n + 1]; // 1-based input
      int[] diff = new int[n + 2];
      for (int i = 1; i <= n; i++) {
        arr[i] = fs.nextInt();
      }
      for (int i = 1; i <= m; i++) {
        int l = fs.nextInt();
        int r = fs.nextInt();
        diff[l]++;
        diff[r + 1]--;
      }
      for (int i = 1; i <= n; i++) {
        diff[i] += diff[i - 1];
      }

      List<Pair> list = new ArrayList<>();
      for(int i = 1; i <= n; i++){
        if(diff[i] > 0) list.add(new Pair(arr[i], diff[i]));
      }
      list.sort((a, b) -> Integer.compare(a.value, b.value));

      long cumulative = 0;
      for (Pair p : list) {
        cumulative += p.frequency;
        p.frequency = cumulative;
      }

      while (q-- > 0) {
        long k = fs.nextLong();
        int idx = lowerBound(list, k);
        if (idx == -1)  System.out.print(-1 + " ");
        else  System.out.print(list.get(idx).value + " ");
      }
      System.out.println();
    }
  }

  private static int lowerBound(List<Pair> list, long k) {
    int start = 0;
    int end = list.size() - 1;
    if (list.isEmpty() || list.get(end).frequency < k) return -1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (list.get(mid).frequency >= k) end = mid;
      else start = mid + 1;
    }
    return start;
  }
}
