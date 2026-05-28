package IsBipartite;

import java.util.Arrays;

public class BipartiteDFS {
  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] colored = new int[n];
    Arrays.fill(colored, -1);
    for (int i = 0; i < n; i++) {
      if (colored[i] == -1) {
        if (dfs(i, 0, colored, graph) == false) return false;
      }
    }
    return true;
  }

  public boolean dfs(int node, int colorCode, int[] colored, int[][] graph) {
    colored[node] = colorCode;
    for (int v : graph[node]) {
      if (colored[v] == -1) {
        if (dfs(v, 1 - colorCode, colored, graph) == false) return false;
      } else if (colored[v] == colorCode) return false;
    }
    return true;
  }
}
