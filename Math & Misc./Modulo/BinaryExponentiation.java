package Modulo;

import java.util.Scanner;

public class BinaryExponentiation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long res = bin_pow(1378, n, 1000000007);
    System.out.println(res % 10);
  }
  // public static void main(String[] args) {
  //   // System.out.println(bin_pow(1378, 2, 1000000007));
  //   // System.out.println(bin_pow_itr(1378, 1, 1000000007 ));
  //   // System.out.println(divide_mod(2, 7, 1000000007)); // Output: 333333336 (modular multiplicative inverse of 7 under modulo 1000000007)
  //   long res = bin_pow(1378, 2, 1000000007);
  //   System.out.println(res % 10);
  // }

  private static long bin_pow(long base, long exponent, long mod) { //a^n
    if(exponent == 0) return 1;
    long res = bin_pow(base, exponent / 2, mod);
    res = (res * res) % mod;
    if((exponent % 2) == 0) return res;
    return (base % mod * res) % mod;
  }

  private static long bin_pow_itr(long base, long exponent, long mod){
    long res = 1;
    base %= mod;
    while(exponent > 0){
      //if(exponent % 2 == 1) res = (res * base) % mod;
      if((exponent & 1) == 1) res = (base * res) % mod; //check whether current bit is 1
      base = (base * base) % mod;
      exponent >>= 1;//exponent /= 2; exponent >>= 1 → move to the next bit
    }
    return res;
  }

  private static long mmi(long a, long m) { //modular multiplicative inverse
    return bin_pow(a, m - 2, m);
  }

  // a/b mod m = a * b^(-1) mod m
  private static long divide_mod(long a, long b, long m){
    long b_inv = mmi(b,m);
    return (a * b_inv) % m;
  }
}
