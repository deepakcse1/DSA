package Combinotorics.nCR;

import java.util.Scanner;
// Time Complexity(Per Query) = O(log(Mod)); 
public class NcR_mathodFive {
  static final long MOD = 1_000_000_007;
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
    return bin_pow(x, MOD-2);
  }

  static long[] fact;
  private static void factorial(){
    fact = new long[1000100];
    fact[0] = 1;
    for(int i = 1; i <= 1000000; i++){
      fact[i] = (fact[i-1] * i) % MOD;
    }
  }

  private static long nCr(int n, int r){
      long num = fact[n];
      long den = (fact[n-r] * fact[r]) % MOD;
      return (num * inverse(den)) % MOD;
  }

  public static void main(String[] args) {
    factorial();
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0){
        int n = sc.nextInt();
        int r = sc.nextInt();
        long res = nCr(n, r);
        System.out.println("Result : "+res);
    }
    sc.close();
  }
}
