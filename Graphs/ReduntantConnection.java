public class ReduntantConnection {
  public static void main(String[] args) {

  }

  int[] parent;
  int[] rank;
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    parent = new int[n + 1];
    rank = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }
    for (int[] el : edges) {
      if (!dsu(el[0], el[1])) {
        return el;
      }
    }
    return new int[] { -1, -1 };
  }

  public boolean dsu(int u, int v) {
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

  public int find(int el) {
    if (parent[el] == el) return el;
    return parent[el] = find(parent[el]);
  }
    //-------------------------------DFS Solution------------------
    // public int[] findRedundantConnection(int[][] edges) {
    //     int n = edges.length;
    //     List<Integer>[] list = new ArrayList[n+1];
    //     for(int i = 0; i <= n; i++){
    //         list[i] = new ArrayList<>();
    //     }
    //     for(int[] edge : edges){
    //         int[] visited = new int[n+1];
    //         int u = edge[0];
    //         int v = edge[1];
    //         if(dfs(u, v, visited, list)){
    //             return edge;
    //         }
    //         list[u].add(v);
    //         list[v].add(u);
    //     }
    //     return new int[]{-1,-1};
    // }
    // public boolean dfs(int src, int dest, int[] visited, List<Integer>[] list){
    //     if(src == dest) return true;
    //     visited[src] = 1;
    //     for(int neigh : list[src]){
    //         if(visited[neigh] == 0){
    //             if(dfs(neigh, dest, visited, list)) return true;
    //         }
    //     } 
    //     return false;
    // }
}
