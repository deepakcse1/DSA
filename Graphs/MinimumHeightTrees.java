import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
      return Arrays.asList(0);
    }
    List<List<Integer>> adjList = new ArrayList<>();
    int[] degree = new int[n];
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      adjList.get(edge[0]).add(edge[1]);
      adjList.get(edge[1]).add(edge[0]);
      degree[edge[0]]++;
      degree[edge[1]]++;
    }
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (degree[i] == 1)
        q.offer(i);
    }
    int remainingNodes = n;
    while (!q.isEmpty() && remainingNodes > 2) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int node = q.poll();
        for (int neigh : adjList.get(node)) {
          degree[neigh]--;
          if (degree[neigh] == 1)
            q.offer(neigh);
        }
      }
      remainingNodes -= size;
    }
    List<Integer> ans = new ArrayList<>();

    while (!q.isEmpty()) {
      ans.add(q.poll());
    }

    return ans;
  }
}
