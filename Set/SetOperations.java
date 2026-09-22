package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SetOperations {
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
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      // code
      int n = fs.nextInt();
      int m = fs.nextInt();
      Set<Integer> setA = new TreeSet<>();
      Set<Integer> setB = new TreeSet<>();
      for (int i = 0; i < n; i++) {
        int x = fs.nextInt();
        setA.add(x);
      }
      for (int i = 0; i < m; i++) {
        int x = fs.nextInt();
        setB.add(x);
      }

      // A ∪ B
      Set<Integer> union = new TreeSet<>(setA);
      union.addAll(setB);

      // A ∩ B
      Set<Integer> intersection = new TreeSet<>(setA);
      intersection.retainAll(setB);

      // A - B
      Set<Integer> difference = new TreeSet<>(setA);
      difference.removeAll(setB);

      for (int el : union) {
        System.out.print(el + " ");
      }
      System.out.println();

      for (int el : intersection) {
        System.out.print(el + " ");
      }
      System.out.println();

      for (int el : difference) {
        System.out.print(el + " ");
      }
      System.out.println();
    }
  }
}
