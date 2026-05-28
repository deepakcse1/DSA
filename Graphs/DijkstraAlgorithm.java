
import java.util.Scanner;

public class DijkstraAlgorithm {
  static int[][] matrix;
  public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
      int V = s.nextInt();
      int E = s.nextInt();
      matrix = new int[V][V];
      for(int i = 0; i < E; i++){
        int v1 = s.nextInt();
        int v2 = s.nextInt();
        int distance = s.nextInt();
        matrix[v1][v2] = distance;
        matrix[v2][v1] = distance;
      }
      dijkstraAlgorithm(V);
    }
	}
  public static void dijkstraAlgorithm(int V){
    boolean[] visited = new boolean[V];
    int[] distance = new int[V];
    for(int i = 0; i < V; i++){
      distance[i] = (i == 0) ?  0 : Integer.MAX_VALUE;
    }
    for(int i = 0; i < V; i++){
      int v = findVertexWithMinWeight(V, distance, visited);
      visited[v] = true;
      for(int j = 0; j < V; j++){
        if(matrix[v][j] != 0 && !visited[j]){
          if(distance[j] > distance[v] + matrix[v][j]){
            distance[j] = distance[v] + matrix[v][j];
          }
        }
      }
    }
    for(int i = 0 ; i < V; i++) System.out.println(i+" "+distance[i]);
  }
  private static int findVertexWithMinWeight(int V, int[] distance,boolean[] visited){
    int min = Integer.MAX_VALUE, index = -1;
    for(int i = 0; i < V; i++){
      if(!visited[i] && distance[i] < min){
        min = distance[i];
        index = i;
      }
    }
    return index;
  }
}
