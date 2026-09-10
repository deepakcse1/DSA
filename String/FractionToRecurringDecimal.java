package String;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) return "0";
    long num = Math.abs((long) numerator);
    long deno = Math.abs((long) denominator);
    StringBuilder sb = new StringBuilder();
    if (numerator < 0 ^ denominator < 0) sb.append('-');
    sb.append(num / deno);
    long rem = num % deno;
    if (rem == 0) {
      return sb.toString();
    }
    sb.append('.');
    Map<Long, Integer> map = new HashMap<>();
    while (rem != 0) {
      if (map.containsKey(rem)) {
        sb.insert(map.get(rem), "(");
        sb.append(")");
        return sb.toString();
      }
      map.put(rem, sb.length());
      rem *= 10;
      sb.append(rem / deno);
      rem %= deno;
    }
    return sb.toString();
  }
}
