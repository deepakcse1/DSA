package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Collision {
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
      int ballsInX = fs.nextInt();
      int ballsInY = fs.nextInt();
      Map<Long, Integer> map = new HashMap<>();
      for (int i = 0; i < ballsInX; i++) {
        int pos = fs.nextInt();
        int speed = fs.nextInt();
        long ball = (long) pos * speed;
        map.put(ball, map.getOrDefault(ball, 0) + 1);
      }
      long ans = 0;
      for (int i = 0; i < ballsInY; i++) {
        int pos = fs.nextInt();
        int speed = fs.nextInt();
        long ball = (long) pos * speed;
        if (map.containsKey(ball)) {
          ans++;
          int freq = map.get(ball);
          if (freq == 1)
            map.remove(ball);
          else
            map.put(ball, freq - 1);
        }
      }
      System.out.println(ans);
    }
  }
}
