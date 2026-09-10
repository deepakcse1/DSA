package Combinotorics;

import java.util.Scanner;
// https://codeforces.com/problemset/problem/478/B
public class RandomTeams {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextInt(); //participants
    long m = sc.nextInt(); //teams
    long q = n / m; 
    long r = n % m;

    //n = 7 | m = 3 -> (3, 2, 2) -> spread evenly and 1 team has +extra reminder left
    long x = r * ((q + 1) * q) / 2; // r teams have q + 1 people -> r * C(q+1,2)
    long y = (m - r) * (q * (q - 1) / 2); // m-r teams have q people -> (m-r) * C(q,2)

    long min = x + y; // spread people as evenly as possible
    long max = ((n - m + 1) * (n - m)) / 2; //max = C(n-m+1, 2)
    System.out.println(min + " " + max); 
    sc.close();
  }
}
