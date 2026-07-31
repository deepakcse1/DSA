package DFS_BFS;

import java.util.ArrayDeque;
import java.util.Deque;
// import java.util.Stack;

public class SurroundedRegions {
  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O') {
        dfs(i, 0, board);
      }
      if (board[i][n - 1] == 'O') {
        dfs(i, n - 1, board);
      }
    }
    for (int i = 0; i < n; i++) {
      if (board[0][i] == 'O') {
        dfs(0, i, board);
      }
      if (board[m - 1][i] == 'O') {
        dfs(m - 1, i, board);
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'T') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }

  private static final int[][] DIRS = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

  private void dfs(int row, int col, char[][] board) {
    // board[row][col] = 'T';
    // for(int[] dir : DIRS){
    // int nR = row + dir[0];
    // int nC = col + dir[1];
    // if(isValid(nR, nC, board)){
    // dfs(nR, nC, board);
    // }
    // }
    // instead of recussion, using stack so that stack will not overflow
    // Stack<int[]> stack = new Stack<>();
    Deque<int[]> stack = new ArrayDeque<>();
    stack.push(new int[] { row, col });
    board[row][col] = 'T';
    while (!stack.isEmpty()) {
      int[] curr = stack.pop();
      int r = curr[0];
      int c = curr[1];
      for (int[] dir : DIRS) {
        int nR = r + dir[0];
        int nC = c + dir[1];
        if (isValid(nR, nC, board)) {
          board[nR][nC] = 'T';
          stack.push(new int[] { nR, nC });
        }
      }
    }
  }

  private boolean isValid(int row, int col, char[][] board) {
    int m = board.length;
    int n = board[0].length;
    return row >= 0 &&
        col >= 0 &&
        row < m &&
        col < n &&
        board[row][col] == 'O';
  }
}
