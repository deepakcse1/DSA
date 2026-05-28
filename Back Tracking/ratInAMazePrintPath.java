public class ratInAMazePrintPath {
  public static void main(String[] args) {
    int[][] maze = {
      {1,0,0},
      {1,0,0},
      {1,1,1}
    };
    int n = maze.length;
    int[][] solution = new int[n][n];
    boolean isPath = findPath(maze,0,0,solution);
    System.out.println(isPath);
    if(isPath){
      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          // System.out.print(solution[i][j]+" ");
          if(solution[i][j] == 1){
            System.out.print("-->(" + i + ","+j+")");
          }
        }
      }
    }
  }
  public static boolean findPath(int[][] maze, int i, int j, int[][] solution){

    int n = maze.length;
    //check if i, j are valid
    if(i < 0 || j < 0 || i >= maze.length || j >= maze.length || maze[i][j] == 0 || solution[i][j] == 1) return false;

    //include in path
    solution[i][j] = 1;

    //check if destination cell
    if(i == n-1 && j == n-1) return true;

    //explore all direction
    //right
    if(findPath(maze, i, j+1, solution)) return true;
    //down
    if(findPath(maze, i+1, j, solution)) return true;
    //left
    if(findPath(maze, i, j-1, solution)) return true;
    //up
    if(findPath(maze, i-1, j, solution)) return true;
    return false;
  }
}
