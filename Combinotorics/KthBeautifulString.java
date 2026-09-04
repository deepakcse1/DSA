package Combinotorics;

import java.util.Scanner;

public class KthBeautifulString {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      long k = sc.nextLong();
      int b = 2;
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= n; i++) {
        long x;
        if (b == 2) x = (long) (n - i) * (n - i - 1) / 2;
        else if (b == 1) x = n - i;
        else x = 0;
        if (k <= x || b == 0) {
          sb.append("a");
        } else {
          sb.append("b");
          b--;
          k -= x;
        }
      }
      // sb.append("b");
      System.out.println(sb.toString());
    }
    sc.close();
  }
}
