import java.util.Arrays;

public class CountPairs {
  public static void main(String[] args) throws Exception {
    // FastScanner fs = new FastScanner();
    int t = 1; //fs.nextInt();
    while (t-- > 0) {
      // code
      int n = 1; //fs.nextInt();
      int x = 1; //fs.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        int k = 1; //fs.nextInt();
        arr[i] = k;
      }
      long pairs = 0;
      Arrays.sort(arr);
      int left = 0;
      int right = n - 1;
      while (left < right) {
        if (arr[left] + arr[right] <= x) {
          pairs += right - left;
          left++;
        } else {
          right--;
        }
      }
      System.out.println(2 * pairs);
    }
  }
}
