package WeeklyContest;

public class MinimumRotationToDialANumberTwo {
  private int distance(int a, int b) {
    int diff = Math.abs(a - b);
    return Math.min(diff, 10 - diff);
  }

  public int minRotations(int n, String s) {
    // Cost without reversing anything
    int ans = 0;
    int prevDigit = 0;
    for (char ch : s.toCharArray()) {
      int currDigit = ch - '0';
      ans += distance(prevDigit, currDigit);
      prevDigit = currDigit;
    }
    // Last digit becomes the first digit of the reversed suffix
    int maxSaving = 0;
    int last = s.charAt(n - 1) - '0';
    for (int k = 0; k < n; k++) {
      int prev = (k == 0) ? 0 : s.charAt(k - 1) - '0';
      int currDigit = s.charAt(k) - '0';
      int oldTransaction = distance(prev, currDigit);
      int newTransaction = distance(prev, last);
      int saving = oldTransaction - newTransaction;
      maxSaving = Math.max(maxSaving, saving);
    }
    return ans - maxSaving;
  }
}
