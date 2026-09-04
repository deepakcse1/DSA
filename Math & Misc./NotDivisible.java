import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotDivisible {
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
  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int N = fs.nextInt();
    int MAX = 1_000_000;
    int[] freq = new int[MAX+1];
    for(int i = 1; i <= N; i++){
      int x = fs.nextInt();
      freq[x]++;
    }
    boolean[] bad = new boolean[MAX+1];
    for(int d = 1; d <= MAX; d++){
      if(freq[d] == 0) continue;
      if(freq[d] >= 2) bad[d] = true;
      for(int multiple = 2*d; multiple <= MAX; multiple += d){
        if(freq[multiple] > 0) bad[multiple] = true;
      }
    }
    int count = 0;
    for(int i = 1; i <= MAX; i++){
      if(freq[i] > 0 && !bad[i]) count++;
    }
    System.out.println(count);
  }
}
