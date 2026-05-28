public class NumberOfIsland {
  public static void main(String[] args) {

  }

  public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          helper(grid, m, n, i, j);
          count++;
        }
      }
    }
    return count;
  }

  public void helper(char[][] grid, int m, int n, int i, int j) {
    if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
    grid[i][j] = '0';
    helper(grid, m, n, i, j - 1);
    helper(grid, m, n, i - 1, j);
    helper(grid, m, n, i, j + 1);
    helper(grid, m, n, i + 1, j);
  }
}
