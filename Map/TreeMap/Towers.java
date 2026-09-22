package Map.TreeMap;

import java.util.TreeMap;

public class Towers {
  public static void main(String[] args) throws Exception {
    // FastScanner fs = new FastScanner();
    int t = 1; // fs.nextInt();
    while (t-- > 0) {
      int n = 1; // fs.nextInt();
      TreeMap<Integer, Integer> map = new TreeMap<>();
      int tower = 0;
      for (int i = 0; i < n; i++) {
        int x = 1; // fs.nextInt();
        Integer top = map.higherKey(x);
        // Remove one tower with this top
        if (top == null) tower++;
        else {
          if (map.get(top) == 1) map.remove(top);
          else map.put(top, map.get(top) - 1);
        }
        // x becomes the new top
        map.put(x, map.getOrDefault(x, 0) + 1);
      }
      System.out.println(tower);
    }
  }
}
