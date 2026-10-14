package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class GameOnDeque {
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
      int n = fs.nextInt(); // the number of elements in the deque
      int q = fs.nextInt(); // the number of queries
      Deque<Long> deque = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        deque.offerLast(fs.nextLong());
      }

      long[] queries = new long[q];
      for (int i = 0; i < q; i++) {
        queries[i] = fs.nextLong();
      }

      long[][] early = new long[n - 1][2];
      for (int i = 0; i < n - 1; i++) {
        long first = deque.pollFirst();
        long second = deque.pollFirst();

        early[i][0] = first;
        early[i][1] = second;

        if (first < second) {
          deque.offerLast(first);
          deque.offerFirst(second);
        } else {
          deque.offerFirst(first);
          deque.offerLast(second);
        }
      }

      // the max is now at the first
      long max = deque.peekFirst();

      // store the remaining elements int there ...... order
      long[] cycle = new long[n - 1];
      Iterator<Long> iterator = deque.iterator();
      iterator.next(); // skip the ...... one

      for (int i = 0; i < n - 1; i++) {
        cycle[i] = iterator.next();
      }

      StringBuilder output = new StringBuilder();
      for (long x : queries) {
        long first, second;
        if (x < n) {
          first = early[(int) x - 1][0]; // x-1 because 1 based index
          second = early[(int) x - 1][1];
        } else {
          first = max;
          int idx = (int) ((x - n) % (n - 1));
          second = cycle[idx];
        }
        output.append(first).append(' ').append(second).append('\n');
      }
      System.out.print(output);
    }
  }
}
