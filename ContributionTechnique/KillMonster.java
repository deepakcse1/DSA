package ContributionTechnique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KillMonster {
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

  static class Monster {
    int a;
    int b;

    Monster(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      // code
      int n = fs.nextInt();
      // Monster[] monster = new Monster[n];
      List<Monster> monster = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int soldier = fs.nextInt();
        int dead = fs.nextInt();
        Monster m = new Monster(soldier, dead);
        monster.add(m);
      }

      Collections.sort(monster, (x, y) -> {
        long dx = (long) x.a - y.a;
        long dy = (long) x.b - y.b;
        return Long.compare(dy, dx);
      });
      long dead = 0;
      long ans = 0;
      for (Monster m : monster) {
        ans = Math.max(ans, dead + m.a);
        dead += m.b;
      }
      System.out.println(ans);
    }
  }
}
