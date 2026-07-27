public class LargestIntegerWithGivenDigitSum {
  public int largestInteger(int n, int s) {
    if (s == 0) return 0;
    if (s > 9 * n) return -1;
    String number = "";
    while (n > 0) {
      int digit = Math.min(9, s);
      number += digit;
      s -= digit;
      n--;
    }
    return Integer.parseInt(number);
  }
}
