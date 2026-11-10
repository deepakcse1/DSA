import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//BS on answers - Atomic item
public class FactoryMachines {
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

    int n = fs.nextInt();
    long t = fs.nextLong();
    long[] arr = new long[n];
    long max = 0;
    for(int i = 0; i < n; i++){
      arr[i] = fs.nextLong();
      max = Math.max(max, arr[i]);
    }
    long lo = 1;
    long hi = t * max;
    long ans = hi;
    while(lo <= hi){
      long mid = lo + (hi - lo)/2;
      if(isValid(arr, t, mid)){
        ans = mid;
        hi = mid - 1;
      }
      else lo = mid + 1;
    }
    System.out.println(ans);
  }
  private static boolean isValid(long[] arr, long t, long mid){
    long count = 0;
    for(long time : arr){
      count += mid / time;
      if(count >= t) return true;
    }
    return false;
  }
}
