import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountValidGridPath {
  static class FastScanner {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String[] tokens;
    private int index = 0;

    String next() throws IOException {
      while (tokens == null || index >= tokens.length) {
        tokens = br.readLine().trim().split("\\s+");
        index = 0;
      }
      return tokens[index++];
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    String nextLine() throws IOException {
      return br.readLine();
    }
  }

  private static boolean isValid(int nR, int nC, boolean[][] maze) {
    return nR >= 0 && nC >= 0 && nR < 7 && nC < 7 && !maze[nR][nC];
  }

  private static int solve(int idx, String str, int row, int col, boolean[][] maze, int[][] DIRS) {
    maze[row][col] = true;
    if (row == 6 && col == 0) {
      int res = 0;
      if (idx == 48) res = 1;
      maze[row][col] = false;
      return res;
    }

    // I have to visit every cell atleast once to make the path isValid
    // A valid path must visit every cell exactly once (because there are 49 cells and 48 moves). So leaving even one disconnected region means the path cannot succeed.
    boolean up = row == 0 || maze[row - 1][col];
    boolean down = row == 6 || maze[row + 1][col];
    boolean left = col == 0 || maze[row][col - 1];
    boolean right = col == 6 || maze[row][col + 1];
    if ((up && down && !left && !right) || (left && right && !up && !down)) {
      maze[row][col] = false;
      return 0;
    }

    int count = 0;
    char ch = str.charAt(idx);
    if (ch == '?') {
      for (int[] dir : DIRS) {
        int nR = row + dir[0];
        int nC = col + dir[1];
        if (isValid(nR, nC, maze)) count += solve(idx + 1, str, nR, nC, maze, DIRS);
      }
    } else {
      int dir = (ch == 'U') ? 3 : (ch == 'D') ? 1 : (ch == 'L') ? 2 : 0;
      int nR = row + DIRS[dir][0];
      int nC = col + DIRS[dir][1];
      if (isValid(nR, nC, maze))  count += solve(idx + 1, str, nR, nC, maze, DIRS);
    }
    maze[row][col] = false;
    return count;
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    String input = fs.next();
    boolean[][] maze = new boolean[7][7];
    int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int ans = solve(0, input, 0, 0, maze, DIRS);
    System.out.println(ans);
  }
}
