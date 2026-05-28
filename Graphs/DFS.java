
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFS {
  static int[][] adjencyMatrix;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    // adjencyMatrix = {{0, 1, 1, 0, },{1, 0, 0, 1, },{1, 0, 0, 0, },{0, 1, 0, 0 }};
    int V = createMatrix();
    getPath(V);
  }
  public static void getPath(int V){
    visited = new boolean[V];
    for(int i = 0; i < V; i++){
      if( !visited[i]){
        dfs(i);
        System.out.println();
      }
    }
  }
  private static void dfs(int start){
    visited[start] = true;
    System.out.print(start+" ");
    for(int i = 0; i < adjencyMatrix.length; i++){
      if(adjencyMatrix[start][i] == 1 && !visited[i]){
        dfs(i);
      }
    }
  }

  public static int createMatrix() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter no of vertices and edges");
    String[] size = br.readLine().trim().split(" ");
    int V = Integer.parseInt(size[0]);
    int E = Integer.parseInt(size[1]);
    adjencyMatrix = new int[V][V];
    for(int i = 0; i < E; i++){
      System.out.println("enter 2 vertex to draw edge");
      String[] edge = br.readLine().trim().split(" ");
      int u = Integer.parseInt(edge[0]);
      int v = Integer.parseInt(edge[1]);
      adjencyMatrix[u][v] = 1;
      adjencyMatrix[v][u] = 1;
    }
    return V;
  }
}

