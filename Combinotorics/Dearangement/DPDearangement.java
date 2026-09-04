package Combinotorics.Dearangement;

public class DPDearangement {
  private static final int MAX = 1_000_000;
  private static long[] dp = new long[MAX+1];
  private static final long MOD = 1_000_000_007L;
  private static void dpDearangement(int n){
    dp[1] = 0;
    dp[2] = 1;
    for(int i = 3; i <= n; i++){
      dp[i] = ((i-1) * (dp[i-1] + dp[i-2])) % MOD;
    }
  }
  public static void main(String[] args) {
    int n = 2;
    dpDearangement(n);
    System.out.println(dp[n]);
  }
}
