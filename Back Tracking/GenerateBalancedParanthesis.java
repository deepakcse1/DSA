import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateBalancedParanthesis {
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

  // try{ }
  // catch(Exception e) System.out.println(e)
  // private static void solve(int idx, int n, int o, int c, StringBuilder sb) {
  //   if (idx == n) {
  //     System.out.println(sb);
  //     return;
  //   }

  //   if (o < n / 2) {
  //     solve(idx + 1, n, o + 1, c, sb.append('('));
  //     sb.deleteCharAt(sb.length() - 1);
  //   }
  //   if (c < o) {
  //     solve(idx + 1, n, o, c + 1, sb.append(')'));
  //     sb.deleteCharAt(sb.length() - 1);
  //   }
  // }

  // public static void main(String[] args) throws Exception {
  //   FastScanner fs = new FastScanner();

  //   int n = fs.nextInt();
  //   solve(0, n, 0, 0, new StringBuilder());
  // }

  private static void solve(int n, int o, int c, String curr){
    if(o == n/2 && c == n/2){
      System.out.println(curr);
      return;            
    }
       
    if(o < n/2) solve(n, o+1, c, curr+"(");
    if(c < o) solve(n, o, c+1, curr+")");
  }
  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    solve(n, 0, 0, "");
  }
}
