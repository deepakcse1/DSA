public class SurroundedRegions {
  public static void main(String[] args) {

  }

  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      dfs(i, 0, board, m, n);
      dfs(i, n - 1, board, m, n);
    }
    for (int i = 0; i < n; i++) {
      dfs(0, i, board, m, n);
      dfs(m - 1, i, board, m, n);
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') board[i][j] = 'X';
        if (board[i][j] == 'T') board[i][j] = 'O';
      }
    }
  }

  public void dfs(int row, int col, char[][] board, int m, int n) {
    if (row < 0 || col < 0 || row == m || col == n || board[row][col] != 'O') return;
    board[row][col] = 'T';
    int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    for (int i = 0; i < 4; i++) {
      dfs(row + dir[i][0], col + dir[i][1], board, m, n);
    }
  }
}
