package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dota2Senate {
  // Complexity : Each senator can survive and be re-added several times, but
  // every iteration permanently eliminates one senator.
  // Therefore:
  // Time: O(N) amortized
  // Space: O(N)
  public String predictPartyVictory(String senate) {
    Deque<Integer> radiant = new ArrayDeque<>();
    Deque<Integer> dire = new ArrayDeque<>();
    int n = senate.length();
    for (int i = 0; i < n; i++) {
      if (senate.charAt(i) == 'R') radiant.offer(i);
      else dire.offer(i);
    }
    while (!radiant.isEmpty() && !dire.isEmpty()) {
      int r = radiant.poll();
      int d = dire.poll();
      if (r < d) {
        // Radiant acts first and bans Dire
        radiant.offer(r + n);
      } else {
        // Dire acts first and bans Radiant
        dire.offer(d + n);
      }
    }
    return radiant.isEmpty() ? "Dire" : "Radiant";
  }
}
