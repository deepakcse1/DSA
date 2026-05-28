package tabulation;

public class SubsetSumToK {
  static boolean dp[][];
  public static void main(String[] args) {
    int[] arr = {1,1,1,1};
    int k = 4;
    int n = arr.length;
    System.out.println(subsetSumToK1D(n, k, arr));
  }
  public static boolean subsetSumToK(int n, int k, int arr[]){
     dp = new boolean[n+1][k+1];
     for(int i = 0; i <= n; i++) dp[i][0] = true;

     for(int i = 1; i <= k ; i++) dp[0][i] = false;

     for(int i = 1; i <= n; i++){
      for(int j = 1; j<= k; j++){
        boolean take = false;
        boolean notTake = dp[i-1][j];
        if(arr[i-1] <= j) take = dp[i-1][j - arr[i-1]];
        dp[i][j] = take || notTake;
      }
     }
     return dp[n][k];
  }

  public static boolean subsetSumToK1D(int n, int k, int arr[]){
    boolean[] dp = new boolean[k+1];
    dp[0] = true;
    for(int i : arr){
      // Go backward to avoid reusing the same element
      for(int j = k; j >= i; j--){
        dp[j] = dp[j] || dp[j - i];
      }
     }
     return dp[k];
  }
}
