package ContributionTechnique;

import java.util.Arrays;

public class CountUniqueCharInSubstring {
  public static void main(String[] args) throws Exception {
    int n = 3;
    String str = "aac";
    int[] prev = new int[n];
    int[] next = new int[n];
    int[] last = new int[26];
    Arrays.fill(last, -1);
    for (int i = 0; i < n; i++) {
      int c = str.charAt(i) - 'a';
      prev[i] = last[c];
      last[c] = i;
    }
    Arrays.fill(last, n);
    for (int i = n - 1; i >= 0; i--) {
      int c = str.charAt(i) - 'a';
      next[i] = last[c];
      last[c] = i;
    }
    long ans = 0;
    for (int i = 0; i < n; i++) {
      ans += (long) (i - prev[i]) * (next[i] - i);
    }
    System.out.println(ans);
  }
}
