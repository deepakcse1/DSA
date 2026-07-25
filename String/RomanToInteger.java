package String;

import java.util.Map;

public class RomanToInteger {
  private static final Map<Character, Integer> map = Map.of(
      'I', 1,
      'V', 5,
      'X', 10,
      'L', 50,
      'C', 100,
      'D', 500,
      'M', 1000);

  public int romanToInt(String s) {
    int n = s.length();
    int number = 0;
    for (int i = 0; i < n; i++) {
      int curr = map.get(s.charAt(i));
      int next = (i + 1 < n) ? map.get(s.charAt(i + 1)) : 0;
      if (curr < next) {
        number -= curr;
      } else {
        number += curr;
      }
    }
    return number;
  }
}
