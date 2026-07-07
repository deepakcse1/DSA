import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ChipestFlightsWithinKStops {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<List<int[]>> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }
    int[] cost = new int[n];
    Arrays.fill(cost, Integer.MAX_VALUE);
    cost[src] = 0;
    for (int[] flight : flights) {
      list.get(flight[0]).add(new int[] { flight[1], flight[2] });
    }
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] { src, 0, -1 });
    while (!q.isEmpty()) {
      int[] curr = q.poll();
      for (int[] neigh : list.get(curr[0])) {
        if ((cost[neigh[0]] > curr[1] + neigh[1]) && curr[2] + 1 <= k) {
          cost[neigh[0]] = curr[1] + neigh[1];
          q.offer(new int[] { neigh[0], cost[neigh[0]], curr[2] + 1 });
        }
      }
    }
    return (cost[dst] == Integer.MAX_VALUE) ? -1 : cost[dst];
  }
}
