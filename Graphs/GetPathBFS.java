import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class GetPathBFS {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] adjMatrix;
  static boolean[] visited;
  static ArrayList<Integer> list;
  public static void main(String[] args) throws IOException{
    int V = createMatrix();
    visited = new boolean[V];
    ArrayList<Integer> list = getPath(V);
    System.out.print("list is : ");
    for(int i : list){
      System.out.print(i+" ");
    }
    System.out.println();
  }
  public static ArrayList<Integer> getPath(int V) throws IOException{
    System.out.print("Enter 2 vertices to get path : ");
    String[] vertices = br.readLine().trim().split(" ");
    int source = Integer.parseInt(vertices[0]);
    int destination = Integer.parseInt(vertices[1]);
    return bfs(source, destination, V);
  }
  public static ArrayList<Integer> bfs(int source, int destination, int V){
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(source, -1);
    visited[source] = true;
    boolean pathFound = false;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      for(int i = 0 ; i < V; i++){
        if(adjMatrix[node][i] == 1 && !visited[i]){
          queue.add(i);
          visited[i] = true;
          map.put(i, node);
          if(i == destination){
            pathFound = true;
            break;
          }
        }
      }
    }
    if(pathFound){
      ArrayList<Integer> path = new ArrayList<>();
      int currVertex = destination;
      while (currVertex != -1) {
        System.out.print(currVertex+" ");
        path.add(currVertex);
        currVertex = map.get(currVertex);        
      }
      System.out.println();
      return path;
    }else return null;
  }

  public static int createMatrix() throws IOException{
    System.out.print("Inter no of vertices and edges : ");
    String[] noOfVE = br.readLine().trim().split(" ");
    int V = Integer.parseInt(noOfVE[0]);
    int E = Integer.parseInt(noOfVE[1]);
    adjMatrix = new int[V][V];
    for(int i = 0; i < E; i++){
      System.out.print("enter 2 vertices | "+(i+1)+" : ");
      String[] vertices = br.readLine().trim().split(" ");
      int v1 = Integer.parseInt(vertices[0]);
      int v2 = Integer.parseInt(vertices[1]);
      adjMatrix[v1][v2] = 1;
      adjMatrix[v2][v1] = 1;
    }
    return V;
  }
}
