package recursion;

public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    return helper(0, 0, s, p);
  }

  public boolean helper(int i, int j, String s, String p) {
    if (j == p.length()) return i == s.length();
    boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
    if (j + 1 < p.length() && p.charAt(j + 1) == '*') { return helper(i, j + 2, s, p) || (match && helper(i + 1, j, s, p));
    } else {
      return match && helper(i + 1, j + 1, s, p);
    }
  }
}
