import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AliceAndBooks {
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
      int[] arr = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        arr[i] = fs.nextInt();
      }
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      int B = 0;
      for (int i = 1; i <= n; i++) {
        pq.offer(arr[i]);
        if (pq.size() > (B + 1)) pq.poll();
        if (pq.size() == (B + 1) && pq.peek() >= B + 1) B++;
        System.out.print(B + " ");
      }
      System.out.println();
    }
  }
}
