public class SudokuSolver {
  public static void main(String[] args) {
    
  }

  //---------------------------- best solution-----------------------------------------------------------------------
  /* class Solution {

    boolean[][] rowUsed = new boolean[9][9];
    boolean[][] colUsed = new boolean[9][9];
    boolean[][] boxUsed = new boolean[9][9];

    public void solveSudoku(char[][] board) {

      // Step 1: Initialize lookup tables
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (board[i][j] != '.') {
            int digit = board[i][j] - '1';
            int boxIndex = (i / 3) * 3 + (j / 3);

            rowUsed[i][digit] = true;
            colUsed[j][digit] = true;
            boxUsed[boxIndex][digit] = true;
          }
        }
      }

      helper(board, 0, 0);
    }

    public boolean helper(char[][] board, int row, int col) {

      if (row == 9) {
        return true;
      }

      int nextRow = row;
      int nextCol = col + 1;

      if (nextCol == 9) {
        nextRow = row + 1;
        nextCol = 0;
      }

      if (board[row][col] != '.') {
        return helper(board, nextRow, nextCol);
      }

      int boxIndex = (row / 3) * 3 + (col / 3);

      for (int digit = 0; digit < 9; digit++) {

        if (!rowUsed[row][digit] &&
            !colUsed[col][digit] &&
            !boxUsed[boxIndex][digit]) {

          // place digit
          board[row][col] = (char) (digit + '1');

          rowUsed[row][digit] = true;
          colUsed[col][digit] = true;
          boxUsed[boxIndex][digit] = true;

          if (helper(board, nextRow, nextCol)) {
            return true;
          }

          // backtrack
          board[row][col] = '.';
          rowUsed[row][digit] = false;
          colUsed[col][digit] = false;
          boxUsed[boxIndex][digit] = false;
        }
      }

      return false;
    }
  }
*/

  public void solveSudoku(char[][] board) {
    helper(board, 0, 0);
  }

  public boolean helper(char[][] board, int row, int col) {
    if (row == 9) return true;
    int nextRow = row, nextCol = col + 1;
    if (nextCol == 9) {
      nextRow = row + 1;
      nextCol = 0;
    }
    if (board[row][col] != '.') {
      return helper(board, nextRow, nextCol);
    }

    for (char digit = '1'; digit <= '9'; digit++) {
      if (isSafe(board, row, col, digit)) {
        board[row][col] = digit;
        if (helper(board, nextRow, nextCol)) return true;
        board[row][col] = '.';
      }
    }
    return false;
  }

  public boolean isSafe(char[][] board, int row, int col, char digit) {
    for (int i = 0; i < 9; i++) {
      if (board[row][i] == digit) return false;
    }

    for (int i = 0; i < 9; i++) {
      if (board[i][col] == digit) return false;
    }

    int r = (row / 3) * 3;
    int c = (col / 3) * 3;
    for (int i = r; i < r + 3; i++) {
      for (int j = c; j < c + 3; j++) {
        if (board[i][j] == digit) return false;
      }
    }
    return true;
  }
}
