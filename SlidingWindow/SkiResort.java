package SlidingWindow;

import java.util.Scanner;

//https://codeforces.com/problemset/problem/1840/C
public class SkiResort {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int minDays = sc.nextInt();
      long maxTemp = sc.nextInt();
      long maxCount = 0;
      int len = 0;
      for (int i = 0; i < n; i++) {
        int temp = sc.nextInt();
        if (temp <= maxTemp) {
          len++;
          if (len >= minDays) {
            maxCount += (len - minDays + 1);
          }
        } else {
          len = 0;
        }
      }
      System.out.println(maxCount);
    }
    sc.close();
  }
}
