package Combinotorics;

import java.util.Scanner;
// https://codeforces.com/problemset/problem/478/B
public class RandomTeams {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextInt();
    long m = sc.nextInt();
    long q = n / m;
    long r = n % m;
    long x = (m - r) * (q * (q - 1) / 2);
    long y = r * ((q + 1) * q) / 2;
    long min = x + y;
    long max = ((n - m + 1) * (n - m)) / 2;
    System.out.println(min + " " + max);
    sc.close();
  }
}
