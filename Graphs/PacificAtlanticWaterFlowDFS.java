import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlowDFS {
  public static void main(String[] args) {

  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int m = heights.length;
    int n = heights[0].length;
    boolean[][] pacific = new boolean[m][n];
    boolean[][] atlantic = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      dfs(i, 0, pacific, m, n, heights);
      dfs(i, n - 1, atlantic, m, n, heights);
    }
    for (int i = 0; i < n; i++) {
      dfs(0, i, pacific, m, n, heights);
      dfs(m - 1, i, atlantic, m, n, heights);
    }
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          list.add(Arrays.asList(i, j));
        }
      }
    }
    return list;
  }

  public void dfs(int i, int j, boolean[][] visited, int m, int n, int[][] heights) {
    visited[i][j] = true;
    int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    for (int k = 0; k < 4; k++) {
      int currRow = i + dir[k][0];
      int currCol = j + dir[k][1];
      if (currRow >= 0 && currRow < m && currCol >= 0 && currCol < n
          && !visited[currRow][currCol]
          && heights[currRow][currCol] >= heights[i][j]) {
        dfs(currRow, currCol, visited, m, n, heights);
      }
    }
  }
}
