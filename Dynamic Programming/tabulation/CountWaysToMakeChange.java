package tabulation;

public class CountWaysToMakeChange {
  public static void main(String[] args) {
    int[] arr = {1,2,3};
    int target = 4;
    // System.out.println(countWaysToMakeChange2D(arr,target));
    System.out.println(countWaysToMakeChange1D(arr,target));
  }

  //this is faster
  public static long countWaysToMakeChange2D(int arr[], int target){
    int n = arr.length;
    long[][] dp = new long[n][target+1];

    for(int i = 0; i <= target; i++){
      if(i % arr[0] == 0 ) dp[0][i] = 1L;
    }

    for(int i = 1; i < n; i++){
      for(int j = 0; j<= target; j++){
        long notTake = dp[i-1][j];
        long take = 0;
        if(arr[i] <= j){
          take = dp[i][j - arr[i]];
        }
        dp[i][j] = take + notTake;
      }
    }
    return dp[n-1][target];
  }

  public static long countWaysToMakeChange1D(int arr[], int value) {
    long[] dp = new long[value + 1];
    dp[0] = 1;
    for (int i : arr) {
      for (int j = i; j <= value; j++) {
        dp[j] += dp[j - i];
      }
    }
    return dp[value];
  }
}
