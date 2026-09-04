package Combinotorics.nCR;
// Time Complexity = O(min(r, n-r))
public class NcR_mathodTwo {
  static final long MOD = 1_000_000_007L;
  private static long bin_pow(long base, long exp){
    long res = 1;
    while(exp > 0){
      if((exp & 1) == 1) res = (res * base) % MOD;
      base = (base * base) % MOD;
      exp >>= 1;
    }
    return res;
  }

  private static long inverse(long x){
    return bin_pow(x, MOD - 2);
  }

  private static long nCr(int n, int r){
    long num = 1;
    long den = 1;
    for(int i = 1; i <= Math.min(n-r, r); i++){
      num = (num * (n - i + 1)) % MOD;
      den = (den * i) % MOD;
    }
    return (num * inverse(den)) % MOD;
  }
  public static void main(String[] args) {
    long res = nCr(6, 3);
    System.out.println(res);
  }
  
}
