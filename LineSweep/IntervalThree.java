package LineSweep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class IntervalThree {
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

  static class Pair {
    int event;
    int type;
    int vOrI;
    Pair(int event, int type, int vOrI) {
      this.event = event;
      this.type = type;
      this.vOrI = vOrI;
    }
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    List<Pair> list = new ArrayList<>(2 * n);
    for (int i = 0; i < n; i++) {
      int l = fs.nextInt();
      int r = fs.nextInt();
      int x = fs.nextInt();
      list.add(new Pair(l, 0, x));
      list.add(new Pair(r, 2, x));
    }
    int q = fs.nextInt();
    int[] queries = new int[q];
    for (int i = 0; i < q; i++) {
      int y = fs.nextInt();
      int z = fs.nextInt();
      list.add(new Pair(y, 1, i));
      queries[i] = z;
    }
    list.sort((a, b) -> {
      if (a.event != b.event) return Integer.compare(a.event, b.event);
      else if (a.type != b.type)  return Integer.compare(a.type, b.type);
      return Integer.compare(a.vOrI, b.vOrI);
    });

    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (Pair p : list) {
      if (p.type == 0) {
        int x = p.vOrI;
        map.put(x, map.getOrDefault(x, 0) + 1);
      } else if (p.type == 2) {
        int x = p.vOrI;
        int count = map.get(x);
        if (count == 1) map.remove(x);
        else map.put(x, count - 1);
      } else if (p.type == 1) {
        int z = queries[p.vOrI];
        Integer res = map.floorKey(z);
        queries[p.vOrI] = (res == null) ? -1 : res;
      }
    }
    for (int x : queries) {
      System.out.println(x);
    }
  }
}
