package Combinotorics.nCR;
// TC = O(n+r)
// What if n ≤ 10^9 and r ≤ 20 
// This code won't work as fact(n) would get very large (will loop till 10^9)
public class NcR_mathodOne {
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

  private static long factorial(int x){
    long res = 1;
    for(int i = 2; i <= x; i++){
      res = (res * i) % MOD;
    }
    return res;
  }

  private static long nCr(int n, int r){
    long num = factorial(n);
    long den = (factorial(r) * factorial(n-r)) % MOD;
    return (num * inverse(den)) % MOD;
  }
  
  public static void main(String[] args) {
    long res = nCr(6, 3);
    System.out.println(res);
  }
}
