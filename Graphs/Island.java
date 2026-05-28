
import java.io.*;
public class Island {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] matrix;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    int V = createMatrix();
    visited = new boolean[V];
    int count = isIsland(V);
    System.out.println(count);
  }
  
  public static int isIsland(int V){
    int count = 0;
    for(int i = 0; i < V; i++){
      if(!visited[i]){
        count++;
        dfs(i);
      }
    }
    return count;
  }

  private static void dfs(int start){
    visited[start] = true;
    for(int i = 0; i < matrix.length; i++){
      if(matrix[start][i] == 1 && !visited[i]) dfs(i);
    }
  }

  private static int createMatrix() throws IOException{
    String[] line = br.readLine().trim().split(" ");
    int V = Integer.parseInt(line[0]);
    int E = Integer.parseInt(line[1]);
    matrix = new int[V][V];
    for(int i = 0; i < E; i++){
      String[] vertex = br.readLine().trim().split(" ");
      int u = Integer.parseInt(vertex[0]);
      int v = Integer.parseInt(vertex[1]);
      matrix[u][v] = 1;
      matrix[v][u] = 1;
    }
    return V;
  }
}
