package WeeklyContest;

public class MinimumRotationToDialANumberOne {
  public int minRotations(String s) {
    int n = s.length();
    int prev = 0;
    int count = 0;
    for (int i = 0; i < n; i++) {
      int digit = s.charAt(i) - '0';
      // int num = Math.abs(prev - digit);
      // int clockwise = num;
      // int antiClockwise = 10 - num;
      // Math.min(clockwise, antiClockwise);
      count += distance(prev, digit);
      prev = digit;
    }
    return count;
  }

  private int distance(int a, int b) {
    int diff = Math.abs(a - b);
    return Math.min(diff, 10 - diff);
  }
}
