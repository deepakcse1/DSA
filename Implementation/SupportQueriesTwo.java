package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class SupportQueriesTwo {
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
    int q = fs.nextInt();
    int k = fs.nextInt();
    long sum = 0L;
    TreeMap<Integer, Integer> map1 = new TreeMap<>();
    TreeMap<Integer, Integer> map2 = new TreeMap<>();
    int count = 0;
    while (q-- > 0) {
      int x = fs.nextInt();
      if (x == 1) {
        int el = fs.nextInt();
        map1.put(el, map1.getOrDefault(el, 0) + 1);
        sum += el;
        count++;
        if (count > k) {
          int firstKey = map1.firstKey();
          int freq = map1.get(firstKey);
          if (freq == 1) map1.remove(firstKey);
          else map1.put(firstKey, firstKey - 1);
          map2.put(firstKey, map2.getOrDefault(firstKey, 0) + 1);
          sum -= firstKey;
          count--;
        }
      } else if (x == 2) {
        int el = fs.nextInt();
        if (map1.containsKey(el)) {
          int freq = map1.get(el);
          if (freq == 1) map1.remove(el);
          else map1.put(el, freq - 1);
          sum -= el;
          count--;
          while (count < k && map2.size() > 0) {
            int lastKey = map2.lastKey();
            int freq2 = map2.get(lastKey);
            if (freq2 == 1) map2.remove(lastKey);
            else map2.put(lastKey, freq2 - 1);
            map1.put(lastKey, map1.getOrDefault(lastKey, 0) + 1);
            sum += lastKey;
            count++;
          }
        } else if (map2.containsKey(el)) {
          int freq = map2.get(el);
          if (freq == 1) map2.remove(el);
          else map2.put(el, freq - 1);
        }
      } else if (x == 3) {
        String ques = fs.next();
        System.out.println(sum);
      }
      // System.out.println();
    }
  }
}
