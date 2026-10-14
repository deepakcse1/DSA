package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AddMulImpl {
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
  static class AddMul {
    static final long MOD = 1_000_000_007L;
    List<Long> list;
    long add;
    long mul;

    AddMul() {
      add = 0L;
      mul = 1L;
      list = new ArrayList<>();
    }

    private void append(long val) {
      val = ((val - add) % MOD + MOD) % MOD;
      val = val * inv(mul) % MOD;
      list.add(val);
    }

    private void add(long inc) {
      add = (add + inc) % MOD;
    }

    private void mult(long m) {
      add = add * m % MOD;
      mul = mul * m % MOD;
    }

    private long get(long idx) {
      if (idx >= list.size()) return -1;
      long ans = (list.get((int) idx) * mul + add) % MOD;
      return (long) ans;
    }

    private long inv(long base) {
      return bin_pow(base, MOD - 2);
    }

    private long bin_pow(long base, long exp) {
      long res = 1;
      while (exp > 0) {
        if ((exp & 1) == 1) res = res * base % MOD;
        base = base * base % MOD;
        exp >>= 1;
      }
      return res;
    }
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int q = fs.nextInt();
    AddMul am = new AddMul();
    while (q-- > 0) {
      String type = fs.next();
      if (type.equals("append")) {
        long el = fs.nextLong();
        am.append(el);
      } else if (type.equals("add")) {
        long el = fs.nextLong();
        am.add(el);
      } else if (type.equals("mult")) {
        long el = fs.nextLong();
        am.mult(el);
      } else if (type.equals("get")) {
        long el = fs.nextLong();
        long ans = am.get(el);
        System.out.println(ans);
      }
    }
  }
}
