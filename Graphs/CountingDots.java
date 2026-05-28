
public class CountingDots {
  static boolean[][] visited;
  public static void main(String[] args) {
    String[] board = {
      "YYYR",
      "BYBY",
      "BBBY",
      "BBBY"
    };
    System.out.println("Is connecting dots "+solve(board,board.length,board[0].length()));
  }
  public static int solve(String[] board , int n, int m){
    visited = new boolean[n][m];
    for(int i = 0; i < n; i++){
      for(int j = 0 ; j < m; j++){
        if(!visited[i][j]){
          if(helper(board, i, j, -1, -1, board[i].charAt(j))) return 1;
        }
      }
      System.out.println();
    }
    return 0;
  }
  
  private static boolean helper(String[] board, int ci, int cj, int pi, int pj, char color) {
    visited[ci][cj] = true;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    for(int d = 0 ; d < 4; d++){
      int x = ci + dx[d];
      int y = cj + dy[d];
      if((x >= 0 && x < board.length && y >= 0 && y < board[0].length()) && board[x].charAt(y) == color){
        if(visited[x][y]){
          if(!(x == pi && y == pj)) return true;
        }else{
          if(helper(board, x, y, ci, cj, color)) return true;
        }
      }
    }
    return false;
  }
}
