package String;

public class SumOfBeautyOfAllSubstrings {
  public int beautySum(String s) {
    int n = s.length();
    int totalBeauty = 0;
    for (int i = 0; i < n; i++) {
      int[] freq = new int[26];
      for (int j = i; j < n; j++) {
        char ch = s.charAt(j);
        freq[ch - 'a']++;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int k : freq) {
          if (k != 0 && k < min) min = k;
          if (k != 0 && k > max) max = k;
        }
        totalBeauty += max - min;
      }
    }
    return totalBeauty;
  }
}
