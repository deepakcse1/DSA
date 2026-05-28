import java.util.LinkedList;
import java.util.Queue;

class WallsandGatesORIslandAndTreasure {
  public static void main(String[] args) {

  }

  class Solution {
    public void islandsAndTreasure(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      Queue<int[]> q = new LinkedList<>();
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 0) {
            q.offer(new int[] { i, j });
          }
        }
      }
      int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
      while (!q.isEmpty()) {
        int[] curr = q.poll();
        int row = curr[0];
        int col = curr[1];
        for (int[] d : dir) {
          int nextRow = row + d[0];
          int nextCol = col + d[1];
          if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n && grid[nextRow][nextCol] == 2147483647) {
            grid[nextRow][nextCol] = grid[row][col] + 1;
            q.offer(new int[] { nextRow, nextCol });
          }
        }
      }
    }
  }
}
