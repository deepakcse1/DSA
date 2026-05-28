import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceNQueens {
  public static void main(String[] args) {
    int n = 4;
    placeNQueens(n);
  }

  //---------------------------- best solution-----------------------------------------------------------------------

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    char[][] board = new char[n][n];
    boolean[] columnArr = new boolean[n];
    boolean[] dig1 = new boolean[2 * n];
    boolean[] dig2 = new boolean[2 * n];
    for (char[] row : board) {
      Arrays.fill(row, '.');
    }
    helper(board, 0, n, columnArr, dig1, dig2, res);
    return res;
  }

  public void helper(char[][] board,int row,int n,boolean[] columnArr,boolean[] dig1,boolean[] dig2,List<List<String>> res){
    if (row == n) {
      List<String> list = new ArrayList<>();
      for (char[] r : board) {
        list.add(new String(r));
      }
      res.add(list);
      return;
    }

    for (int col = 0; col < n; col++) { // for each column
      if (columnArr[col] || dig1[row + col] || dig2[row - col + n]) continue;
      board[row][col] = 'Q';
      columnArr[col] = true;
      dig1[row + col] = true; // '/' -> bottom left to top right diagonal. row + col will give the same value for all the elements in the same diagonal. eg; (0,2) and (1,1) and (2,0) will give the same value of 2
      dig2[row - col + n] = true; // '\' -> top left to bottom right diagonal. subtract col from row to get the same value for all the elements in the diagonal. add n to make it positive as index cannot be negative

      helper(board, row + 1, n, columnArr, dig1, dig2, res);

      board[row][col] = '.';
      columnArr[col] = false;
      dig1[row + col] = false;
      dig2[row - col + n] = false;
    }
  }

  //---------------------------- better solution-----------------------------------------------------------------------
  public static void placeNQueens(int n) {
    int[][] board = new int[n][n];
    solveNQueens(board, 0, n);
  }

  public static void solveNQueens(int[][] board, int row, int n) {
    // base case
    if (row == n) {
      printBoard(board, n);
      System.out.println();
      return;
    }
    // place queen and check for all rows and columns
    for (int col = 0; col < n; col++) {
      if (isSafe(board, row, col, n)) {
        board[row][col] = 1; // place queen
        solveNQueens(board, row + 1, n);
        board[row][col] = 0;
      }
    }
  }

  public static boolean isSafe(int[][] board, int row, int col, int n) {
    // row is already taken care of
    // check for column
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 1)
        return false;
    }
    // check for left diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1)
        return false;
    }
    // check for right diagonal
    for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
      if (board[i][j] == 1)
        return false;
    }
    return true;
  }

  public static void printBoard(int[][] board, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(board[i][j] + " ");
      }
    }
  }

}
