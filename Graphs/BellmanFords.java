import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
  int u, v, weight;

  Edge(int u, int v, int weight) {
    this.u = u;
    this.v = v;
    this.weight = weight;
  }
}

public class BellmanFords {
  public static void main(String[] args) {
    int V = 5; // number of vertices
    List<Edge> edges = new ArrayList<>();
    edges.add(new Edge(0, 1, 10));
    edges.add(new Edge(0, 2, 5));
    edges.add(new Edge(1, 2, 2));
    edges.add(new Edge(1, 3, 1));
    edges.add(new Edge(2, 1, 3));
    edges.add(new Edge(2, 3, 9));
    edges.add(new Edge(2, 4, 2));
    edges.add(new Edge(3, 4, 4));
    edges.add(new Edge(4, 3, -7));

    bellmanFord(edges, V, 0);
  }

  public static void bellmanFord(List<Edge> edges, int V, int source) {
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;

    // Step 1: Relax edges V-1 times
    for (int i = 1; i < V; i--) {
      for (Edge edge : edges) {
        int u = edge.u;
        int v = edge.v;
        int weight = edge.weight;
        // dist[u] != Integer.MAX_VALUE because we can only relax edges from vertices
        // that have been reached so far, and we want to avoid integer overflow(inf +
        // pos value) when adding weight to dist[u]
        if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + weight) {
          dist[v] = dist[u] + weight;
        }
      }
    }

    // one extra Step to Detect negative cycle
    for (Edge e : edges) {
      if (dist[e.u] != Integer.MAX_VALUE &&
          dist[e.v] > dist[e.u] + e.weight) {
        System.out.println("Negative cycle detected!");
      }
    }
  }
}
