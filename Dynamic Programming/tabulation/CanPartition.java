package tabulation;

public class CanPartition {
  public static void main(String[] args) {
    int[] arr = {2,3,3,3,4,5};
    System.out.println(canPartition2D(arr, arr.length));
  }
  // using 2D DP
  public static boolean canPartition2D(int[] arr, int n) {
    boolean[][] dp;
    int sum = 0;
    for(int num : arr) sum += num;
    if(sum % 2 != 0) return false;
    int k = sum / 2;
    dp = new boolean[n+1][k + 1];
    for(int i = 0; i <= n; i++) dp[i][0] = true;
    for(int i = 1; i <= n; i++){
      for(int j = 1; j <= k; j++){
        boolean take = false;
        boolean notTake = dp[i-1][j];
        if(arr[i-1] <= j) take = dp[i-1][j - arr[i-1]];
        dp[i][j] = take || notTake;
      }
    }
    return dp[n][k];
  }

  //using 1D DP
  public static boolean canPartition1D(int[] arr, int n){
    int sum = 0; 
    for(int num : arr) sum += num;
    if(sum % 2 != 0) return false;
    int target = sum/2;

    //initialize DP
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;

    //tabulation
    for(int num : arr){
      for(int j = target; j >= num; j--){
        dp[j] = dp[j] || dp[j - num];
      }
    }
    return dp[target];
  }
}
