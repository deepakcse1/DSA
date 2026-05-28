public class ratInAMazeFindPath {
   public static void main(String[] args) {
      int[][] maze = {
        {1,0,0},
        {0,1,0},
        {1,1,1}
      };
      int n = maze.length;
      int[][] solution = new int[n][n];
      boolean isPath = findPath(maze,0,0, solution);  
      // ratInMaze(maze); 
      System.out.println(isPath);
    }

    public static boolean findPath(int[][] maze, int i, int j, int[][] solution){
      int n = maze.length;
      //check if i,j is valid
      if(i < 0 || j < 0 || i >= n || j >= n || maze[i][j] == 0 || solution[i][j] == 1) return false;

      //include in path
      solution[i][j] = 1;

      //check destination cell
      if(i == n-1 && j == n-1) return true;

      //explore all directions
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
//----------------------- best solution if need to return list----------------------------------------------
//     public ArrayList<String> ratInMaze(int[][] maze) {
//         // code here
//         ArrayList<String> list = new ArrayList<>();
//         helper(maze, 0, 0, "", list);
//         Collections.sort(list);
//         return list;
//     }
    
//     public void helper(int[][] maze, int row, int col, String path, ArrayList<String> list){
//         int n = maze.length;
        
//         if(row < 0 || col < 0 || row == n || col == n || maze[row][col] == 0 || maze[row][col] == -1) return;
//         if(row == n-1 && col == n-1){
//             list.add(path);
//             return;
//         }
        
//         maze[row][col] = -1;
//         helper(maze, row-1, col, path+"U", list);
//         helper(maze, row+1, col, path+"D", list);
//         helper(maze, row, col-1, path+"L", list);
//         helper(maze, row, col+1, path+"R", list);
//         maze[row][col] = 1;
//     }
