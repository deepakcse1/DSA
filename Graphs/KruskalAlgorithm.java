
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
  int v1, v2, weight;

  Edge(int v1, int v2, int weight) {
    this.v1 = v1;
    this.v2 = v2;
    this.weight = weight;
  }

  @Override
  public int compareTo(Edge o) {
    if (o == null) {
      throw new NullPointerException();
    }
    return this.weight - o.weight;
  }
}

// 🟦 When is Kruskal better than Prim?

// Works better when:
// ✔ Graph has more edges
// ✔ Edges are easy to sort
// ✔ You need MST for disconnected graph → will give Minimum Spanning Forest

public class KruskalAlgorithm {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int V = sc.nextInt();
    int[][] edges = new int[V][V];
    int E = sc.nextInt();
    for (int i = 0; i < E; i++) {
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();
      int weight = sc.nextInt();
      edges[i] = new int[] { v1, v2, weight };
    }
    int mstWeight = kruskalsMST(V, edges);
    System.out.println(mstWeight);
    sc.close();
  }

  // V = 3, E = 3, edges[][] = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]
  public static int kruskalsMST(int V, int[][] edges) {
    // code here
    Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
    int[] parent = new int[V];
    int[] rank = new int[V];
    for (int i = 0; i < V; i++) {
      parent[i] = i;
    }
    return helper(edges, V, parent, rank);
  }

  public static int helper(int[][] edges, int V, int[] parent, int[] rank) {
    int mstWeight = 0;
    int edgeCount = 0;
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      int parentU = find(u, parent);
      int parentV = find(v, parent);
      if (parentU != parentV) {
        union(parentU, parentV, parent, rank);
        mstWeight += edge[2];
        edgeCount++;
        if (edgeCount == V - 1) break;
      }
    }
    return mstWeight;
  }

  public static int find(int el, int[] parent) {
    if (parent[el] != el) {
      parent[el] = find(parent[el], parent);
    }
    return parent[el];
  }

  public static void union(int pU, int pV, int[] parent, int[] rank) {
    if (rank[pU] < rank[pV]) parent[pU] = pV;
    else if (rank[pV] < rank[pU]) parent[pV] = pU;
    else {
      parent[pV] = pU;
      rank[pU]++;
    }
  }

}
