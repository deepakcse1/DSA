
public class LargestPiece {
  static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
  static boolean[][] visited;
  static int N;
  public static void main(String[] args) {
    String[] edge = {
      "111","111","111"
    };
    System.out.println("count is : "+dfs(edge, edge.length));
  }

  public static int dfs(String[] edge, int n) {
    visited = new boolean[n][n];
    N = n;
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (edge[i].charAt(j) == '1' && !visited[i][j]) {
          int count = helper(edge, i, j);
          max = Math.max(max, count);
        }
      }
    }
    return max;
  }
  private static int helper(String[] edge, int i, int j){
    visited[i][j] = true;
    int count = 1;
    for(int d = 0; d < 4; d++){
      int x = i + dir[d][0];
      int y = j + dir[d][1];
      if(x >= 0 && x < N && y >= 0 && y < N && edge[x].charAt(y) == '1' && !visited[x][y]){
        count +=  helper(edge, x, y);
      }
    }
    return count;
  }
}
