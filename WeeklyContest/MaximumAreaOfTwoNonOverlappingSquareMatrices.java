package WeeklyContest;

public class MaximumAreaOfTwoNonOverlappingSquareMatrices {
  public int maxArea(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] prefixMatrix = new int[m + 1][n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int right = prefixMatrix[i][j + 1];
        int bottom = prefixMatrix[i + 1][j];
        prefixMatrix[i + 1][j + 1] = right + bottom - prefixMatrix[i][j] + mat[i][j];
      }
    }

    int low = 1;
    int high = Math.min(m, n);
    int best = 0;

    while (low <= high) {
      int k = low + (high - low) / 2;
      if (check(k, mat, prefixMatrix)) {
        best = k;
        low = k + 1;
      } else {
        high = k - 1;
      }
    }
    return best * best;
  }

  private boolean check(int k, int[][] mat, int[][] prefix) {
    int m = mat.length;
    int n = mat[0].length;
    int minRow = m, maxRow = -1;
    int minCol = n, maxCol = -1;
    for (int i = 0; i <= m - k; i++) {
      for (int j = 0; j <= n - k; j++) {
        int sum = prefix[i + k][j + k] - prefix[i + k][j] - prefix[i][j + k] + prefix[i][j];
        if (sum != k * k) continue;
        minRow = Math.min(minRow, i);
        maxRow = Math.max(maxRow, i);
        minCol = Math.min(minCol, j);
        maxCol = Math.max(maxCol, j);
      }
    }
    if (maxRow == -1) return false;
    if (maxRow - minRow >= k || maxCol - minCol >= k) return true;
    return false;
  }
}
