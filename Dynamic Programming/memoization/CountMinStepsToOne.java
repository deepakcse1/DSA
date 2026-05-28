package memoization;

public class CountMinStepsToOne {
  static int[] dp;
  public static void main(String[] args) {
    System.out.println(countMinStepsToOne(10));
  }
  public static int countMinStepsToOne(int n){
    dp = new int[n+1];
    for(int i = 0; i <= n; i++){
       dp[i] = -1;
    }
    return helper(n);
  }
  private static int helper(int n){
    if(n == 1) return 0;
    if(dp[n] != -1) return dp[n];
    int op1 = helper(n-1);
    int op2 = Integer.MAX_VALUE, op3 = Integer.MAX_VALUE;
    if(n % 2 == 0){
      op2 = helper(n/2);
    }
    if(n % 3 == 0){
      op3 = helper(n/3);
    }
    return dp[n] = 1  + Math.min(op1, Math.min(op2, op3));
  }
}
