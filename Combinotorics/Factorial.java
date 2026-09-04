package Combinotorics;

public class Factorial {
  static final long MOD = 1_000_000_007L;
  private static long fact(int n){
    long ans = 1;
    for(int i = 2; i <= n; i++){
      ans = (ans * i) % MOD;
    }
    return ans;
  }
  public static void main(String[] args) {
    System.out.println(fact(4));
  }
}
