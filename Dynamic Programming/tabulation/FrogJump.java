package tabulation;

public class FrogJump {
  public static void main(String[] args) {
    int[] heights = {10, 20, 30, 10};
    int n = heights.length;
    System.out.println(frogJump(n, heights)); // calling
  }
  public static int frogJump(int n, int heights[]) {
    int[] dp = new int[n];
    dp[0] = 0;
    for(int i = 1; i < n; i++){
      int left = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
      int right = Integer.MAX_VALUE;
      if( i > 1){
        right = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
      }
      dp[i] = Math.min(left, right);
    }
    return dp[n-1];
  }
}
