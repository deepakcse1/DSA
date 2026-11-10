package Number_System;

import java.io.*;
import java.util.*;

class Main {
  static int[] spf;

  private static void build_spf(int MAX) {
    spf = new int[MAX + 1];
    for (int i = 2; i <= MAX; i++) {
      spf[i] = i;
    }
    for (int i = 2; i * i <= MAX; i++) {
      if (spf[i] == i) {
        for (int j = i * i; j <= MAX; j += i) {
          if (spf[j] == j) {
            spf[j] = i;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] arr = new int[N];
    int max = 0;
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
      max = Math.max(max, arr[i]);
    }
    max = Math.max(max, M);
    build_spf(max);

    List<Integer> list = solve(arr, max, M);
    
    System.out.println(list.size());
    for (int i : list) {
      System.out.println(i);
    }
  }

  private static List<Integer> solve(int[] arr, int max, int M) {
    boolean[] badPrime = new boolean[max + 1];
    for (int el : arr) {
      while (el > 1) {
        int p = spf[el];
        badPrime[p] = true;
        while (el % p == 0) {
          el /= p;
        }
      }
    }

    boolean[] bad = new boolean[M + 1];
    for (int i = 2; i <= M; i++) {
      if (badPrime[i]) {
        for (int k = i; k <= M; k += i) {
          bad[k] = true;
        }
      }
    }

    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= M; i++) {
      if (!bad[i]) list.add(i);
    }

    return list;
  }
}
