package Hashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    Set<String> set = new HashSet<>();
    for (char i = 0; i < 9; i++) {
      for (char j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          String row = "r" + i + board[i][j];
          String col = "c" + j + board[i][j];
          String box = "box" + i / 3 + j / 3 + board[i][j];
          if (set.contains(row) || set.contains(col) || set.contains(box))
            return false;
          set.add(row);
          set.add(col);
          set.add(box);
        }
      }
    }
    return true;
  }
}
