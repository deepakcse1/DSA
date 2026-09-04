package Number_System.SeiveOfErostosthenes;

import java.util.ArrayList;
import java.util.List;

public class SegmentedSeive {
  // Normal sieve to find primes up to sqrt(R)
  private static List<Integer> getPrime(int n) {
    boolean[] composite = new boolean[n + 1];
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      if (!composite[i]) {
        primes.add(i);
        if ((long) i * i <= n) {
          for (int j = i * i; j <= n; j += i) {
            composite[j] = true;
          }
        }
      }
    }
    return primes;
  }

  private static void segmented_seive(long L, long R) {
    int n = (int) Math.sqrt(R);
    List<Integer> primes = getPrime(n);
    boolean[] composite = new boolean[(int) (R - L + 1)];
    for (int p : primes) {
      long start = Math.max((long) p * p, ((L + p - 1) / p) * p);
      for (long j = start; j <= R; j += p) {
        composite[(int) (j - L)] = true;
      }
    }
    for (long i = L; i <= R; i++) {
      if (i >= 2 && !composite[(int) (i - L)]) {
        System.out.print(i + " ");
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    long L = 100000000000L;
    long R = 100000000019L;
    segmented_seive(L, R);
  }
}
