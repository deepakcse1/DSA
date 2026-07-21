package PrefixSum;

public class RangeSumQuery2D {

}

class NumMatrix {
  int[][] prefix;

  public NumMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    prefix = new int[m][n];
    // fill top row
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += matrix[0][i];
      prefix[0][i] = sum;
    }
    // fill left col
    sum = 0;
    for (int i = 0; i < m; i++) {
      sum += matrix[i][0];
      prefix[i][0] = sum;
    }
    // fill diagonal
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        prefix[i][j] = matrix[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (row1 == 0 && col1 == 0)
      return prefix[row2][col2];
    int total = prefix[row2][col2];
    int top = (row1 > 0) ? prefix[row1 - 1][col2] : 0;
    int left = (col1 > 0) ? prefix[row2][col1 - 1] : 0;
    int topLeft = (row1 > 0 && col1 > 0) ? prefix[row1 - 1][col1 - 1] : 0;
    return total - top - left + topLeft;
  }
}
