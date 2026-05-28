
import java.util.*;



public class PrimsAlgrorithmOptimized {

  static class Pair {
  int v;
  int wt;
  public Pair(int v, int wt) {
    this.v = v;
    this.wt = wt;
  }
}
  public int spanningTree(int V, int[][] edges) {
    // code here
    List<List<Pair>> list = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      list.add(new ArrayList<>());
    }
    for (int[] el : edges) {
      list.get(el[0]).add(new Pair(el[1], el[2]));
      list.get(el[1]).add(new Pair(el[0], el[2]));
    }

    boolean[] visited = new boolean[V];
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
    pq.offer(new Pair(0, 0));
    int mstWt = 0;
    while (!pq.isEmpty()) {
      Pair curr = pq.poll();
      int u = curr.v;
      int wt = curr.wt;
      if (visited[u]) continue;
      visited[u] = true;
      mstWt += wt;
      for (Pair neigh : list.get(u)) {
        if (!visited[neigh.v]) {
          pq.offer(new Pair(neigh.v, neigh.wt));
        }
      }
    }
    return mstWt;
  }

}
