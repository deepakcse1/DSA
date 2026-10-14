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

// Adding n represents the senator's next turn in the next round. For example, index 0 becomes 0 + n, meaning that senator acts after all senators in the current cycle.

// Comparing the indices tells us who acts first:

// If r < d, Radiant acts first and bans Dire.

// Otherwise, Dire acts first and bans Radiant.

// 4. Complexity

// Let n be the length of senate.

// Time: O(n) — each senator is processed at most once as a survivor per round; each ban removes one senator, so there are at most n ban operations.

// Space: O(n) — the two queues store the active senators.
