import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GetPathDFS {
  static int[][] mat;
  static boolean[] visited;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args)throws IOException{
    int V = createMatrix();
    visited = new boolean[V];
    System.out.println("Enter v1 and v2 to find path");
    // String[] pathVertex = br.readLine().trim().split(" ");
    // int v1 = Integer.parseInt(pathVertex[0]);
    // int v2 = Integer.parseInt(pathVertex[1]);
    Scanner sc = new Scanner(System.in);
    int v1 = sc.nextInt();
    int v2 = sc.nextInt();
    sc.close();
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> res = getPath(v1, v2, list);
    System.out.print("Path is : ");
    if(res == null || res.size() == 0) return;
    for(int i : res) System.out.print(i+" ");
    System.out.println();
  }
  public static ArrayList<Integer> getPath(int v1, int v2, ArrayList<Integer> list){
     dfs(v1, v2, list);
     return list;
  }

  public static boolean dfs(int v1, int v2, ArrayList<Integer> list){
    if(v1 == v2){
      list.add(v1);
      return true;
    }
    visited[v1] = true;
    for(int i = 0; i < mat.length; i++){
     if(mat[v1][i] == 1 && !visited[i]){
       if(dfs(i, v2, list)){
         list.add(v1);
         return true;
       }
     }
    }
    return false;
  }

  public static int createMatrix() throws IOException{
    System.out.println("Enter no of vertices and edges");
    String[] line = br.readLine().trim().split(" ");
    int V = Integer.parseInt(line[0]);
    int E = Integer.parseInt(line[1]);
    mat = new int[V][V];

    for(int i = 0; i < E; i++){
      System.out.println("Enter 2 vertex to form edge");
      String[] vertex = br.readLine().trim().split(" ");
      int u = Integer.parseInt(vertex[0]);
      int v = Integer.parseInt(vertex[1]);
      mat[u][v] = 1;
      mat[v][u] = 1;
    }
    return V;
  }
}
