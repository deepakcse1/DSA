import java.util.ArrayList;
import java.util.List;

public class DetectACycleInDirectedGraph {

  public static boolean hasCycle(int V, List<List<Integer>> adjList) {
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (hasCycleDFS(i, visited, recStack, adjList)) {
        return true;
      }
    }
    return false;
  }

  public static boolean hasCycleDFS(int curr, boolean[] visited, boolean[] recursionPath, List<List<Integer>> adjList){
    visited[curr] = true;
    recursionPath[curr] = true;
    for(int el : adjList.get(curr)){
      if(!visited[el]){
        if(hasCycleDFS(el, visited, recursionPath, adjList)) return true;
      }else if(recursionPath[el]) return true;
    }
    recursionPath[curr] = false;
    return false;
  }

  public static void main(String[] args) {
    int V = 4;
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adjList.add(new ArrayList<>());
    }
    adjList.get(1).add(2);
    adjList.get(2).add(3);
    adjList.get(3).add(1);

    System.out.println("Has Cycle: " + hasCycle(V, adjList));
  }
}
