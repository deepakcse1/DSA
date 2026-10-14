package ContributionTechnique;

import java.util.Arrays;

public class CountDistinctCharInSubstring {
  public static void main(String[] args) throws Exception {
    int n = 3;
      String str = "aac";
      long ans = 0;
      int[] prev = new int[26];
      Arrays.fill(prev, -1);
      for (int i = 0; i < str.length(); i++) {
        int index = str.charAt(i) - 'a';
        int leftBoundry = i - prev[index];
        int rightBoundry = n - i;
        ans += (long) leftBoundry * rightBoundry;
        prev[index] = i;
      }
      System.out.println(ans);
  }
}
