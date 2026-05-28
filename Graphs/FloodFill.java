public class FloodFill {
  public static void main(String[] args) {

  }

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int currColor = image[sr][sc];
    helper(sr, sc, color, currColor, image);
    return image;
  }

  public void helper(int sr, int sc, int color, int currColor, int[][] image) {
    int m = image.length;
    int n = image[0].length;
    if (sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] == color || image[sr][sc] != currColor) return;

    image[sr][sc] = color;
    int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    for (int i = 0; i < 4; i++) {
      int nextSr = sr + dir[i][0];
      int nextSc = sc + dir[i][1];
      helper(nextSr, nextSc, color, currColor, image);
    }
  }
}
