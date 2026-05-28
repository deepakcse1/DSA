import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {
  public boolean validTree(int n, int[][] edges) {

    // Tree must have exactly n-1 edges
    if (edges.length != n - 1)
      return false;

    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    // Build graph
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    boolean[] visited = new boolean[n];

    // Start DFS from node 0
    if (hasCycle(0, -1, visited, graph)) {
      return false;
    }

    // Check connectivity
    for (boolean node : visited) {
      if (!node)
        return false;
    }

    return true;
  }

  private boolean hasCycle(int node, int parent,
      boolean[] visited,
      List<List<Integer>> graph) {

    visited[node] = true;

    for (int neighbor : graph.get(node)) {

      // Skip parent
      if (neighbor == parent)
        continue;

      // Cycle found
      if (visited[neighbor])
        return true;

      if (hasCycle(neighbor, node, visited, graph)) {
        return true;
      }
    }

    return false;
  }
}