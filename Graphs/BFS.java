
import java.util.*;
import java.io.*;

public class BFS {
  static int[][] adj;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    int V = createMatrix();
    bfsDisconnectedGraph(V);
  }

  public static void bfsDisconnectedGraph(int V) {
    visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) bfsFromNode(i);
    }
  }
  
  public static void bfsFromNode(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    visited[start] = true;
    while (!q.isEmpty()) {
      int node = q.poll();
      System.out.print(node + " ");
      for (int i = 0; i < adj.length; i++) {
        if (adj[node][i] == 1 && !visited[i]) {
          q.add(i);
          visited[i] = true;
        }
      }
    }
  }

  public static int createMatrix() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter no of vertices and edges");
    String[] size = br.readLine().trim().split(" ");
    int V = Integer.parseInt(size[0]);
    int E = Integer.parseInt(size[1]);
    adj = new int[V][V];
    for(int i = 0; i < E; i++){
      System.out.println("enter 2 vertex to draw edge");
      String[] edge = br.readLine().trim().split(" ");
      int u = Integer.parseInt(edge[0]);
      int v = Integer.parseInt(edge[1]);
      adj[u][v] = 1;
      adj[v][u] = 1;
    }
    return V;
  }
}
