package recursion;

public class MazeObstacles {
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
    System.out.println(countPaths(maze, maze.length-1, maze[0].length-1));
  }

  private static int countPaths(int[][] maze, int i, int j) {
    //base case
    if(i == 0 && j == 0) return 1;
    if(i < 0 || j < 0 || maze[i][j] == -1) return 0;

    //choices
    int way1,way2;
    way1 = countPaths(maze, i - 1, j);
    way2 = countPaths(maze, i, j - 1);

    //optimal substructure
    int ans = way1 + way2;
    return ans;
  }
}
