public class Pow_x_n {
  public static void main(String[] args) {

  }

  public double myPow(double x, int n) {
    long N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }
    return helper(x, N);
  }

  public double helper(double x, long n) {
    if (n == 0) return 1;
    double half = helper(x, n / 2);
    if (n % 2 == 0) {
      return half * half;
    }
    return x * half * half;
  }
}
