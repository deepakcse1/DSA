package Combinotorics;

import java.util.Scanner;

// https://codeforces.com/problemset/problem/610/A
public class PashaAndStick {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    if ((n & 1) == 1) {
      System.out.println("0");
    } else {
      System.out.println((n - 2) / 4);
    }
    sc.close();
  }
}
