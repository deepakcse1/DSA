import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
  public static void main(String[] args) {

  }

  public int orangesRotting(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int fresh = 0;
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) q.offer(new int[] { i, j });
        else if (grid[i][j] == 1) fresh++;
      }
    }
    int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    int level = 0;
    while (!q.isEmpty() && fresh > 0) {
      int size = q.size();
      for (int j = 0; j < size; j++) {
        int[] curr = q.poll();
        int currRow = curr[0];
        int currCol = curr[1];
        for (int i = 0; i < 4; i++) {
          int row = currRow + dir[i][0];
          int col = currCol + dir[i][1];
          if (row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == 1) {
            q.offer(new int[] { row, col });
            grid[row][col] = 2;
            fresh--;
          }
        }
      }
      level++;
    }
    return (fresh == 0) ? level : -1;
  }

}
