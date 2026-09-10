package Number_System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coprime {
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
  
  static int MAX = 1_000_000;
  static int[] spf = new int[MAX+1];
  private static void build_spf(){
    for(int i = 2; i < MAX; i++){
    spf[i] = i;
    }
    for(int i = 2; i*i <= MAX; i++){
      if(spf[i] == i){
        for(int j = i*i; j <= MAX; j += i){
          if(spf[j] == j){
            spf[j] = i;
          }
        }
      }
    }
  }

 private static int gcd(int a, int b){
    while(b != 0){
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
 }

  public static void main(String[] args) throws Exception {
    build_spf();
    FastScanner fs = new FastScanner();
    int N = fs.nextInt();
    int[] arr = new int[N];
    for(int i = 0; i < N; i++){
      arr[i] = fs.nextInt();
    }
    int g = arr[0];
    for(int i = 1; i < N; i++){
      g = gcd(g, arr[i]);
    }
    if(g > 1){
      System.out.println("not coprime");
      return;
    }
    boolean[] bad = new boolean[MAX+1];
    for(int i = 0; i < N; i++){
      int x = arr[i];
      while(x > 1){
        int p = spf[x];
        if(bad[p]){
          System.out.println("setwise coprime");
          return;
        }
        bad[p] = true;
        while(x % p == 0){
          x /= p;
        }
      }
    }
    System.out.println("pairwise coprime");
  }
}
