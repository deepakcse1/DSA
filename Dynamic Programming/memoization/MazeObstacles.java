package memoization;

public class MazeObstacles {
  static int[][] dp;
  public static void main(String[] args) {
    int[][] maze = {
      {0,0,0},
      {0,-1,0},
      {0,0,0}
      // {0,-1},
      // {-1,0}
      // {0,0,0,-1},
      // {0,-1,0,0},
      // {0,0,0,0},
      // {0,0,0,0},
    };

    dp = new int[maze.length][maze[0].length];
    for(int i = 0; i < dp.length; i++){
      for(int j = 0; j < dp[0].length; j++){
        dp[i][j] = -1;
      }
    }
    System.out.println(countPaths(maze, maze.length-1, maze[0].length-1));
  }

  private static int countPaths(int[][] maze, int i, int j) {

    //base case
    if(i < 0 || j < 0  || maze[i][j] == -1) return 0;
    if(i == 0 && j == 0) return 1;
    if(dp[i][j] != -1) return dp[i][j];

    //choices
    // int sum = countPaths(maze, i, j+1,dp) + countPaths(maze, i+1, j,dp);
    // return dp[i][j] = sum;

    //choices
    int way1,way2;
    way1 = countPaths(maze, i - 1, j);
    way2 = countPaths(maze, i, j - 1);

    //optimal substructure
    int ans = way1 + way2;
    dp[i][j] = ans;
    return ans;
    // return dp[i][j] = countPaths(maze, i, j-1) + countPaths(maze, i-1, j);
  }
}
