package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProductOfLastKNumbers {
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

  static final long MOD = 1_000_000_007L;
  static List<Long> list;

  static class ProductOfNumbers {
    ProductOfNumbers() {
      list = new ArrayList<>();
      list.add(1L);
    }

    private void add(int x) {
      if (x == 0) {
        list = new ArrayList<>();
        list.add(1L);
        return;
      }
      long lastVal = list.get(list.size() - 1);
      list.add(x * lastVal % MOD);
    }

    private long getProduct(int k) {
      if (k >= list.size()) return 0L;
      long num = list.get(list.size() - 1);
      long den = list.get(list.size() - 1 - k);
      return num * inv(den) % MOD;
    }

    private long inv(long base) {
      return bin_pow(base, MOD - 2);
    }

    private long bin_pow(long base, long exp) {
      long ans = 1L;
      while (exp > 0) {
        if ((exp & 1) == 1) ans = ans * base % MOD;
        base = base * base % MOD;
        exp >>= 1;
      }
      return ans;
    }
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    ProductOfNumbers pn = new ProductOfNumbers();
    while (t-- > 0) {
      String type = fs.next();
      if (type.equals("add")) {
        int x = fs.nextInt();
        pn.add(x);
      } else {
        int k = fs.nextInt();
        long ans = pn.getProduct(k);
        System.out.println(ans);
      }
    }
  }
}
