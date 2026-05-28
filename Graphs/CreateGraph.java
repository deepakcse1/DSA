
import java.util.Scanner;

public class CreateGraph {
  public static void main(String[] args) {
    int[][] adjencyMatrix = create();
    print(adjencyMatrix);
    dfs(adjencyMatrix);
  }
  public static int[][] create(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter no of vertices : ");
    int v = sc.nextInt();
    int[][] adjencyMatrix = new int[v][v];
    System.out.print("Enter no of edges : ");
    int e = sc.nextInt();
    System.out.println("Enter edges of each vertices ");
    for(int i = 0; i < e; i++){
      System.out.println("enter v1 and v2: ");
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();
      adjencyMatrix[v1][v2] = 1;
      adjencyMatrix[v2][v1] = 1;
    }
    sc.close();
    return adjencyMatrix;
  }
  public static void print(int[][] adjencyMatrix){
    int n = adjencyMatrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(adjencyMatrix[i][j]+" ");
      }
      System.out.println();
    }
  }
  public static void dfs(int[][] adjencyMatrix){
    boolean[] visited = new boolean[adjencyMatrix.length];
    dfsHelper(adjencyMatrix, 0, visited);
  }
  private static void dfsHelper(int[][] adjencyMatrix, int currVertex, boolean[] visited){
    visited[currVertex] = true;
    System.out.print(currVertex+" ");
    for(int i = 0; i < adjencyMatrix.length; i++){
      if(adjencyMatrix[currVertex][i] == 1 && visited[i] == false){
        dfsHelper(adjencyMatrix, i, visited);
      }
    }
  }
}
