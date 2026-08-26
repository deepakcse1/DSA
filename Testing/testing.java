package Testing;

// public class testing {
  
// }


import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedInputStream(System.in));
    sc.useLocale(Locale.US);

    int n = sc.nextInt();
    long l = sc.nextLong();
    char ch = sc.next().charAt(0);
    float f = sc.nextFloat();
    double d = sc.nextDouble();
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    out.println(n);
    out.println(l);
    out.println(ch);
    out.printf(Locale.US, "%.6f%n", f); // print float with 6 decimal places
    out.printf("%.6f%n", d); // print double with 6 decimal places
    out.flush();

    sc.close();
  }
}


class Main2 {

  static final FastScanner fs = new FastScanner();
  static final PrintWriter out = new PrintWriter(System.out);

  static final int MOD = 1_000_000_007;
  static final int INF = (int) 1e9;

  public static void main(String[] args) {

    int a = fs.nextInt();
    long b = fs.nextLong();
    char c = fs.next().charAt(0);
    float d = fs.nextFloat();
    double e = fs.nextDouble();

    out.println(a);
    out.println(b);
    out.println(c);
    out.println(d);
    out.printf("%.6g%n", e);

    out.flush();
  }

  static void solve() {

  }

  static class FastScanner {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    String next() {

      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }

      return st.nextToken();
    }

    float nextFloat() {
      return Float.parseFloat(next());
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}
