import java.util.*;
public class PrimsAlgorithm {
  static int[][] matrix;
  public static void main(String[] args){
    @SuppressWarnings("resource")
    Scanner s = new Scanner(System.in);
    int V = s.nextInt();
    int E = s.nextInt();
    matrix = new int[V][V];
    for(int i = 0; i < E; i++){
      int v1 = s.nextInt();
      int v2 = s.nextInt();
      int wt = s.nextInt();
      matrix[v1][v2] = wt;
      matrix[v2][v1] = wt;
    }
    primsAlgorithm();
  }

  public static void primsAlgorithm(){
    int V = matrix.length;
    boolean[] visited = new boolean[V];
    int[] parent = new int[V];
    int[] weight = new int[V];
    for(int i = 0; i < V; i++){
      parent[i] = -1;
      weight[i] = (i == 0) ? 0 : Integer.MAX_VALUE;
    }
    for(int i = 0; i < V-1; i++){
      int v = findVertexWithMinWeight(V, weight, visited);
      if(v == -1) return;
      visited[v] = true;
      for(int j = 0; j < V; j++){
        if(matrix[v][j] != 0 && !visited[j]){
          if(weight[j] > matrix[v][j]){
            weight[j] = matrix[v][j];
            parent[j] = v;
          }
        }
      }
    }
    print(parent, weight);
  }

  private static int findVertexWithMinWeight(int V, int[] weight,boolean[] visited){
    int min = Integer.MAX_VALUE, index = -1;
    for(int i = 0; i < V; i++){
      if(!visited[i] && weight[i] < min){
        min = weight[i];
        index = i;
      }
    }
    return index;
  }
  
  public static void print(int[] parent, int[] weight) {
    for (int i = 1; i < matrix.length; i++) {
      int a = parent[i];
      int b = i;
      if (a < b) {
        System.out.println(a + " " + b + " " + weight[i]);
      } else {
        System.out.println(b + " " + a + " " + weight[i]);
      }
    }
  }
}
