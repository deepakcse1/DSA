package recursion;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) return false;
    return helper(0, 0, s1, s2, s3);
  }

  public boolean helper(int idx1, int idx2, String s1, String s2, String s3) {
    if (idx1 == s1.length() && idx2 == s2.length()) return true;

    int idx3 = idx1 + idx2;

    if (idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3)) {
      if (helper(idx1 + 1, idx2, s1, s2, s3)) return true;
    }
    if (idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx3)) {
      if (helper(idx1, idx2 + 1, s1, s2, s3)) return true;
    }
    return false;
  }
}
