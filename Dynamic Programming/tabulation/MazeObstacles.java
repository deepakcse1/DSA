package tabulation;

import java.util.ArrayList;

public class MazeObstacles {
  static ArrayList<ArrayList<Integer>> dp;
  public static void main(String[] args) {
    int[][] grid = {
      // {0,0,0},
      // {0,-1,0},
      // {0,0,0}
      // {0,-1},
      // {-1,0}
      {0,0,0,-1},
      {0,-1,0,0},
      {0,0,0,0},
      {0,0,0,0},
    };
    dp = new ArrayList<>();
    int m = grid.length;
    int n = grid[0].length;
    for(int i = 0; i < m; i++){
      ArrayList<Integer> row = new ArrayList<>();
      for(int j = 0; j < n; j++){
        row.add(0);
      }
      dp.add(row);
    }
    System.out.println(countPaths(grid, n, m));
  }
  private static int countPaths(int[][] grid, int n, int m) {
    for(int i = 0; i < n; i++){
      if(grid[i][0] == -1) break;
      dp.get(i).set(0,1);
    }
    for(int j = 0; j < m; j++){
      if(grid[0][j] == -1) break;
      dp.get(0).set(j, 1);
    }
    for(int i = 1; i < n; i++){
      for(int j = 1; j < m; j++){
        if(grid[i][j] == -1) dp.get(i).set(j, 0);
        else{
          dp.get(i).set(j, dp.get(i-1).get(j) + dp.get(i).get(j-1));
        }
      }
    }
    return dp.get(n-1).get(m-1);
  }
}

// import java.util.ArrayList;

// public class Solution {
//     static ArrayList<ArrayList<Integer>> dp;
//     static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> grid) {
//         // Write your code here.
//         dp = new ArrayList<>();
//         for(int i = 0; i < n; i++){
//           ArrayList<Integer> row = new ArrayList<>();
//           for(int j = 0; j < m; j++){
//             row.add(0);
//           }
//           dp.add(row);
//         }

//         for(int i = 0; i < n; i++){
//           if(grid.get(i).get(0) == -1) break;
//           dp.get(i).set(0,1);
//         }
//         for(int j = 0; j < m; j++){
//           if(grid.get(0).get(j) == -1) break;
//           dp.get(0).set(j, 1);
//         }
//         for(int i = 1; i < n; i++){
//           for(int j = 1; j < m; j++){
//             if(grid.get(i).get(j) == -1) dp.get(i).set(j, 0);
//             else{
//               dp.get(i).set(j, (dp.get(i-1).get(j) + dp.get(i).get(j-1))%1000000007);
//             }
//           }
//         }
//         return dp.get(n-1).get(m-1);
//     }

// }

