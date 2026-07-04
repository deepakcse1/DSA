import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
  class Pair {
    int node;
    int weight;

    public Pair(int node, int weight) {
      this.node = node;
      this.weight = weight;
    }
  }

  public int networkDelayTime(int[][] times, int n, int k) {
    List<List<Pair>> list = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
    }
    for (int[] time : times) {
      int u = time[0];
      int v = time[1];
      int w = time[2];
      list.get(u).add(new Pair(v, w));
    }
    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[k] = 0;
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
    pq.offer(new Pair(k, 0));
    while (!pq.isEmpty()) {
      Pair curr = pq.poll();
      //
      if (curr.weight > dist[curr.node])
        continue;
      for (Pair neigh : list.get(curr.node)) {
        if (dist[neigh.node] > dist[curr.node] + neigh.weight) {
          dist[neigh.node] = dist[curr.node] + neigh.weight;
          pq.offer(new Pair(neigh.node, dist[neigh.node]));
        }
      }
    }
    int max = 0;
    for (int i = 1; i <= n; i++) {
      if (dist[i] == Integer.MAX_VALUE)
        return -1;
      if (dist[i] > max)
        max = dist[i];
    }
    return max;
  }
}
