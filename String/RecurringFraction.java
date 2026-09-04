package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class RecurringFraction {

  static class FastScanner {
    private final BufferedReader br;
    private StringTokenizer st;

    FastScanner(InputStream is) {
      br = new BufferedReader(new InputStreamReader(is));
    }

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

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    char nextChar() {
      return next().charAt(0);
    }

    String nextLine() {
      try {
        st = null;
        return br.readLine();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner(null);
    int t = fs.nextInt();
    while (t-- > 0) {
      int numerator = fs.nextInt();
      int denomenator = fs.nextInt();

      long num = Math.abs((long) numerator);
      long den = Math.abs((long) denomenator);
      if (num == 0) {
        System.out.println("0");
        continue;
      }
      StringBuilder sb = new StringBuilder();
      if ((numerator < 0) ^ (denomenator < 0)) sb.append('-');

      sb.append(num / den);
      long rem = num % den;
      if (rem == 0) {
        System.out.println(sb.toString());
        continue;
      }
      sb.append(".");
      Map<Long, Integer> map = new HashMap<>();
      while (rem != 0) {
        if (map.containsKey(rem)) {
          int pos = map.get(rem);
          sb.insert(pos, '(');
          sb.append(')');
          break;
        }

        map.put(rem, sb.length());
        rem *= 10;
        sb.append(rem / den);
        rem %= den;
      }
      System.out.println(sb.toString());
    }
  }
}
