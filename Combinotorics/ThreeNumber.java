// Description
// Given two numbers K and S.Determine how many different values of X, Y, and Z such that(0 ≤ X,Y,Z ≤ K) and X + Y + Z = S
package Combinotorics;

import java.util.Scanner;

public class ThreeNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int K = sc.nextInt();
    int S = sc.nextInt();
    solve_optimal(K, S);
    sc.close();
  }

  public static void solve_optimized(int K, int S) {
    int count = 0;
    for (int x = 0; x <= K; x++) {
      int T = S - x;
      int low = Math.max(0, T - K);
      int high = Math.min(K, T);
      if (low <= high) {
        count += high - low + 1;
      }
    }
    System.out.println(count);
  }

  public static void solve_optimal(int K, int S){
    int count = 0;
    for (int x = 0; x <= K; x++) {
      for (int y = 0; y <= K; y++) {
        int z = S - x - y;
        if (z >= 0 && z <= K) count++;
      }
    }
    System.out.println(count);
  }

  public static void solve_brute_force(int K, int S){
    int count = 0;
    int min = Math.min(K, S);
    for (int i = 0; i <= min; i++) {
      for (int j = 0; j <= min; j++) {
        for (int k = 0; k <= min; k++) {
          if ((i + j + k) == S) count++;
        }
      }
    }
    System.out.println(count);
  }
}
