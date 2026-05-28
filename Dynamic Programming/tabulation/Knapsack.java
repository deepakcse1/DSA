package tabulation;
public class Knapsack {
  static int[][] dp;
  public static void main(String[] args) {
    int[] weight = {1,2,3,4};
    int[] value = {5,4,8,6};
    int maxWeight = 5;
    int n = weight.length;
    System.out.println(knapsack(weight, value, n, maxWeight));
  }
  
  public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    dp = new int[n][maxWeight+1];
    for(int w = 0; w <= maxWeight; w++){
      if(weight[0] <= w) dp[0][w] = value[0];
      else dp[0][w] = 0;
    }
   
    for(int i = 1; i < n; i++){
      for(int w = 0; w <= maxWeight; w++){
        int take = Integer.MIN_VALUE, notTake = 0;
        notTake = dp[i-1][w];
        if(weight[i] <= w){
          take = value[i] + dp[i-1][w - weight[i]];
        }
        dp[i][w] = Math.max(take, notTake);
      }
    }
    return dp[n-1][maxWeight];
  }
}
