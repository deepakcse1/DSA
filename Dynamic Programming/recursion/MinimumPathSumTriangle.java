package recursion;

public class MinimumPathSumTriangle {
  public static void main(String[] args) {
    int[][] triangle = {
      // {1},
      // {2,3},
      // {4,5,6},
      // {7,8,9,10}
      // {2},
      // {3,4},
      // {6,5,7},
      // {4,1,8,3}
      {-10}
    };
    int n = triangle.length;
    System.out.println(minimumPathSum(triangle, n));
  }
  public static int minimumPathSum(int[][] triangle, int n) {
    return helper(triangle, n, 0,0);
  }

  public static int helper(int[][] triangle, int n, int row, int col){
    //base case
    if(row == n-1) return triangle[row][col];
    //choices
    int option1, option2;
    option1 = triangle[row][col] + helper(triangle, n, row+1, col);
    option2 = triangle[row][col] + helper(triangle, n, row+1, col+1);
    //optimal substructure
    int ans =  Math.min(option1, option2);
    return ans;
  }
}
