
public class IsSentanceExist {
  public static void main(String[] args) {
    String[] Graph = {
      //  "CXDXNXNXNXA","XOXIXGXIXJX"
      "AJNINGNIDOC"
    };
    System.out.println(solve(Graph,Graph.length, Graph[0].length()));
  }
  private static int solve(String[] Graph , int N, int M){
    String word = "CODINGNINJA";
    boolean[][] visited = new boolean[N][M];
    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        // System.out.print(Graph[i].charAt(j)+" ");
        if(Graph[i].charAt(j) == 'C'){
          if(dfs(i,j,1,Graph,word,visited)) 
            return 1;
        }
      }
      // System.out.println();
    }
    return 0;
  }

  private static boolean dfs(int i, int j, int next, String[] Graph, String word, boolean[][] visited){
    if(next == word.length()) return true;
    visited[i][j] = true;
    int n = Graph.length;
    int m = Graph[0].length();
    int[] diffX = {-1,-1,-1,0,1,1,1,0};
    int[] diffY = {-1,0,1,1,1,0,-1,-1};
    for(int d = 0; d < 8; d++){
      int x = i + diffX[d];
      int y = j + diffY[d];
      if(
        (x >=0 && x < n && y >= 0 && y < m) && word.charAt(next) == Graph[x].charAt(y) &&
        !visited[x][y]
      ){
        if(dfs(x, y, next+1, Graph, word, visited))
          return true;        
      }
    }
    visited[i][j] = false;
    return false;
  }
}
