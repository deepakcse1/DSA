public class MaxAreaOfIsland {

  public static void main(String[] args) {

  }

  public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          int no = helper(grid, m, n, i, j);
          max = Math.max(max, no);
        }
      }
    }
    return max;
  }

  public int helper(int[][] grid, int m, int n, int i, int j) {
    if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 0) return 0;
    grid[i][j] = 0;
    int a = helper(grid, m, n, i, j - 1); // left
    int b = helper(grid, m, n, i - 1, j); // up
    int c = helper(grid, m, n, i, j + 1); // right
    int d = helper(grid, m, n, i + 1, j); // down
    return 1 + a + b + c + d;
  }
}
