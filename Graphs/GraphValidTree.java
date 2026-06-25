import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {
  // DSU approach
  int[] parent;
  int[] rank;
  public boolean validTree_optimized(int n, int[][] edges) {
    // For an undirected graph with n nodes: Tree => exactly n - 1 edges
    // I forget everytime
    if (edges.length != n - 1) return false;
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      if (union(u, v)) return false;
    }
    return true;
  }

  public int find(int el) {
    if (parent[el] == el) return el;
    return find(parent[el]);
  }

  public boolean union(int u, int v) {
    int pU = find(u);
    int pV = find(v);
    if (pU == pV) return true;
    if (rank[pU] < rank[pV]) parent[pU] = pV;
    else if (rank[pU] > rank[pV]) parent[pV] = pU;
    else {
      parent[pV] = pU;
      rank[pU]++;
    }
    return false;
  }
  //-------------------------------------------------------------
  // DFS approach
  public boolean validTree(int n, int[][] edges) {
    if(edges.length != n-1) return false;
    List<List<Integer>> adjecencyList = new ArrayList<>();
    for(int i = 0; i < n; i++)  adjecencyList.add(new ArrayList<>());
    for(int[] edge : edges){
        adjecencyList.get(edge[0]).add(edge[1]);
        adjecencyList.get(edge[1]).add(edge[0]);
    }
    boolean[] visited = new boolean[n];
    if(hasCycle(0, -1, visited, adjecencyList)) return false;
    for(boolean v : visited) if(!v) return false;
    return true;
  }
  public boolean hasCycle(int vertex, int parent, boolean[] visited, List<List<Integer>> adjecencyList){
    visited[vertex] = true;
    for(int v : adjecencyList.get(vertex)){
        if(v == parent) continue;
        if(visited[v]) return true;
        if(hasCycle(v, vertex, visited, adjecencyList)) return true;
    }
    return false;
  }
}