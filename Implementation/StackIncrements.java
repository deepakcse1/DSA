package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackIncrements {
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
  static class Pair {
    int value;
    int delta;

    Pair(int value, int delta) {
      this.value = value;
      this.delta = delta;
    }
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int capacity = fs.nextInt();
    Pair[] stack = new Pair[capacity];
    int size = 0;
    int q = fs.nextInt();
    while (q-- > 0) {
      String type = fs.next();
      if (type.equals("push")) {
        int el = fs.nextInt();
        if (size < capacity) {
          stack[size] = new Pair(el, 0);
          size++;
        }
      } else if (type.equals("pop")) {
        if (size > 0) {
          int lastIdx = size - 1;
          if (lastIdx > 0)
            stack[lastIdx - 1].delta += stack[lastIdx].delta;
          stack[lastIdx].value += stack[lastIdx].delta;
          System.out.println(stack[lastIdx].value);
          size--;
        } else {
          System.out.println(-1);
        }
      } else {
        int k = fs.nextInt();
        int val = fs.nextInt();
        if (size == 0)
          continue;
        if (k >= size)
          stack[size - 1].delta += val;
        else
          stack[k - 1].delta += val;
      }
      // System.out.println();
    }
  }
}
