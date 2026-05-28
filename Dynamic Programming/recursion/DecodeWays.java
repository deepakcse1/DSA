package recursion;

public class DecodeWays {
  public static void main(String[] args) {

  }

  public int numDecodings(String s) {
    return helper(0, s);
  }

  public int helper(int index, String s) {
    if (index == s.length()) return 1;
    if (s.charAt(index) == '0') return 0;
    int op1 = helper(index + 1, s);
    int op2 = 0;
    if (index + 2 <= s.length()) {
      int num = Integer.parseInt(s.substring(index, index + 2));
      if (num >= 10 && num <= 26) {
        op2 = helper(index + 2, s);
      }
    }
    return op1 + op2;
  }
}
