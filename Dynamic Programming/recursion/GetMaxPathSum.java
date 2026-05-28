package recursion;

public class GetMaxPathSum {
  public static void main(String[] args) {
    int[][] matrix = {
      // {2,3,10},
      // {3,7,2},
      // {1,1,5}
      {1, 2, 10, 4},
      {100, 3, 2, 1},
      {1, 1, 20, 2},
      {1, 2, 2, 1}
    };
    System.out.println(getMaxPathSum(matrix));
  }
  public static int getMaxPathSum(int[][] matrix) {
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < matrix.length; i++){
      int ans = helper(matrix, 0, i, matrix.length,matrix[0].length,max);
      if(ans > max) max = ans;
    }
    return max;
	}
  public static int helper(int[][] matrix, int row, int col, int m, int n,int max){
    //base case
    if(col < 0 || col > n-1 || row < 0 || row > m-1) return 0;
    if(row == m-1) return matrix[row][col];

    //choices
    int opt1, opt2, opt3;
    opt1 = matrix[row][col] + helper(matrix, row+1, col, m, n,max);
    opt2 = matrix[row][col] + helper(matrix, row+1, col+1, m, n,max);
    opt3 = matrix[row][col] + helper(matrix, row+1, col-1, m, n,max);

    //optimal
    return Math.max(opt1, Math.max(opt2,opt3));
  }
}
