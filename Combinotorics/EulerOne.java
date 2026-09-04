package Combinotorics;

import java.util.Scanner;

public class EulerOne {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      long n = sc.nextLong();
      // multiple of 3
      long i = (n - 1) / 3;
      long x = 3 * ((i * (i + 1)) / 2);

      // multiple of 5
      long j = (n - 1) / 5;
      long y = 5 * ((j * (j + 1)) / 2);

      // multiple of 3 and 5
      long k = (n - 1) / 15;
      long z = 15 * ((k * (k + 1)) / 2);

      long ans = x + y - z;
      System.out.println(ans);
    }

    sc.close();
  }
}
