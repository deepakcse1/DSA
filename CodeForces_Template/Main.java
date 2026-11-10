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
  
  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    // int t = fs.nextInt();
    // while(t-- > 0){
    //   int n = fs.nextInt();
    //   solve(n);
    //   System.out.println();
    // }
    int n = fs.nextInt();
    solve(n, 1, 3, 2);
  }
  private static void solve(int n, int from, int to, int aux){
    if(n == 1) {
      System.out.println("( " + from + " -> "+ to +" )");
      return;
    }
    solve(n-1, from, aux, to);
    System.out.println("( " + from + " -> "+ to +" )");
    solve(n-1, aux, to, from);
  }
}