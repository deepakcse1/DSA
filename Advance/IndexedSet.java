package Advance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IndexedSet {
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

  static class Fenwick {
    private final int n;
    private final int[] bit;

    Fenwick(int n) {
      this.n = n;
      this.bit = new int[n + 1];
    }

    void update(int i, int delta) {
      while (i <= n) {
        bit[i] += delta;
        i += i & -i;
      }
    }

    int query(int i) {
      int sum = 0;
      while (i > 0) {
        sum += bit[i];
        i -= i & -i;
      }
      return sum;
    }

    int total() {
      return query(n);
    }

    int findByOrder(int k) {
      int target = k + 1;
      int idx = 0;
      int step = Integer.highestOneBit(n);
      while (step > 0) {
        int next = idx + step;
        if (next <= n && bit[next] < target) {
          idx = next;
          target -= bit[next];
        }
        step >>= 1;
      }
      return idx + 1;
    }
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    final int MAXX = 100005;
    while (t-- > 0) {
      int n = fs.nextInt();
      Fenwick fenw = new Fenwick(MAXX + 2);
      boolean[] present = new boolean[MAXX + 3];
      for (int i = 0; i < n; i++) {
        String token = fs.next();
        if (token.equals("add")) {
          int el = fs.nextInt();
          if (el >= 1 && el <= MAXX && !present[el]) {
            present[el] = true;
            fenw.update(el, 1);
          }
        } else if (token.equals("remove")) {
          int el = fs.nextInt();
          if (el >= 1 && el <= MAXX && present[el]) {
            present[el] = false;
            fenw.update(el, -1);
          }
        } else if (token.equals("find")) {
          int idx = fs.nextInt();
          int total = fenw.total();
          if (idx < 0 || idx >= total) System.out.println(-1);
          else {
            int index = fenw.findByOrder(idx);
            System.out.println(index);
          }
        } else if (token.equals("findpos")) {
          int el = fs.nextInt();
          if (el <= 1) System.out.println(0);
          else if (el - 1 > MAXX) System.out.println(fenw.total());
          else {
            System.out.println(fenw.query(Math.min(el - 1, MAXX + 2)));
          }
        }
      }
    }
  }
}
