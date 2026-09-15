// package CodeForces_Template;
import java.io.*;
import java.util.*;

public class Main{
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
    String nextLine() throws IOException {
      return br.readLine();
    }
  }
  static int MAX = 1_000_00;
  static int[] spf = new int[MAX+1];
  private static void buildSPF(){
    for(int i = 2; i <= MAX; i++){
      spf[i] = i;
    }
    for(int i = 2; i * i <= MAX; i++){
      if(spf[i] == i){
        for(int j = i*i; j <= MAX; j += i){
          if(spf[j] == j){
            spf[j] = i;
          }
        }
      }
    }
  }
  public static void main(String[] args) throws Exception {
    buildSPF();
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    int m = fs.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = fs.nextInt();
    }
    boolean[] badPrime = new boolean[MAX+1];
    for(int x : arr){
      while (x > 1) {
        int p = spf[x];
        badPrime[p] = true;
        while(x % p == 0){
          x /= p;
        }
      }
    }
    boolean[] bad = new boolean[m+1];
    for(int p = 2; p <= m; p++){
      if(badPrime[p]){
        for(int k = p; k <= m; k += p){
          bad[k] = true;
        }
      }
    }

    List<Integer> list = new ArrayList<>();
    for(int i = 1; i <= m; i++){
      if(!bad[i]) list.add(i);
    }

    System.out.println(list.size());
    for(int i : list){
      System.out.println(i);
    }
    // System.out.println();
  }
}