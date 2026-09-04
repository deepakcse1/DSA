import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WalkOnMultiplicationTable {
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
  
  private static List<Long[]> all_divisors(long n) {
    List<Long[]> res = new ArrayList<>();
    for(long i = 1; i*i <= n; i++){
      if(n % i == 0){
        res.add(new Long[]{i, n/i});
      } 
    }
    return res;
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    long n = fs.nextLong();
    List<Long[]> list = all_divisors(n);
    Long[] last = list.get(list.size()-1);
    System.out.println(last[0] + last[1] - 2);
  }
}
