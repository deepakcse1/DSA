package Greedy;

public class SumOfMinimumNumberOfFibonacciNumber {
  public int findMinFibonacciNumbers(int k) {
    long[] fib = new long[50];
    fib[1] = 1;
    fib[2] = 1;
    for (int i = 3; i < 50; i++) fib[i] = fib[i - 1] + fib[i - 2];
    int ans = 0;
    int take = 49;
    while (k > 0) {
      if (k >= fib[take]) {
        k -= fib[take];
        ans++;
      }
      take--;
    }
    return ans;
  }
}
