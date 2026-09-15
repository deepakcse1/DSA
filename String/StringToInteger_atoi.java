package String;

public class StringToInteger_atoi {
  public int myAtoi(String s) {
    int n = s.length();
    boolean isNegative = false;
    int i = 0;
    while (i < n && s.charAt(i) == ' ') i++;
    if (i == n) return 0;
    if (s.charAt(i) == '-' || s.charAt(i) == '+') {
      isNegative = s.charAt(i) == '-';
      i++;
    }
    long num = 0;
    long limit = isNegative ? -(long) Integer.MIN_VALUE : Integer.MAX_VALUE;
    while (i < n && Character.isDigit(s.charAt(i))) {
      int digit = s.charAt(i) - '0';
      num = num * 10 + digit;
      if (num > limit) {
        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      i++;
    }
    return isNegative ? -(int) num : (int) num;
  }
}
