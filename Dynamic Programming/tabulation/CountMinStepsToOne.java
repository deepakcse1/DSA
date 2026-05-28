package tabulation;

public class CountMinStepsToOne {
  static int[] dp;
  public static void main(String[] args) {
    System.out.println(countMinStepsToOne(8));
  }
  public static int countMinStepsToOne(int n){
    if(n <= 1) return 0;
    dp = new int[n+1];
    dp[1] = 0;
    for(int i = 2; i <= n; i++){
      int op1 = dp[i-1];
      int op2 = Integer.MAX_VALUE, op3 = Integer.MAX_VALUE;
      if(i % 2 == 0) op2 = dp[i/2];
      if(i % 3 == 0) op3 = dp[i/3];
      dp[i] = 1 + Math.min(op1, Math.min(op2, op3)); 
    }
    return dp[n];
  }
}
