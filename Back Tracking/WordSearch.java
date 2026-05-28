public class WordSearch {
  public static void main(String[] args) {
    char[][] board = {
      {'q','v','m','h'},
      {'d','e','s','i'},
      {'d','g','f','g'},
      {'e','c','p','n'}
    };
    String word = "npfgis";
    System.out.println(exist(board, word));
  }

  public static boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (helper(i, j, 1, board, word)) return true;
        }
      }
    }
    return false;
  }
  
  public static boolean helper(int i, int j, int index, char[][] board, String word) {
    if (index == word.length()) return true;
    int m = board.length;
    int n = board[0].length;
    char temp = board[i][j];
    board[i][j] = '#';
    int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    for (int k = 0; k < 4; k++) {
      int row = i + dir[k][0];
      int col = j + dir[k][1];
      if (row >= 0 && row < m && col >= 0 && col < n &&
        board[row][col] == word.charAt(index) && board[row][col] != '#') {
        if (helper(row, col, index + 1, board, word)) return true;
      }
    }
    board[i][j] = temp;
    return false;
  }
}
