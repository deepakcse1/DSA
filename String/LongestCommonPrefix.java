package String;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    String prefix = strs[0];
    int n = strs.length;
    for (int i = 1; i < n; i++) {
      String curr = strs[i];
      int j = 0;
      while (j < prefix.length()
          && j < curr.length()
          && prefix.charAt(j) == curr.charAt(j)) {
        j++;
      }
      prefix = prefix.substring(0, j);
      if (prefix.isEmpty()) return "";
    }
    return prefix;
  }
}
