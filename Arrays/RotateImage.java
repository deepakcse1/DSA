public class RotateImage {
  public static void main(String[] args) {
    //Input: matrix = [[1,2,3],
    //                 [4,5,6],
    //                 [7,8,9]]
    
    //Output:         [[7,4,1],
    //                 [8,5,2],
    //                 [9,6,3]]
  }

  //brute force
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    int[][] ans = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ans[j][n - i - 1] = matrix[i][j];
      }
    }
  }

  //Optimized 1)make transpose 2)reverse each row
  public void rotateOptimized(int[][] matrix) {
    int n = matrix.length;
    //Make transpose of matrix
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    //Reverse each row
    for (int i = 0; i < n; i++) {
      int left = 0;
      int right = n - 1;
      while (left < right) {
        int temp = matrix[i][left];
        matrix[i][left] = matrix[i][right];
        matrix[i][right] = temp;
        left++;
        right--;
      }
    }
  }
}
