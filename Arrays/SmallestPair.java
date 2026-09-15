public class SmallestPair {
  //https://maang.in/problems/Smallest-Pair-1152
  public static void main(String[] args) throws Exception {
        // FastScanner fs = new FastScanner();
        int t = 1; //fs.nextInt();
        while (t-- > 0) {
            // code
            int n = 1 ;//fs.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = 1; //fs.nextInt();
            }
            int min = arr[0] - 1; // We need: min(A[i] - i) for all i < j
            int ans = Integer.MAX_VALUE;
            for(int j = 2; j <= n; j++){
                ans = Math.min(ans, min + arr[j-1] + j);
                min = Math.min(min, arr[j-1] - j); // After calculating the min, update ans using the current j so that it can become the i for future positions.
            }
            System.out.println(ans);
        }
    }
}
