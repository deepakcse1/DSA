package Modulo;

public class InefficientProgram {
  // https://maang.in/problems/Inefficient-Program-80?resourceUrl=pl4823-rs80&returnUrl=%5B%22%2Fcohorts%2FAZ-Premium-Cohort-16-84%3Ftab%3Dassignments%22%5D
  static long MOD = 1_000_000_007L;

  static long bin_pow(long base, long exp) {
    long res = 1;
    while (exp > 0) {
      if ((exp & 1) == 1) res = (res * base) % MOD;
      base = (base * base) % MOD;
      exp >>= 1;
    }
    return res;
  }

  static long inv(long x) {
    return bin_pow(x, MOD - 2);
  }

  static long sum(long n, long m) {
    if (n < 0) return 0;
    long count = n + 1; // 0 to n
    long q = count / m;
    long r = count % m;
    long blockSum = (m % MOD) * ((m - 1) % MOD) % MOD;
    blockSum = blockSum * inv((long) 2) % MOD;
    long rem = (r % MOD) * ((r - 1) % MOD) % MOD;
    rem = rem * inv((long) 2) % MOD;
    return ((q % MOD) * blockSum % MOD + rem) % MOD;
  }

  public static void main(String[] args) throws Exception {
    // FastScanner fs = new FastScanner();
    int t = 1; //fs.nextInt();
    while (t-- > 0) {
      long L = 4; //fs.nextLong();
      long R = 5; //fs.nextLong();
      long m = 6; //fs.nextLong();
      long ans = ((sum(R, m) - sum(L - 1, m)) + MOD) % MOD;
      System.out.println(ans);
    }
  }
}
