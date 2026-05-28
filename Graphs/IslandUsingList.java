
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IslandUsingList {
  public static void main(String[] args) {
    List<List<Integer>> list = buildGraph();
    print(list);
    System.out.println("isConnected :"+isConnected(list));
  }

  private static int isConnected(List<List<Integer>> list){
    boolean[] visited = new boolean[list.size()];
    int count = 0;
    for(int i = 0; i < list.size(); i++){
      if(!visited[i]){
        count++;
        bfs(i, list, visited);
      }
    }
    return count;
  }

  private static void bfs(int node, List<List<Integer>> list, boolean[] visited){
    visited[node] = true;
    for(int neighbour : list.get(node)){
      if(!visited[neighbour]){
        bfs(neighbour, list, visited);
      }
    }
  }

  private static void print(List<List<Integer>> list){
    for(List<Integer> ls : list){
      for(int i : ls){
        System.out.print(i+" ");
      }
      System.out.println();
    }
  }

  private static List<List<Integer>> buildGraph(){
    try (Scanner sc = new Scanner(System.in)) {
      int V = sc.nextInt();
      int E = sc.nextInt();
      List<List<Integer>> adjacencyList = new ArrayList<>();
      for(int i = 0; i < V; i++){
        adjacencyList.add(new ArrayList<>());
      }
      for(int i = 0; i < E; i++){
        int u = sc.nextInt();
        int v = sc.nextInt();
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
      }
      return adjacencyList;
    }
  }
}
