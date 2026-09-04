package Number_System.SeiveOfErostosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Seive {
  private static List<Integer> seive_advance(int n) {
    List<Integer> list = new ArrayList<>();
    boolean[] is_prime = new boolean[n + 1];
    Arrays.fill(is_prime, true);
    is_prime[0] = false;
    is_prime[1] = false;
    for (int i = 2; i <= n; i++) {
      if (is_prime[i]) {
        list.add(i);
        for (int j = i * i; j <= n; j += i) {
          is_prime[j] = false;
        }
      }
    }
    return list;
  }

  public static void main(String[] args) {
    for(int i : seive_advance(30)){
      System.out.print(i + " ");
    }
    System.out.println();
    // Basic Seive Of Erostehnes
    // n = 20;
    // is_prime = new boolean[n + 1];
    // seive();
    // System.out.println(is_prime[10]);
  }
  // Basic Seive Of Erostehnes
  // private static int n;
  // private static boolean[] is_prime;
  // private static void seive() {
  //   Arrays.fill(is_prime, true);
  //   is_prime[0] = false;
  //   is_prime[1] = false;
  //   for (int i = 2; i <= n; i++) {
  //     if (is_prime[i]) {
  //       for (int j = 2 * i; j <= n; j += i) {
  //         is_prime[j] = false;
  //       }
  //     }
  //   }
  // }
}
