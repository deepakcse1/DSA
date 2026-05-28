package CoursesSchedule1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CoursesScheduleBFS {
  public static void main(String[] args) {

  }

  public boolean canFinish(int n, int[][] grid) {
    List<List<Integer>> list = new ArrayList<>();
    int[] inDeg = new int[n];
    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }
    for (int[] pre : grid) {
      list.get(pre[1]).add(pre[0]);
      inDeg[pre[0]]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (inDeg[i] == 0) q.offer(i);
    }

    int count = 0;
    while (!q.isEmpty()) {
      int curr = q.poll();
      count++;
      for (int v : list.get(curr)) {
        inDeg[v]--;
        if (inDeg[v] == 0) q.offer(v);
      }
    }
    return count == n;
  }
}
