package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RunningMeanMedianMode {
  static final long MOD = 1_000_000_007L;
  static final long INV2 = 500_000_004L;

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

  static class Query {
    String op;
    long x;

    Query(String op, long x) {
      this.op = op;
      this.x = x;
    }
  }

  static class Fenwick {
    int n;
    long[] bit;

    Fenwick(int n) {
      this.n = n;
      this.bit = new long[n + 1];
    }

    void update(int i, long delta) {
      while (i <= n) {
        bit[i] += delta;
        i += i & -i;
      }
    }

    int kth(int k) {
      int accumulated = 0;
      int idx = 0;
      int step = Integer.highestOneBit(n);
      while (step > 0) {
        int next = idx + step;
        if (next <= n && accumulated + bit[next] < k) {
          idx = next;
          accumulated += bit[next];
        }
        step >>= 1;
      }
      return idx + 1;
    }
  }

  static class Statistics {
    Map<Long, Integer> freqMap = new HashMap<>();
    TreeMap<Integer, TreeSet<Long>> modeMap = new TreeMap<>();

    Fenwick fenwick;
    Map<Long, Integer> compressed = new HashMap<>();
    List<Long> values;

    int n = 0;
    long sumMod = 0;

    Statistics(List<Long> sortedValues) {
      this.values = sortedValues;
      fenwick = new Fenwick(values.size());
      for (int i = 0; i < values.size(); i++) {
        compressed.put(values.get(i), i + 1);
      }
    }

    long norm(long x) {
      return ((x % MOD) + MOD) % MOD;
    }

    long bin_pow(long base, long exp) {
      base = norm(base);
      long res = 1;
      while (exp > 0) {
        if ((exp & 1) == 1)  res = res * base % MOD;
        base = base * base % MOD;
        exp >>= 1;
      }
      return res;
    }

    void updateMode(long x, int oldFreq, int newFreq) {
      if (oldFreq > 0) {
        TreeSet<Long> set = modeMap.get(oldFreq);
        set.remove(x);
        if (set.isEmpty()) modeMap.remove(oldFreq);
      }
      if (newFreq > 0) {
        modeMap.computeIfAbsent(newFreq, f -> new TreeSet<>()).add(x);
      }
    }

    void insert(long x) {
      int oldFreq = freqMap.getOrDefault(x, 0);
      int newFreq = oldFreq + 1;

      updateMode(x, oldFreq, newFreq);
      freqMap.put(x, newFreq);

      fenwick.update(compressed.get(x), 1);
      n++;
      sumMod = (sumMod + norm(x)) % MOD;
    }

    void remove(long x) {
      int oldFreq = freqMap.get(x);
      int newFreq = oldFreq - 1;
      updateMode(x, oldFreq, newFreq);
      if (newFreq == 0) freqMap.remove(x);
      else freqMap.put(x, newFreq);
      fenwick.update(compressed.get(x), -1);
      n--;
      sumMod = norm(sumMod - norm(x));
    }

    long getMean() {
      if (n == 0) return -1;
      return sumMod * bin_pow(n, MOD - 2) % MOD;
    }

    long getMedian() {
      if (n == 0) return -1;
      if ((n & 1) == 1) {
        int idx = fenwick.kth((n + 1) / 2);
        return norm(values.get(idx - 1));
      }

      int leftIdx = fenwick.kth(n / 2);
      int rightIdx = fenwick.kth(n / 2 + 1);

      long a = norm(values.get(leftIdx - 1));
      long b = norm(values.get(rightIdx - 1));

      return ((a + b) % MOD) * INV2 % MOD;
    }

    long getMode() {
      if (n == 0) return -1;
      return modeMap.lastEntry().getValue().first();
    }
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    StringBuilder out = new StringBuilder();
    int T = fs.nextInt();
    while (T-- > 0) {
      int Q = fs.nextInt();
      Query[] queries = new Query[Q];
      TreeSet<Long> allValues = new TreeSet<>();

      for (int i = 0; i < Q; i++) {
        String op = fs.next();
        if (op.equals("insert") || op.equals("remove")) {
          long x = fs.nextLong();
          queries[i] = new Query(op, x);
          allValues.add(x);
        } else {
          queries[i] = new Query(op, 0);
        }
      }

      List<Long> sortedValues = new ArrayList<>(allValues);
      Statistics ds = new Statistics(sortedValues);

      for (Query qx : queries) {
        if(qx.op.equals("insert")) ds.insert(qx.x);
        else if(qx.op.equals("remove")) ds.remove(qx.x);
        else if(qx.op.equals("getMean")) out.append(ds.getMean()).append("\n");
        else if(qx.op.equals("getMedian")) out.append(ds.getMedian()).append("\n");
        else if(qx.op.equals("getMode")) out.append(ds.getMode()).append("\n");
      }
    }
    System.out.println(out);
  }
}
