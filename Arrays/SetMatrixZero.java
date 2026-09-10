public class SetMatrixZero {
  public void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    boolean isCol = false; // It will keep track if any of cell in 1st col is 0 because suppose, none of cell in 1st col is 0 but any of cell in 1st row is 0 than If we mark [0][0] = 0 than it will fill 1st column with 0 also and this is not true because none of cell in 1st col is 0. So isCol will be "true" only if any of cell in 1st column is 0
    for (int i = 0; i < rows; i++) {
      // isCol will be "true" only if any of cell in 1st column is 0
      if (matrix[i][0] == 0) isCol = true;
      for (int j = 1; j < cols; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    // start from 1 because 1st column is taken care by "isCol"
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
      }
    }
    if (matrix[0][0] == 0) {
      for (int i = 0; i < cols; i++) {
        matrix[0][i] = 0;
      }
    }
    // If "isCol" is true than only fill the 1st column with 0
    if (isCol) {
      for (int i = 0; i < rows; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
