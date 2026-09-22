package String;

public class RepeatedStringMatch {
  private int[] buildLPS(char[] pattern) {
    int m = pattern.length;
    int[] lps = new int[m];
    int j = 0;
    int i = 1;
    while (i < m) {
      if (pattern[i] == pattern[j]) {
        j++;
        lps[i++] = j;
      } else {
        if (j == 0) i++;
        else j = lps[j - 1];
      }
    }
    return lps;
  }

  private boolean kmpSearch(StringBuilder text, String pattern, int[] lps) {
    int i = 0;
    int j = 0;
    while (i < text.length()) {
      if (text.charAt(i) == pattern.charAt(j)) {
        i++; j++;
        if (j == pattern.length()) return true;
      } else {
        if (j == 0) i++;
        else j = lps[j - 1];
      }
    }
    return false;
  }

  public int repeatedStringMatch(String a, String b) {
    int[] lps = buildLPS(b.toCharArray());
    StringBuilder sb = new StringBuilder(a);
    int count = 1;
    while (sb.length() < b.length()) {
      sb.append(a);
      count++;
    }
    if (kmpSearch(sb, b, lps)) return count;
    sb.append(a);
    count++;
    if (kmpSearch(sb, b, lps)) return count;
    return -1;
  }
  // public int repeatedStringMatch(String a, String b) {
  // StringBuilder sb = new StringBuilder(a);
  // int count = 1;
  // while(sb.length() < b.length()){
  // sb.append(a);
  // count++;
  // }
  // if(sb.indexOf(b) != -1) return count;
  // // Why do we need that extra copy?
  // // Because b can start near the end of one repetition of a and continue into
  // the next repetition.
  // sb.append(a);
  // count++;
  // if(sb.indexOf(b) != -1) return count;
  // return -1;
  // }
}
