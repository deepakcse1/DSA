public class UglyNumberThree {
  public int nthUglyNumber(int n, int a, int b, int c) {
    long lo = 1;
    long hi = 2_000_000_000L;
    long ans = 0;
    while (lo <= hi) {
      long mid = lo + (hi - lo) / 2;
      if (isValid(mid, a, b, c, n)) {
        ans = mid;
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return (int) ans;
  }

  private boolean isValid(long mid, int a, int b, int c, int n) {
    return countUgly(mid, a, b, c) >= n;
  }

  private int countUgly(long mid, int a, int b, int c) {
    long a_b = lcm(a, b);
    long a_c = lcm(a, c);
    long b_c = lcm(b, c);
    long a_b_c = lcm(a_b, c);
    long total = (mid / a) + (mid / b) + (mid / c) - (mid / a_b) - (mid / a_c) - (mid / b_c) + (mid / a_b_c);
    return (int) total;
  }

  private long lcm(long a, long b) {
    return ((long) a * b) / gcd(a, b);
  }

  private long gcd(long a, long b) {
    if (a == 0) return b;
    return gcd(b % a, a);
  }
}
