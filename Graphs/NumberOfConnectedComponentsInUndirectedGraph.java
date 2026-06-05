import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponentsInUndirectedGraph {
  public static void main(String[] args) {

  }

  // DSU Solution
  int[] parent;
  int[] rank;
  public int countComponents_optimized(int n, int[][] edges) {
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
    int component = n;
    for (int[] el : edges) {
      if (union(el[0], el[1])) {
        component--;
      }
    }
    return component;
  }

  public int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  public boolean union(int u, int v) {
    int pU = find(u);
    int pV = find(v);
    if (pU == pV) return false;
    if (rank[pU] < rank[pV]) parent[pU] = pV;
    else if (rank[pU] > rank[pV]) parent[pV] = pU;
    else {
      parent[pV] = pU;
      rank[pU]++;
    }
    return true;
  }

  // DFS Solution
  public int countComponents(int n, int[][] edges) {
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }
    for (int[] el : edges) {
      list.get(el[0]).add(el[1]);
      list.get(el[1]).add(el[0]);
    }
    boolean[] visited = new boolean[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i, list, visited);
        count++;
      }
    }
    return count;
  }

  public void dfs(int i, List<List<Integer>> list, boolean[] visited) {
    if (visited[i]) return;
    visited[i] = true;
    for (int el : list.get(i)) {
      dfs(el, list, visited);
    }
  }
}
