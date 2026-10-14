package Map.TreeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.TreeSet;

public class MaximumArea {
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

  private static void helper(int x, TreeSet<Integer> set, TreeMap<Integer, Integer> map) {
    int lowCut = set.lower(x);
    int highCut = set.higher(x);
    int mapKey = highCut - lowCut;
    int freq = map.get(mapKey);
    if (freq == 1) map.remove(mapKey);
    else map.put(mapKey, freq - 1);
    int l = x - lowCut;
    int r = highCut - x;
    map.put(l, map.getOrDefault(l, 0) + 1);
    map.put(r, map.getOrDefault(r, 0) + 1);
    set.add(x);
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      int H = fs.nextInt();
      int W = fs.nextInt();
      int N = fs.nextInt();
      TreeMap<Integer, Integer> hMap = new TreeMap<>(); // stores horizontal length
      TreeMap<Integer, Integer> vMap = new TreeMap<>(); // stores verticle length
      hMap.put(H, 1);
      vMap.put(W, 1);
      TreeSet<Integer> hSet = new TreeSet<>(); // stores horizontal cut points
      TreeSet<Integer> vSet = new TreeSet<>(); // stores verticle cut points
      hSet.add(0);
      hSet.add(H);
      vSet.add(0);
      vSet.add(W);
      for (int i = 0; i < N; i++) {
        String input = fs.next();
        if (input.equals("H")) {
          int x = fs.nextInt();
          helper(x, hSet, hMap);
        } else {
          int x = fs.nextInt();
          helper(x, vSet, vMap);
        }
        int height = hMap.lastKey();
        int width = vMap.lastKey();
        System.out.println((long) height * width);
      }
    }
  }
}
