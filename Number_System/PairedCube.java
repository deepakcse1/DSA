package Number_System;

import java.io.*;
import java.util.*;

public class PairedCube {

  static class FastScanner {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String[] tokens;
    private int index = 0;

    String next() throws IOException {
      while (tokens == null || index >= tokens.length) {
        tokens = br.readLine().trim().split("\\s+");
        index = 0;
      }
      return tokens[index++];
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
      return Long.parseLong(next());
    }
  }

  private static int[] spf;
  private static void build_spf(int n) {
    spf = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      spf[i] = i;
    }
    for (int i = 2; i <= n; i++) {
      if (spf[i] == i) {
        for (long j = (long) i * i; j <= n; j += i) {
          if (spf[(int) j] == (int) j) {
            spf[(int) j] = i;
          }
        }
      }
    }
  }

  private static Map<Integer, Integer> prime_fact(int x) {
    Map<Integer, Integer> map = new TreeMap<>();
    while (x > 1) {
      map.put(spf[x], map.getOrDefault(spf[x], 0) + 1);
      x /= spf[x];
    }
    return map;
  }

  private static String[] getSig_comp(int x) {
    Map<Integer, Integer> map = prime_fact(x);
    StringBuilder sign = new StringBuilder();
    StringBuilder comp = new StringBuilder();
    for (int p : map.keySet()) {
      int exp = map.get(p) % 3;
      if (exp == 0)
        continue;
      int complement = (exp == 1) ? 2 : (exp == 2) ? 1 : 0;
      sign.append(p).append(":").append(exp).append(",");
      comp.append(p).append(":").append(complement).append(",");
    }
    if (sign.length() == 0)
      return new String[] { "", "" };
    String s = sign.substring(0, sign.length() - 1);
    String c = comp.substring(0, comp.length() - 1);
    return new String[] { s, c };
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      int x = fs.nextInt();
      arr[i] = x;
    }
    int max = 0;
    for (int i : arr) {
      max = Math.max(max, i);
    }
    build_spf(max);
    Map<String, Integer> freq = new HashMap<>();
    long ans = 0;
    for (int x : arr) {
      String[] str = getSig_comp(x);
      String signature = str[0];
      String complement = str[1];
      ans += freq.getOrDefault(complement, 0);
      freq.put(signature, freq.getOrDefault(signature, 0) + 1);
    }
    System.out.println(ans);
  }
}
