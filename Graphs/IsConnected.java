import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsConnected {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] adjMatrix;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    int V = createMatrix();
    if(V == 0){
      System.out.print(true);
      return;
    }
    if(V == -1){
      System.out.print(false);
      return;
    }
    visited = new boolean[V];
    getPath(0);
    for(int i = 0; i < V; i++){
      if(!visited[i]){
        System.out.println(false);
        return;
      }
    }
    System.out.println(true);
  }

  public static void getPath(int start){
    visited[start] = true;
    for(int i = 0; i < adjMatrix.length; i++){
      if(adjMatrix[start][i] == 1 && !visited[i]){
        visited[i] = true;
        getPath(i);
      }
    }
  }

  public static int createMatrix() throws IOException{
    String[] noOfVE = br.readLine().trim().split(" ");
    int V = Integer.parseInt(noOfVE[0]);
    int E = Integer.parseInt(noOfVE[1]);
    if(V > 1 && E == 0)return -1;
    adjMatrix = new int[V][V];
    for(int i = 0; i < E; i++){
      String[] vertices = br.readLine().trim().split(" ");
      int v1 = Integer.parseInt(vertices[0]);
      int v2 = Integer.parseInt(vertices[1]);
      adjMatrix[v1][v2] = 1;
      adjMatrix[v2][v1] = 1;
    }
    return V;
  }
}
