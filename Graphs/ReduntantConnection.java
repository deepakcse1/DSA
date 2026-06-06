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
}
