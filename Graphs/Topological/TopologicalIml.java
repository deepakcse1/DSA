package Topological;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalIml {
  // Topological Sort using DFS
  public void topologicalSortDFS(int V, List<List<Integer>> adjList) {
    boolean[] visited = new boolean[V];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, visited, stack, adjList);
      }
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }   

  private void dfs(int curr, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adjList) {
    visited[curr] = true;
    for (int neighbor : adjList.get(curr)) {
      if (!visited[neighbor]) {
        dfs(neighbor, visited, stack, adjList);
      }
    }
    stack.push(curr);
  }
  public static void main(String[] args) {
    
     int V = 6;
     List<List<Integer>> adjList = new ArrayList<>();
      for (int i = 0; i < V; i++) {
        adjList.add(new ArrayList<>());
      }
      adjList.get(5).add(2);
      adjList.get(5).add(0);
      adjList.get(4).add(0);
      adjList.get(4).add(1);
      adjList.get(2).add(3);
      adjList.get(3).add(1);
    TopologicalIml topologicalSort = new TopologicalIml();
    System.out.println("Topological Sort (DFS):");
    topologicalSort.topologicalSortDFS(V, adjList); 
  }
}
