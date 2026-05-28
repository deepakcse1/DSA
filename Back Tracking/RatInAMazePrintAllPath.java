public class RatInAMazePrintAllPath {
  public static void main(String[] args) {
    int[][] maze = {
    {1,0,0},
    {1,1,0},
    {1,1,1}
  };
   int n = maze.length;
   int[][] solution = new int[n][n]; 
   printAllPath(maze,0,0,solution,n);
  }

  public static void printAllPath(int[][] maze, int i, int j, int[][] solution, int n){
     //check if i , j is valid
     if(i < 0 || j < 0 || i >= n || j >= n || maze[i][j] == 0 || solution[i][j] == 1) return;

     //include in path
     solution[i][j] = 1;

     //check if destination cell
     if(i == n-1 && j == n-1){
      printSolution(solution);
      System.out.println();
      solution[i][j] = 0;
      return;
     }

     //explore all directions
     //top
     printAllPath(maze, i-1, j, solution, n);
     //down
     printAllPath(maze, i+1, j, solution, n);
     //left
     printAllPath(maze, i, j+1, solution, n);
     //right
     printAllPath(maze, i, j-1, solution, n);

     //backtrack
      solution[i][j] = 0;
      // return;
  }

  public static void printSolution(int[][] solution){
    for(int c = 0; c < solution.length; c++){
      for(int r = 0; r < solution.length; r++){
        System.out.print(solution[c][r]+" ");
      }
    }
  }

}
