
public class Cycle_3 {
  public static void main(String[] args) {
    int[][] graph = {
      {0,1,1,1,0},
      {1,0,0,1,1},
      {1,0,0,1,0},
      {1,1,1,0,1},
      {0,1,0,1,0}
    };
    int n = graph.length;
    System.out.println(solve(graph, n));
  }
  public static int solve(int[][] graph, int n){
    int count = 0;
    for(int i = 0; i < n; i++){
      for(int j = i+1; j < n; j++){
        if(graph[i][j] == 1){
          for(int k = j+1; k < n; k++){
            if(graph[j][k] == 1 && graph[k][i] == 1){
              count++;
            }
          }
        }
      }
    }
    return count;
  }

  
  
}
