package Number_System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Coprime_two {
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
  
  static int MAX = 1_000_00;
  static int[] spf = new int[MAX+1];

  //Build SPF
  private static void build_spf(){
    for (int i = 2; i <= MAX; i++) {
      spf[i] = i;
    }
    for (int i = 2; i*i <= MAX; i++) {
      if (spf[i] == i) {
        for (int j = i*i ; j <= MAX; j += i) {
          if (spf[j] == j) {
            spf[j] = i;
          }
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    build_spf();
    FastScanner fs = new FastScanner();
    int N = fs.nextInt();
    int M = fs.nextInt();
    int[] arr = new int[N];
    for(int i = 0; i < N; i++){
      arr[i] = fs.nextInt();
    }
    boolean[] badPrime = new boolean[MAX+1];
    for(int x : arr){
      while(x > 1){
        int p = spf[x];
        badPrime[p] = true;
        while(x % p == 0){
          x /= p;
        }
      }
    }
    boolean[] bad = new boolean[M+1];
    for(int p = 2; p <= M; p++){
      if(badPrime[p]){
        for(int k = p; k <= M; k += p){
          bad[k] = true;
        }
      }
    }
    List<Integer> list = new ArrayList<>();
    for(int i = 1; i <= M; i++){
      if(!bad[i]){
        list.add(i);
      }
    }
    System.out.println(list.size());
    for(int i : list){
      System.out.println(i);
    }
  }
}
