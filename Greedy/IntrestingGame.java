package Greedy;

import java.util.ArrayList;
import java.util.List;

public class IntrestingGame {
  static class Pair {
    int a;
    int b;

    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  public static void main(String[] args) throws Exception {
    int n = 3;
    int[] A = { 1, 3, 4 };
    int[] B = { 5, 3, 1 };

    List<Pair> pairs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      pairs.add(new Pair(A[i], B[i]));
    }

    // Collections.sort(pairs, (x, y) -> {
    // return ((y.a + y.b) - (x.a + x.b))
    // })
    pairs.sort((x, y) -> Long.compare(
        (long) y.a + y.b,
        (long) x.a + x.b)
    );
        
    long alice = 0;
    long bob = 0;
    int i = 0;
    for (Pair p : pairs) {
      if (i % 2 == 0) alice += p.a;
      else bob += p.b;
      i++;
    }
    if (alice > bob) System.out.println("Alice");
    else if (bob > alice) System.out.println("Bob");
    else System.out.println("Tie");

  }
}
