package WeeklyContest;

public class SumOfDecodedString {
  private static final long MOD = 1_000_000_007L;

  private static long bin_pow(long base, long exp) {
    long res = 1;
    while (exp > 0) {
      if ((exp & 1) == 1) res = (res * base) % MOD;
      base = (base * base) % MOD;
      exp >>= 1;
    }
    return res;
  }

  public int sumDecoded(long[] nums) {
    long sum = 0;
    for (long i : nums) {
      int w = (int) (i % 10);
      long d = i / 10;
      String num = Long.toString(d);
      long x = 0;
      for (int k = 0; k < w; k++) {
        x = x * 10 + (num.charAt(k) - '0');
      }

      long y = 0;
      for (int k = w; k < num.length(); k++) {
        y = y * 10 + (num.charAt(k) - '0');
      }

      sum = (sum + bin_pow(x, y)) % MOD;
    }

    return (int) sum;
  }
}
