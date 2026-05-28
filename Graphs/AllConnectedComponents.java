import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AllConnectedComponents {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] adjMatrix;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
  public static void main(String[] args)throws IOException {
    int V = createMatrix();
    visited = new boolean[V];
    // printMatrix(V);
    getComponent(V);
    for(ArrayList<Integer> list : finalList){
      for(int i : list) System.out.print(i+" ");
      System.out.println();
    }
  }
  public static void getComponent(int v){
    for(int i = 0; i < v; i++){
      ArrayList<Integer> res;
      if(!visited[i]){
        res = dfs(i, new ArrayList<>());
        if(res != null){
          Collections.sort(res); //very important if each component should be printed in increasing order
          finalList.add(res);
        }
      }
    }
  }

  public static ArrayList<Integer> dfs(int start, ArrayList<Integer> res){
    visited[start] = true;
    res.add(start);
    for(int i = 0; i < adjMatrix.length; i++){
      if(adjMatrix[start][i] == 1 && !visited[i]){
        dfs(i, res);
      }
    }
    return res;
  }

  public static int createMatrix() throws IOException{
    String[] line = br.readLine().trim().split(" ");
    int V = Integer.parseInt(line[0]);
    int E = Integer.parseInt(line[1]);
    adjMatrix= new int[V][V];
    for(int i = 0; i < E; i++){
      String[] vertex = br.readLine().trim().split(" ");
      int u = Integer.parseInt(vertex[0]);
      int v = Integer.parseInt(vertex[1]);
      adjMatrix[u][v] = 1;
      adjMatrix[v][u] = 1;
    }
    return V;
  }
  public static void printMatrix(int v){
    for(int i = 0; i < v; i++){
      for(int j = 0; j < v; j++){
        System.out.print(adjMatrix[i][j]+" ");
      }
      System.out.println();
    }
  }
}
