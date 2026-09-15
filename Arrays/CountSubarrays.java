public class CountSubarrays {
  // https://maang.in/problems/Count-Subarrays-1147
  public static void main(String[] args) throws Exception {
    // FastScanner fs = new FastScanner();
    int t = 1; // fs.nextInt();
    while (t-- > 0) {
      // code
      int n = 1;// fs.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = 1; // fs.nextInt();
      }
      long len = 0;
      long count = 0;
      for (int i = 0; i < n; i++) {
        if (i == 0 || arr[i - 1] > arr[i]) len = 0;
        len++;
        count += len;
      }
      System.out.println(count);
    }
  }
}
