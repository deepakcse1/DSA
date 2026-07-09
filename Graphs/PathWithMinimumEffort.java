import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
  public int minimumEffortPath(int[][] heights) {
    int m = heights.length;
    int n = heights[0].length;
    int[][] dist = new int[m][n];
    for (int[] row : dist) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    dist[0][0] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.offer(new int[] { 0, 0, 0 });
    int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int effort = curr[0];
      int row = curr[1];
      int col = curr[2];
      if (effort > dist[row][col]) continue;
      if (row == m - 1 && col == n - 1) return effort;
      for (int[] d : dir) {
        int nR = row + d[0];
        int nC = col + d[1];
        if (nR >= 0 && nC >= 0 && nR < m && nC < n) {
          int currEffort = Math.abs(heights[row][col] - heights[nR][nC]);
          int newEffort = Math.max(effort, currEffort);
          if (dist[nR][nC] > newEffort) {
            dist[nR][nC] = newEffort;
            pq.offer(new int[] { newEffort, nR, nC });
          }
        }
      }
    }
    return 0;
  }
}
