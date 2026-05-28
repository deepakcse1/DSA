
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Haspath {
  static int[][] matrix;
  static boolean[] visited;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
  public static void main(String[] args) throws IOException{
    int V = buildMatrix();
    print(V);
    hasPath(V);
  }
  public static void hasPath(int V) throws IOException {
    System.out.println("Enter v1 and v2 to find path");
    String[] vertex = br.readLine().trim().split(" ");
    int v1 = Integer.parseInt(vertex[0]);
    int v2 = Integer.parseInt(vertex[1]);
    visited = new boolean[V];
    System.out.println("Is path possible "+dfs(v1,v2));
  }
  public static boolean dfs(int v1, int v2){
    if(v1 == v2) return true;
    visited[v1] = true;
    for(int i = 0; i < matrix.length; i++){
      if(matrix[v1][i] == 1 && !visited[i]){
        if(dfs(i, v2)) return true;
      }
    }
    return false;
  }
  public static int buildMatrix() throws IOException{
    System.out.println("Enter no of vertex and edge");
    String[] nos = br.readLine().trim().split(" ");
    int V = Integer.parseInt(nos[0]);
    matrix = new int[V][V];
    int E = Integer.parseInt(nos[1]);
    for(int i = 0; i < E; i++){
      System.out.println("Enter 2 vertex to for edge");
      String[] edges = br.readLine().trim().split(" ");
      int u = Integer.parseInt(edges[0]);
      int v = Integer.parseInt(edges[1]);
      matrix[u][v] = 1;
      matrix[v][u] = 1;
    }
    return V;
  }
  public static void print(int V){
    for(int i = 0; i < V; i++){
      for(int j = 0; j < V; j++){
        System.out.print(matrix[i][j]+" ");
      }
      System.out.println();
    }
  }
}
